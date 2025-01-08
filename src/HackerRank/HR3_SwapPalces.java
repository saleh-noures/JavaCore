package HackerRank;

import java.util.Arrays;

// Note: you need to reverse the array and if negative should be positive and vis versa, you can't define new arrays
public class HR3_SwapPalces 
{

	public static void main(String[] args) {
		int[] arr = {2, -3, 7, 8, -9, 4, 1};
		int tmp = 0;


		int left = 0, right = arr.length - 1;

		while (left <= right) {
			// Swap and invert the signs of both ends
			int temp = -arr[left];
			arr[left] = -arr[right];
			arr[right] = temp;

			// Move pointers towards the center
			left++;
			right--;
		}

		Arrays.stream(arr).forEach((i) -> System.out.print(i + " "));
	}
}
