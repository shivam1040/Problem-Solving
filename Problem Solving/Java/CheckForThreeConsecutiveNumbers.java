/*
Given an integer n, the task is to find whether n can be written as sum of three consecutive integer.

Example 1:

Input: n = 6
Output: 1 2 3 
Explanation: 6 = 1+2+3
Hence 6 can be written as sum of 
three consecutive integer.
Example 2:

Input: n = 7
Output: -1
Explanation: 7 cannot be written as 
sum of three consecutive integer.

Your Task:  
You dont need to read input or print anything. Complete the function consecutiveSum() which takes n as input parameter and returns a vector contains of three consecutive integers if it is possible else -1.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=10000
*/

/*
The idea is to check if n is multiple of 3 or not. 
Let n is sum of three consecutive integer of k – 1, k, k + 1. Therefore, 
k – 1 + k + k + 1 = n 
3*k = n 
The three number will be n/3 – 1, n/3, n/3 + 1. 
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            Vector<Integer> v = ob.consecutiveSum(n);
            v.toString();
            for (Integer i : v)System.out.print(i+" ");
            System.out.print("\n");
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static Vector<Integer>consecutiveSum(int n) { 
        // code here
        Vector<Integer> res=new Vector<>();
        
        if(n%3==0){
            res.add(n/3-1);
            res.add(n/3);
            res.add(n/3+1);
        }
        else
            res.add(-1);
        return res;
    }
}
