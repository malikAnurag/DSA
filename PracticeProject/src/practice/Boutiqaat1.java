package practice;

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
                input.get(input.size()-1).add(new ArrayList());
            } else if(Character.isDigit(c)){
                input.get(input.size() - 1).add(Integer.valueOf(String.valueOf(c)));
            }
        }

        System.out.println("Input : "+ input.toString());


//        //1,2,3,4,5,6
//
//        List al1 = new ArrayList<>();
//        al1.add(1);al1.add(2);
//
//        List al2 = new ArrayList<>();
//        al2.add(3);al2.add(4);al2.add(5);
//
//        List al3 = new ArrayList<>();
//        al3.add(6);al3.add(7);
//
//        List al4 = new ArrayList<>();
//        al4.add(8);al4.add(9);
//
//        List al5 = new ArrayList<>();
//        al5.add(10);
//
//        al4.add(al5);
//        al3.add(al4);
//        al2.add(al3);
//        al1.add(al2);
//        input.add(al1);

//        System.out.println(input.toString());

        List<Object> result = (List<Object>) flatten(input);

        System.out.println("Result: "+ result.toString());

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
