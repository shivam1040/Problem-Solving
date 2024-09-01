/*
Given a non-negative number N in the form of a string.Find the largest number that can be formed by swapping two characters at most once.

 

Example 1:

Input:
N=768
Output:
867
Explanation:
Swapping the 1st and 3rd 
characters(7 and 8 respectively),
gives the largest possible number.
Example 2:

Input:
N=333
Output:
333
Explanation:
Performing any swaps gives the 
same result i.e 333.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function LargestSwap() which takes the string N as input parameter and returns the maximum possible string possible with at most one swap.

Expected Time Complexity:O(|N|)
Expected Auxillary Space:O(1)

Constraints:
1<=|N|<=105


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
            String N = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.LargestSwap(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String LargestSwap(String S){
        //code here
        int max=Integer.MIN_VALUE, left=-1, maxIdx=0;
        char ch[]=S.toCharArray();
        
        for(int i=ch.length-1; i>=0; i--){
            int temp=ch[i]-'0';
            
            if(temp>max){
                max=temp;
                maxIdx=i;
            }
            else if(temp<max)
                left=i;
        }
        if(left==-1)
            return S;
        
        char temp=ch[left];
        ch[left]=ch[maxIdx];
        ch[maxIdx]=temp;
        
        return String.valueOf(ch);
    }
}
