package HackerRank;

import java.util.Arrays;

// Note: you need to reverse the array and if negative should be positive and vis versa, you can't define new arrays
public class HR3_SwapPalces 
{

	public static void main(String[] args)
	{
		int [] arr = {2,-3,7,8,-9,4,1};
		int tmp = 0;


		boolean isOddArr = arr.length%2 > 0 ? true : false;

		for (int i = 0; i < arr.length/2; i++) {

			tmp = arr[i];

			arr[i] = arr[arr.length -1 -i] * -1;

			arr[arr.length -1 -i] = tmp * -1;

		}

		if (isOddArr){
			arr[(arr.length/2)] = arr[(arr.length/2)] * -1;
		}

		Arrays.stream(arr).forEach((i)-> System.out.print(i + " "));
	}
}
