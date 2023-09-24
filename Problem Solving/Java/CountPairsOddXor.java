/*
Given an array arr[] of N integers, the task is to find the number of pairs in the array whose XOR is odd.

Example 1:

Input: N = 3, arr[] = {1, 2, 3}
Output: 2
Explanation: All pairs of array
             1 ^ 2 = 3
             1 ^ 3 = 2
             2 ^ 3 = 1
Example 2:

Input: N = 2, arr[] =  {1, 2}
Output: 1
Explanation: 1^2 =3 which is odd.
Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countXorPair() that takes array arr and integer N as parameters and returns the desired output.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
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
    long countXorPair(long arr[], int n)
    {
        long odd=0;
        long even=0;
        
        for(int i=0; i<n; i++){
            if(arr[i]%2!=0)
                odd++;
            else
                even++;
        }
        //basic idea is xor of even with odd gives out odd result so For example, let's assume we have 3 even numbers (E1, E2, E3) and 4 odd numbers (O1, O2, O3, O4). If we choose E1 as the first number, we can pair it with any of the 4 odd numbers (O1, O2, O3, or O4), resulting in 4 odd XOR pairs. Similarly, we can do this for each even number, resulting in even_count * odd_count odd XOR pairs.
        return odd*even;
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
            long ans = ob.countXorPair(a,n);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends
