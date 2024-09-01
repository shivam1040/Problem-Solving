/*
Given a Binary string st and a number k. You have to find the Longest continuous sequence of '0' after repeating Given string K time.

Example 1:

Input: k = 3
st = 100001
Output: 4
Explaination: The string repeated k times 
become 100001100001100001. Here the longest 
continuous sequence of 0 is 4.
Example 2:

Input: k = 4
st = 000
Output: 12
Explaination: When st is repeated 4 times 
it become 000000000000. The longest sequence 
becomes of length 12.
Your Task:
You do not need to read input or print anything. Your task is to complete the function lcsK() which takes k and st as input parameters and returns the length of the longest continuous sequence of 0's after repeating st k times.

Expected Time Complexity: O(|st|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |st| ≤ 105
1 ≤ k ≤ 105  
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int k = Integer.parseInt(in.readLine());
            String st = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.lcsK(k, st));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int lcsK(int k, String st){
        // code here
        int i;
        
        for(i=0; i<st.length(); i++)
            if(st.charAt(i)!='0')
                break;
        if(i==st.length())
            return st.length()*k;
        
        String temp=st;
        //taking only two concat 'cause that's enough to get max
        temp+=st;
        int s=0, e=0, res=0;
        
        while(e<temp.length()){
            if(temp.charAt(e)!='0'){
                res=Math.max(res, e-s);
                //this ensures that we always have starting index of zero if any
                //so doing diff with end gives number of zeroes in string
                s=e+1;
            }
            e++;
        }
        
        res=Math.max(res, e-s);
        
        return res;
    }
}
