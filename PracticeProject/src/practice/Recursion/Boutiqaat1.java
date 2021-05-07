package practice.Recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Question: [1,2,[3,4,5,[6,7,[8,9,[10]]]]]
 * Result should be [1,2,3,4,5,6,7,8,9,10]
 */
public class Boutiqaat1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(str);

        List<List> input = new ArrayList<>();
        input.add(new ArrayList());
        char[] cArray = str.toCharArray();

        for(char c : cArray) {
            if(c == '[') {
                input.get(input.size() - 1).add(new ArrayList());
            } else if(Character.isDigit(c)) {
                input.get(input.size() - 1).add(Integer.valueOf(String.valueOf(c)));
            }
        }

        System.out.println("Input : " + input);

        List<Object> result = (List<Object>) flatten(input);

        System.out.println("Result: " + result);

    }


    private static Collection<Object> flatten(Object object) {
        Collection<Object> collection = new ArrayList<>();

        if(object instanceof List) {
            for(Object obj : (List)object) {
                collection.addAll(flatten(obj));
            }
        }
        else {
            collection.add(object);
        }
        return collection;
    }
}
