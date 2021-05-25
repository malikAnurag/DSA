package practice.Recursion;

import java.util.ArrayList;
import java.util.List;
/**
 *     a1b
 *     {​a1b,A1b,a1B,A1B}​
 *
 *     a1B2c
 */
public class GenerateStringsWithCapitalAndSmallCharacters {

    public static void main(String[] args) {

        List<String> al = new ArrayList<>();
        al.add("a1B2c");

        generate("a1B2c", al, 0);

        for(String s: al) {
            System.out.println(s);
        }
    }

    public static void generate(String str, List<String> al, int s) {

        // base
        if(s == str.length())
            return;

        for(int i = s ; i < str.length() ; i++) {

            char c1 = str.charAt(i);

            if(Character.isDigit(c1))
                continue;

            StringBuilder sb = new StringBuilder(str);

            if(Character.isLowerCase(c1)) {
                sb.setCharAt(i, Character.toUpperCase(c1));
            } else {
                sb.setCharAt(i, Character.toLowerCase(c1));
            }

            al.add(sb.toString());
            generate(sb.toString(), al, i+1);
        }
    }
}