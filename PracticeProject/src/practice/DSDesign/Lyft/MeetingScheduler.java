package practice.DSDesign.Lyft;

import java.util.*;

/**
 * Build a MeetingScheduler that manages a fixed number of rooms. The constructor takes the number of rooms and a placement policy: "first_available" or "least_used". Implement:
 * • book(meetingId, startTime, endTime): assigns a room and returns its ID, or returns -1 if no room is free
 * • cancel(meetingId): frees the room for that slot
 * • getRoomSchedule(roomId): returns that room's meetings sorted by start time
 *
 * Back-to-back meetings (one ends exactly when another starts) are allowed.
 */

/**
 * Assumptions :
 * intervals are [start, end)
 * ties go to the lowest room ID
 * least_used counts historical successful bookings (not decremented on cancellation)
 * <p>
 * (These details are not defined in the official practice question)
 */

public class MeetingScheduler {

    // Each room has meetings sorted by start time.
    private final List<TreeMap<Long, Meeting>> rooms = new ArrayList<>(); // List<StartTime : Meeting>

    // Find bookings by meeting ID for cancellation.
    private final Map<String, Meeting> meetings = new HashMap<>(); // MeetingID : Meeting

    // Number of successful bookings per room.
    private final long[] roomUsage;

    private final boolean leastUsed;


    public record Meeting(String id, long start, long end, int room) {
    }

    // Overall Space : O (R + N) [Rooms + Total active meetings]
    public MeetingScheduler(int roomCount, String policy) { // Time & Space : O (Rooms)

        // Validations

        leastUsed = policy.equals("least_used");
        roomUsage = new long[roomCount];

        for (int i = 0; i < roomCount; i++) {
            rooms.add(new TreeMap<>());
        }
    }

    // M max meetings in one room
    public int book(String id, long start, long end) { // Time : O (R Log(M + 1)), Space : O(1)

        if (id == null || id.isBlank() || start >= end || meetings.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        int selected = -1;

        for (int i = 0; i < rooms.size(); i++) {

            TreeMap<Long, Meeting> schedule = rooms.get(i);

            // Find closest existing meetings before and after start.
            Map.Entry<Long, Meeting> prev = schedule.floorEntry(start);
            Map.Entry<Long, Meeting> next = schedule.ceilingEntry(start);

            // Skip this room if either meeting overlaps.
            if ((prev != null && prev.getValue().end() > start) || (next != null && next.getKey() < end)) {
                continue;
            }

            // First available room (lowest room ID).
            if (!leastUsed) { // firstAvailable
                selected = i;
                break;
            }

            // Choose available room with fewest past bookings.
            if (selected == -1 || roomUsage[i] < roomUsage[selected]) {
                selected = i;
            }
        }

        if (selected == -1)
            return -1;

        // Book meeting in the chosen room.
        Meeting meeting = new Meeting(id, start, end, selected);
        rooms.get(selected).put(start, meeting);
        meetings.put(id, meeting);
        roomUsage[selected]++;

        return selected;
    }

    public boolean cancel(String id) { // Time : O (Log(M + 1)), Space : O(1)

        Meeting meeting = meetings.remove(id);

        if (meeting == null)
            return false;

        // Remove meeting from its room's schedule.
        rooms.get(meeting.room()).remove(meeting.start());
        return true;
    }

    // M1 - Meetings in the requested room
    public List<Meeting> getRoomSchedule(int roomId) { // Time : O (M1), Space : O (M1)
        // TreeMap values are already sorted by start time.
        return new ArrayList<>(rooms.get(roomId).values());
    }
}
