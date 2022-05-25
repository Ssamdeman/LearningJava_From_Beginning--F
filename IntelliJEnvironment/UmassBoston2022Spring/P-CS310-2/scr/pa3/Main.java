import java.util.Arrays;

class Main
{
	// Iterative function to find the length of the longest increasing subsequence
	// of a given array
	public static int LIS(int[] arr)
	{
		// base case
		if (arr == null || arr.length == 0) {
			return 0;
		}

		// array to store subproblem solution. `L[i]` stores the length
		// of the longest increasing subsequence that ends with `arr[i]`
		int[] L = new int[arr.length];

		// the longest increasing subsequence ending at `arr[0]` has length 1
		L[0] = 1;

		// start from the second array element
		for (int i = 1; i < arr.length; i++)
		{
			// do for each element in subarray `arr[0…i-1]`
			for (int j = 0; j < i; j++)
			{
				// find the longest increasing subsequence that ends with `arr[j]`
				// where `arr[j]` is less than the current element `arr[i]`
				if (arr[j] < arr[i] && L[j] > L[i]) {
					L[i] = L[j];
				}
			}
			// include `arr[i]` in LIS
			L[i]++;
		}

		// return longest increasing subsequence (having maximum length)
		return Arrays.stream(L).max().getAsInt();
	}

	public static void main(String[] args)
	{
		int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("The length of the LIS is " + LIS(arr));
	}
}