package practice.DSA.String.advanced;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {

            int j = i, lineLen = 0;

            // Count how many words fit in the current line
            while (j < n && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j++].length();
            }

            int spaceSlots = j - i - 1; // no of gaps between words
            int totalSpaces = maxWidth - lineLen; // total spaces to be distributed between words
            StringBuilder line = new StringBuilder();

            // Last line or single word → left-justified
            if (j == n || spaceSlots == 0) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1)
                        line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {

                int evenSpace = totalSpaces / spaceSlots; // between each pair of words
                int extra = totalSpaces % spaceSlots; // first extra slots get one extra space [left-aligned]

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        // If the line has words from index i to k, then (k - i) counts how far left the current word is.
                        // This ensures that the leftmost gaps get the extra spaces first (because they satisfy (k - i < extra) earlier).
                        int spaces = evenSpace + (k - i < extra ? 1 : 0);
                        line.append(" ".repeat(spaces));
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }
        return result;
    }

}
