/*
Given a List Arr, of 26 integers denoting the number of Alphabets of each type. You have to make all alphabets same. Exchanging an alphabet with another costs the difference in their ASCII value. For example, to exchange A with C, it will cost him 67-65 = 2.
Calculate the minimum amount you must spend to make all the alphabets same.

 

Example 1:

Input:
Arr = {2 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0}
Output:
6
Explanation:
Exchanging all the alphabets to B
will cost the minimum.
Exchanging 2 A's for B's: 2*(66-65)=2
Exchanging 4 C's for B's: 4* (67-66)=4
Total cost = 6
Example 2:

Input:
Arr = { 3 4 0 0 0 0 0 0 6 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 }
Output:
45
Explanation:
Exchanging all the alphabets to B
will cost the minimum.
Exchanging 3 A's for B's: 3*(66-65)= 3
Exchanging 6 I's for B's: 6*(73-66)= 42
Total cost = 45 
Your Task:
You don't need to read input or print anything. Your task is to complete the function getMinCost() which takes an Array/List Arr as input and return an answer.

Expected Time Complexity: O(|Arr|2)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= Total number of alphabets <= 26*(10^5)
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int[] arr = new int[26];
            for(int i=0 ; i<26 ; i++)
                arr[i]=Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.getMinCost(arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long getMinCost(int[] arr) {
        // code here
        long res=Long.MAX_VALUE;
        
        for(int i=0; i<26; i++){
            long temp=0;
            
            for(int j=0; j<26; j++)
                temp=temp+arr[j]*Math.abs(j-i);
            res=Math.min(res, temp);
        }
        return res;
    }
};
