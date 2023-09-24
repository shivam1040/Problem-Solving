/*
Given a number N. We have to find maximum sum of all permutations of numbers from 1 to N. The maximum sum will be sum of absolute difference of adjacent elements in array.

Example 1:

Input: N = 2
Output: 1
Explaination: Permutations of 2 are: 
{1, 2} = 1, {2, 1} = 1.
Example 2:

Input: N = 3
Output: 3
Explaintation: Permutations of size 3 are: 
{1, 2, 3} = 1 + 1, {1, 3, 2} = 2 + 1 
{2, 1, 3} = 1 + 2, {2, 3, 1} = 1 + 2 
{3, 1, 2} = 2 + 1, {3, 2, 1} = 1 + 1 
Your Task:
You do not need to read input or print anything. Your task is to complete the function maxSum() which takes N as input parameter and returns the maximum possible difference sum from all permutations of N numbers.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 1000
*/

/*
Let us take example of n = 5. We can easily see we can place numbers like 1 5 2 4 3. 
abs(1-5) = 4 
abs(5-2) = 3 
abs(2-4) = 2 
abs(4-3) = 1 
which sum is 4 + 3 + 2 + 1 = 10. 
In general sum of this permutation is n(n-1)/2. 
But the maximum sum is obtained if we move 3 at beginning of this permutation 
ie 3 1 5 2 4. 
Sum will become 2 + 4 + 3 + 2 = 11.
Final relation = n (n – 1) / 2 – 1 + n / 2 for n > 1.
The permutation of n having maximum sum will be of from n/2, n-1, 2, n-2, 3, n-3. 
So we have to find sum of this permutation which will be n(n-1)/2 – 1 + n/2. 
*/

//{ Driver Code Starts


// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.maxSum(N));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    static int maxSum(int n){
        // code here
        if(n==1)
            return 1;
        return n*(n-1)/2-1+n/2;
    }
}
