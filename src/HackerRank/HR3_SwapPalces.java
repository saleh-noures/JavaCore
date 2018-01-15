package HackerRank;

// Note: you need to reverse the array and if negative should be positive and vis versa, you can't define new arrays
public class HR3_SwapPalces 
{

	public static void main(String[] args)
	{

		int [] arr = {2,-3,7,8,-9,4,1};
		int temp = 0;

		for (int i = 0; i < arr.length/2; i++) // last Index  = 2
		{
			temp = arr[arr.length - i -1] * -1;    // index = 3, temp = -9
			arr[arr.length - i -1] = arr[i] * -1;
			arr[i] = temp;
		}

		/*If the length of the array is odd number, then the element in the middle won't changed
		so do it manually */
		if (arr.length%2 != 0)
		{
			arr[ Math.round(arr.length/2)] *= -1;
		}

		for (int ele: arr) {
			System.out.print(ele + " ");
		}


	}
}
