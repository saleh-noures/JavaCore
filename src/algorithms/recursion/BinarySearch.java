package algorithms.recursion;

// Binary Search assumes the list/array is sorted
public class BinarySearch {

    public static void main(String[] args) {

        int [] intArray = {1,3,5,8,10,15,22,30};
        int last = intArray.length;
        int first = 0;
       boolean isFound =  binarySearch(intArray, first, last, 6  );
        System.out.println("Found: " + isFound);

    }

    public static boolean binarySearch(int[] arr, int first, int last ,int x)
        {
            boolean isFound = false;

            if (!(x > arr[arr.length - 1] || x < arr[0]))
            {

                int mid = (first + last)/2;

                if (x == arr[mid])
                    isFound = true;
                else if (first == last)
                    isFound = false;
                else if(x < arr[mid])
                {
                    last = mid -1;
                    isFound = binarySearch(arr, first, last , x);
                }
                else if(x > arr[mid])
                {
                    first = mid + 1;
                    isFound =  binarySearch(arr, first, last , x);
                }

            }

            return isFound;
        }
}
