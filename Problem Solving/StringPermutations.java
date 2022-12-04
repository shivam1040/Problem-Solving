/*
Given a string S. The task is to find all permutations of a given string.

Example 1:

Input:
S = ABC
Output: ABC ACB BAC BCA CAB CBA 
Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA
 

Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ size of string ≤ 5

Expected Time Complexity: O(N * N!), N = length of string.
Expected Auxiliary Space: O(1)
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> res=new ArrayList<>();
        perm(res, S, "");
        Collections.sort(res);
        return res;
        
    }
    
    private void perm(ArrayList<String> res, String S, String ans){
        if(S.length()==0){
            res.add(ans);
            return;
        }
        for(int i=0; i<S.length(); i++){
            //exclude one character take all, put excluded at end and repeat
            char ch=S.charAt(i);
            String l=S.substring(0, i);
            String r=S.substring(i+1);
            perm(res, l+r, ans+ch);
        }
    }
	   
}

