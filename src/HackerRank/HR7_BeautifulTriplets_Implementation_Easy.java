package HackerRank;

import java.util.Scanner;

public class HR7_BeautifulTriplets_Implementation_Easy {

	//https://www.hackerrank.com/challenges/beautiful-triplets

	static int beautifulTriplets(int d, int[] arr) {
		int count = 0;

		for (int i = 0; i < arr.length - 2; i++)
		{
			for (int j = i+1; j < arr.length - 1; j++)
			{
				if (arr[j]-arr[i] == d)
				{
					for (int k = j+1; k < arr.length; k++) {
						if (arr[k]-arr[j] == d)
						{
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		int result = beautifulTriplets(d, arr);
		System.out.println(result);
		in.close();
	}
}
