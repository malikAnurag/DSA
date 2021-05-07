package practice.Math;

/**
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 */
public class HandsOfClock {

    public static void main(String[] args) {
        System.out.println(getAngle(12, 30));
        System.out.println(getAngle(3, 30));
        System.out.println(getAngle(3, 15));
        System.out.println(getAngle(4, 50));
        System.out.println(getAngle(12, 0));
    }

    public static double getAngle(int hour, int minutes) {

        if(hour == 12) {
            hour = 0;
        }

        if(hour > 12) {
            hour -= 12;
        }

        if(minutes == 60) {
            minutes = 0;
            hour += 1;
        }

        int totalMinutes = (60 * hour) + minutes;

        /* Hour hand */
        // 360 deg in 12 hrs (12 * 60 = 720 minutes)
        // 1 deg in 12/360 (.033 hrs) or 720/360 (2 mins)
        // So, 0.5 degrees in 1 min
        double angleH = 0.5 * totalMinutes; // angle by which hour hand moves in total minutes

        /* Minute Hand */
        // 360 deg in 60 mins
        // 1 min : 360/60 deg = 6 deg
        double angleM = 6 * minutes;

        double angle = Math.abs(angleH - angleM);

        return Math.min(360 - angle, angle);
    }
}
