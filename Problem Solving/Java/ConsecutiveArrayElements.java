/*
Given an unsorted array arr[] of size N, the task is to check whether the array consists of consecutive numbers or not.

Example 1:

Input: N = 5, arr[] = {5, 4, 2, 1, 3}
Output: Yes
Explanation: All are consecutive elements,
according to this order 1,2,3,4 and 5.
Example 2:

Input: N = 6, arr[] = {2, 1, 0, -3, -1, -2}
Output: Yes

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function areConsecutives() that takes array arr[] and integer N as parameters and returns the boolean true if array elements are consecutive else boolean false.

Note: If the elements are consecutive driver code outputs Yes otherwise, it outputs No

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ N ≤ 107


*/

/*
As elements should be consecutive, let’s find minimum element or maximum element in array.
Now if we take xor of two same elements it will result in zero (a^a = 0).
Suppose array is {-2, 0, 1, -3, 4, 3, 2, -1}, now if we xor all array elements with minimum element and keep increasing minimum element, the resulting xor will become 0 only if elements are consecutive
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
    boolean areConsecutives(long arr[], int N)
    {
        long min=Arrays.stream(arr).min().getAsLong();
        long num=0;
        
        for(long i:arr){
           num=num^min^i;
           min+=1;
        }
        
        return num==0 ? true : false;

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
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            boolean ans=ob.areConsecutives(a,n);
           // System.out.println(ob.shuffleArray(a,n));
            if(ans)
            System.out.println("Yes");
            else
            System.out.println("No");

        }
    }
}



// } Driver Code Ends
