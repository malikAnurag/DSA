package practice.DSA.Array;

public class moveZerosToEnd {

	public static void main(String[] args) {

		int[] arr = new int[]{0, 1, 2, 0, 44, 3, 0, 5, 6, 7, 0, 99};

		moveZeros(arr);

		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void moveZeros(int[] A) {

		int temp;
		int counter = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				temp = A[i];
				A[i] = A[counter];
				A[counter] = temp;

				counter++;
			}
		}
	}
}
