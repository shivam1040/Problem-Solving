/*
Given an array arr[] containing N integers. In one step, any element of the array can either be increased or decreased by one. Find minimum steps required such that the product of the array elements becomes 1.

 

Example 1:

Input:
N = 3
arr[] = {-2, 4, 0}
Output:
5
Explanation:
We can change -2 to -1, 0 to -1 and 4 to 1.
So, a total of 5 steps are required
to update the elements such that
the product of the final array is 1. 
Example 2:
Input:
N = 3
arr[] = {-1, 1, -1} 
Output :
0
Explanation:
Product of the array is already 1.
So, we don't need to change anything.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function makeProductOne() which takes an integer N and an array arr of size N as input and returns the minimum steps required.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
-103 ≤ arr[i] ≤ 103
*/

/*
The product of the array elements can only be equal to 1 when there are only 1s and -1s in the array and the count of -1s is even.
Now, all the positive numbers can be reduced to 1 because they are closer to 1 than they are closer to -1.
Similarly, all the negative numbers can be updated to -1.
If there are 0s present in the array then they can be reduced to either 1 or -1 according to the situation (the count of -1s must be even).
If the count of -ve numbers are even then they are always going to yield -1.
But if there are odd number of -ve numbers then they are going to yield an odd number of -1s. To fix that, there are two possibilities: 
First try to find the count 0s in the array because it will take 1 operation to be -1.
If there are no zeros in the array then just add 2 in the answer because it will take two steps to make -1 to 1.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.makeProductOne(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int makeProductOne(int[] arr, int N) {
        // code here
        int minus=0, plus=0, none=0, res=0;
        
        for(int i:arr){
            if(i<0){
                // Extra cost needed
                // to make it -1
                res+=(-1-i);
                minus++;
            }
            else if(i>0)
            // Extra cost needed
                // to make it 1
                //since 1 is nearest
                res+=(i-1);
            else
                none++;
        }
        
           // Now the array will
        // have -1, 0 and 1 only
        if(minus%2==0)
        
         // Change one zero to -1
                // and rest of them to 1
                // Total cost here will
                // be count of '0'
            res+=none;
        else{
            
             // Change one zero to -1
                // and rest of them to 1
                // Total cost here will
                // be count of '0'
            if(none>0)
                res+=none;
                
                // As no 0s are available so we
                // have to change one -1 to 1
                // which will cost 2 to
                // change -1 to 1
            else
                res+=2;
        }
        return res;
    }
};
