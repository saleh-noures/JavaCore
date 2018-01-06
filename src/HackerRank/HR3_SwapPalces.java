package HackerRank;

// Note: you need to reverse the array and if negative should be positive and vis versa, you can't define new arrays
public class HR3_SwapPalces 
{

	public static void main(String[] args)
	{

		int [] arr = {2,-3,7,8,-9,4,1};
		int x = 0;
		int y = 0;
		int arrLen = arr.length;
		
		for (int i = 0; i<=arrLen/2; i++)
		{
			x = arr[i] * -1;
			y = arr[arrLen - i - 1] * -1;
			
			arr[i] = y;
			arr[arrLen - i - 1] = x;
		}
		
		for (int ele : arr)
		{
			System.out.print(ele  + " ");
		}
	}
}
