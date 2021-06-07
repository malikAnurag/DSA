package practice.DSA.Graph;

import java.util.*;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 *
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where
 * N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 *
 * You can walk back and forth between rooms freely.
 *
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 *
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 *
 * Example 2:
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 */
public class KeysAndRooms {

    public static void main(String[] args) {

        List<Integer> al1 = new ArrayList(){{
            add(1);
        }};
        List<Integer> al2 = new ArrayList(){{
            add(2);
        }};
        List<Integer> al3 = new ArrayList(){{
            add(3);
        }};

        List<Integer> al4 = new ArrayList();

        List<List<Integer>> al = new ArrayList<>();
        al.add(al1);al.add(al2);al.add(al3);al.add(al4);
        System.out.println(canVisitAllRooms(al));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if (rooms == null || rooms.size() == 0) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(0);

        while (!q.isEmpty()) {

            int room = q.poll();

            visited.add(room);

            List<Integer> newRooms = rooms.get(room);

            for (int newRoom : newRooms) {
                if (!visited.contains(newRoom)) {
                    q.add(newRoom);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
