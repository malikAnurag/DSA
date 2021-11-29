package practice.DSA.String.advanced.substring;

public class SmallestSubstringWithAllCharactersOfString {

    // Function
    static String getMinimumWindow(char[] str1, char[] str2) {

        int[] map = new int[256];

        // Answer
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;

        // creating map
        for(int i = 0; i < str2.length; i++) {

            if(map[str2[i]] == 0)
                count++;

            map[str2[i]]++;
        }

        // References of Window
        int i = 0;
        int j = 0;

        // Traversing the window
        while(j < str1.length) {

            // Calculations
            map[str1[j]]--;

            if(map[str1[j]] == 0)
                count--;

            // Condition matching
            if(count == 0) {

                while(count == 0) {

                    // Sorting ans
                    if(ans > j - i + 1) {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }

                    // Sliding I
                    // Calculation for removing I
                    map[str1[i]]++;
                    if(map[str1[i]] > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }

        if(ans != Integer.MAX_VALUE)
            return String.valueOf(str1).substring(start, ans + start);
        else
            return "-1";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.print("-->Smallest window that contain all character : ");
        System.out.print(getMinimumWindow(s.toCharArray(), t.toCharArray()));
    }
}
