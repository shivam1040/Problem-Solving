/*
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. The output should be printed in sorted increasing order of strings

Example 1:

Input:
S = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation:
ABC
AB C
A BC
A B C
These are the possible combination of "ABC".
 

Example 2:

Input:
S = "AB"
Output: (A B)(AB)

Your Task:  
You don't need to read input or print anything. Your task is to complete the function permutation() which takes the string S as input parameters and returns the sorted array of the string denoting the different permutation (DON'T ADD '(' and ')' it will be handled by the driver code only).

Expected Time Complexity: O(2^n)
Expected Auxiliary Space: O(1)

 

CONSTRAINTS:
1 <= |S| < 10
S only contains lowercase and Uppercase English letters.
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> res=new ArrayList<>();
        //intially giving first recursion step
        perm(res, S.charAt(0)+"", S.substring(1));
        return res;
    }
    
    //here the idea is to either add spaces in between or not add
    private void perm(ArrayList<String> res, String out, String inp){
        if(inp.length()==0){
            res.add(out);
            return;
        }
        char ch=inp.charAt(0);
        //going with choice where we add spaces
        perm(res, out+" "+ch, inp.substring(1));
        //choice where we append new character to output string without adding spaces
        perm(res, out+ch, inp.substring(1));
    }
    
}
