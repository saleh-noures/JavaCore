package HackerRank;
//https://www.hackerrank.com/challenges/arrays-ds/problem
public class HR4_ArrayReverse {
	public static void main(String[] args)
	{
		int tmp =1;
		int [] arr = {2,-3,7,8,-9,4,1};

		for (int i = 0; i <arr.length/2 ; i++) {
			tmp = arr[i];
			arr[i] = arr[arr.length -1 -i];
			arr[arr.length -1 -i] = tmp;
		}

		for (int ele: arr) {
			System.out.print(ele + " ");
		}


		/*		This how to solve using ArrayList
				int temp;
				for (int i = 0; i < a.size()/2; i++) {
					temp = a.remove(i);
					a.add(i, a.get(a.size() -1 -i));
					a.add(a.size()-1 -i, temp);
					a.remove(a.size()-1 -i);
				}*/

	}

}
