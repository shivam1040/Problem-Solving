/*
Given an array S consisting of N numbers, find the sum of difference between last and first element of each subset.

Example 1:

Input:
S = [5,8]
Output: 
3
Explanation: There are 3 subsets possible for the given array S.
1 -> [5] having first and last element same i.e. 5
so the difference is 0.
2 -> [8] having first and last element same i.e. 8
so the difference is 0.
3 -> [5,8] having first and last element as 5 and 8
respectively. So the difference is 8-5 = 3
Total difference is 0 + 0 + 3 = 3
Your Task:
You don't need to read input or print anything. You are required to complete the function sumDiff which returns an integer denoting the sum of difference between last and first element for each subset of array S.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<=T<=100
1<=N<=20
1<=S[]<=1000
*/

/*
We are given a set S consisting of n numbers, and we need to compute the sum of difference between last and first element of each subset of S, i.e.,
sumSetDiff(S) = ∑ (last(s) – first(s)), where sum goes over all subsets s of S.
Equivalently,
sumSetDiff(S) = ∑ (last(s)) – ∑ (first(s)),
In other words, we can compute the sum of last element of each subset, and the sum of first element of each subset separately, and then compute their difference.

Let us say that the elements of S are {a1, a2, a3,…, an}. Note the following observation:

Subsets containing element a1 as the first element can be obtained by taking any subset of {a2, a3,…, an} and then including a1 into it. Number of such subsets will be 2n-1.
Subsets containing element a2 as the first element can be obtained by taking any subset of {a3, a4,…, an} and then including a2 into it. Number of such subsets will be 2n-2.
Subsets containing element ai as the first element can be obtained by taking any subset of {ai, a(i+1),…, an} and then including ai into it. Number of such subsets will be 2n-i.


Therefore, the sum of first element of all subsets will be:
SumF = a1.2n-1 + a2.2n-2 +…+ an.1

In a similar way we can compute the sum of last element of all subsets of S (Taking at every step ai as last element instead of first element and then obtaining all the subsets).
SumL = a1.1 + a2.2 +…+ an.2n-1

SumF: This function calculates the sum of the first elements of each subset. It does this by iterating through the array and, for each element, multiplies it by 2 raised to the power of n - i - 1, where n is the total number of elements in the array, and i is the current index. This effectively gives more weight to the elements at the beginning of each subset, and the function returns the sum of these weighted elements.

SumL: This function calculates the sum of the last elements of each subset. It also iterates through the array, but in this case, it multiplies each element by 2 raised to the power of the current index i. This gives more weight to the elements at the end of each subset, and the function returns the sum of these weighted elements.

essentially we find the number of subsets that can be formed by keeping an ele at the first and end, summing respectively and then subtracting whole of each to get the diff
*/

//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;

class Sum_Of_Diff_Of_First_Last
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
			GfG g = new GfG();
		
			System.out.println(g.sumDiff(arr,n));
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */
class GfG
{
    int sumDiff(int S[], int n)
    {
	// Your code here
	    return sumL(S, n)-sumF(S, n);
    }
    
    private int sumF(int S[], int n){
        int sum=0;
        
        for(int i=0; i<n; i++)
            sum+=S[i]*(int)Math.pow(2, n-i-1);
        return sum;
    }
    
    private int sumL(int S[], int n){
        int sum=0;
    
        for(int i=0; i<n; i++)
            sum+=S[i]*(int)Math.pow(2, i);
        return sum;
    }
}

