/*
Given two positive numbers A and B. The task is to divide A by B and calculate the number of digits after decimal.

Example 1:

Input: A = 4, B = 5
Output: 1
Explaination: If 4 is divided by 5 the 
result is 0.8. So there is only 1 digit 
after decimal.
Example 2:

Input: A = 1, B = 3
Output: -1
Explaination: It's a recurring decimal when 
1 is divided by 3.
Your Task:
You do not need to read input or print anything. Your task is to complete the function countDecimal() which takes A and B as input parameters and returns the number of integers after the decimal point. It returns -1 if it is a recurring decimal.

Expected Time Complexity: O(B)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ A, B ≤ 106
*/

/*
The idea is simple we follow school division and keep track of remainders while dividing one by one. If remainder becomes 0, we return count of digits seen after decimal. If remainder repeats, we return INF.  
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.countDecimal(A, B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countDecimal(int A, int B){
        // code here
        Map<Integer, Integer> aux=new HashMap<>();
        int res=0;
        
        while(A%B!=0){
            A%=B;
            
            res++;
            // if this remainder appeared before then 
        // the numbers are irrational and would not
        // converge to a solution the digits after
        // decimal will be infinite
            if(aux.containsKey(A))
                return -1;
            aux.put(A, 1);
            A*=10;
        }
        return res;
    }
};
