package HackerRank;

public class HR4_ArrayReverse {
	public static void main(String[] args)
	{
		int [] arr = {2,-3,7,8,-9,4,1};
		int x = 0;
		
		for (int i = 0; i<arr.length/2; i++)
		{
			x = arr[i];
			arr[i] = arr[arr.length - 1 - i] * -1;
			arr[arr.length - 1 - i] = x * -1;
		}
		
		for(int ele : arr)
		{
			System.out.print(ele + " ");
		}
	}
}
