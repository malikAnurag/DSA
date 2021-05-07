package practice.Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfLists {
    public static void main(String[] args) {

//        List<List<Integer>> seqList = new ArrayList<List<Integer>>(10);
//
//        for(int i =0; i < seqList.size() ; i++)
//            seqList.add(i, Collections.<Integer>emptyList() );
//
//        System.out.println(seqList);



        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>(5);

        System.out.println("Size of listOfLists: "+ listOfLists.size());

        for(int i = 0; i < 5; i++)  {
            listOfLists.add(new ArrayList<Integer>());
        }

        System.out.println(listOfLists);




    }
}
