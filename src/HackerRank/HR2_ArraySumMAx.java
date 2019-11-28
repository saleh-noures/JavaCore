package HackerRank;

/* Find the max sum for three adjacent numbers in an array */
public class HR2_ArraySumMAx {

	public static void main(String[] args) {

		int pSize = 3;
		int [] arr = {9,3,5,10,5,8,4,15};
		int sum = 0;
		int max = 0;

		for (int i = 0 ; i <= arr.length - pSize ; i++)
		{
			for (int j = i ; j<i+pSize ; j++)
			{
				sum = sum + arr[j];
			}

			if (i == 0)
			{
				max = sum;
			}

			if (sum > max)
			{
				max = sum;
			}
			sum = 0;
		}

		System.out.println(max);

	}

}
