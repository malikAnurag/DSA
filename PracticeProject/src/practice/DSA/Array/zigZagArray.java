package practice.DSA.Array;

public class zigZagArray {

	public static void main(String[] args) {

		int[] array = new int[] { 4, 3, 7, 8, 6, 2, 1 };
		System.out.print("Original array: ");
		for (int i : array)
			System.out.print(i + " ");

		zigZag(array);

		System.out.print("\nZig zag array: ");
		for (int i : array)
			System.out.print(i + " ");
	}

	public static void zigZag(int[] arr) {

		boolean flag = true;

		for (int i = 0; i < arr.length - 1; i++) {
			if (flag) {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}
			}
			flag = !flag;
		}
		
//		Arrays.sort(A);
//        
//        for(int i=0;i<A.length-1;i+=2){
//            int temp = A[i];
//            A[i]=A[i+2];
//            A[i+2] = temp;
//        }
		
	}
}
