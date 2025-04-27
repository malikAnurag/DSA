package amazon.arraysAndStrings;


/**
 * |***|*|****|
 */
public class ItemsInAConfinement {

    public static void main(String[] args) {
        String input = "*|****|**|**";
        int result = countItemsWithinConfinement(input);
        System.out.println("Items within confinement: " + result); // Output: 4
    }

    public static int countItemsWithinConfinement(String s) {

        int totalCount = 0;
        int start = s.indexOf('|');

        while (start != -1) {

            int end = s.indexOf('|', start + 1); // Find next '|' after start

            if (end == -1) {
                break; // No matching end, so stop
            }

            // Get substring between start and end, and count '*'
            String confinedSection = s.substring(start + 1, end);
            System.out.println("ConfinedSection : " + confinedSection);
            totalCount += confinedSection.length();

            // Move start to after this end
            start = end;
        }
        return totalCount;
    }
}
