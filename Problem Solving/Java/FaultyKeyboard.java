/*
Geek has a unique keyboard containing only the numpad keys. ie - 1,2,3,4,5,6,7,8,9,0. But the keyboard is damaged and can only process M keys. Geek is supposed to use the keyboard to type as many natural numbers as possible starting from 1. What will be the greatest natural number he will type?  


Example 1:

Input: 
M = 5
Output: 5
Explaination: 
Geek can only press 5 keys. He will type
1,2,3,4,5. The greatest number is 5.

Example 2:

Input: 
M = 15
Output: 12
Explaination: 
1 key each from 1 to 9. 
2 keys each from 10 to 12.
Total keys pressed = 15.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxNatural() which takes M as input parameter and returns the maximum natural number possible to get after pressing M keys.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ M ≤ 38890


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
            int M = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.maxNatural(M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int maxNatural(int M){
        // code here
        int n=0;
        
        while(M>0){
            int digits=0, num=n+1;
            //get num of keystrokes for every
            while(num>0){
                digits++;
                
                num/=10;
            }
            if(M>=digits){
                M-=digits;
                n++;
            }
            else
                return n;
        }
        return n;
    }
}
