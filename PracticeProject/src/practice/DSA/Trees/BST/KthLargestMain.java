package practice.DSA.Trees.BST;

public class KthLargestMain {

    public static void main(String[] args) {

        // Finding THIRD largest element here

        KthLargestElementInStream kthLargest = new KthLargestElementInStream(new int[]{4, 5, 8, 2}, 3);
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}

// 2 4 5 8 - ORIGINAL

// 2 3 4 5 8
// 2 3 4 5 5 8
// 2 3 4 5 5 8 10
// 2 3 4 5 5 8 9 10
// 2 3 4 4 5 5 8 9 10