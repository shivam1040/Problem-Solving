/*
Given an array arr[] of N distinct numbers, the task is to sort all even-placed numbers in increasing and odd-place numbers in decreasing order. The modified array should contain all sorted even-placed numbers followed by reverse sorted odd-placed numbers.
Note that the first element is considered as even because of its index 0.

Example 1:

Input: N = 8
arr[] = {0, 1, 2, 3, 4, 5, 6, 7}
Output: 0 2 4 6 7 5 3 1
Explanation: 
Even-place elements : 0, 2, 4, 6
Odd-place elements : 1, 3, 5, 7
Even-place elements in increasing order : 
0, 2, 4, 6
Odd-Place elements in decreasing order : 
7, 5, 3, 1
Example 2:

Input: N = 9
arr[] = {3, 1, 2, 4, 5, 9, 13, 14, 12}
Output: 2 3 5 12 13 14 9 4 1
Explanation: 
Even-place elements : 3, 2, 5, 13, 12
Odd-place elements : 1, 4, 9, 14
Even-place elements in increasing order : 
2, 3, 5, 12, 13
Odd-Place elements in decreasing order : 
14, 9, 4, 1

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function bitonicGenerator() that takes array arr and integer N as parameters and modify the array according to the above condition.

Expected Time Complexity: O(NlogN).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105
*/

/*
The above problem can also be solved without the use of Auxiliary space. The idea is to swap the first half odd index positions with the second half even index positions and then sort the first half array in increasing order and the second half array in decreasing order.
*/

//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    void bitonicGenerator(long arr[], int n)
    {
        //odd index
        int i=1; 
        int j=n-1;
        
        //making even
        if(j%2!=0)
            j--;
        
        //swap all odd with even
        while(i<j){
            long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        //next odd
        i+=2;
        j-=2;
        }
        
        //getting mid index
        int in=(n+1)/2;
        //sort first half
        Arrays.sort(arr, 0, in);
        //sort second half
        Arrays.sort(arr, in, n);
        
        int low=in, high=n-1;
        
        //reverse to make second half descdmding
        while(low<high){
            long temp=arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            ob.bitonicGenerator(a,n);
            for (int i = 0; i < n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
        }
    }
}





// } Driver Code Ends
