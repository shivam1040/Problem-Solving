/*
Given a string S. The task is to print all unique permutations of the given string that may contain dulplicates in lexicographically sorted order. 

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function find_permutation() which takes the string S as input parameter and returns a vector of string in lexicographical order.

Expected Time Complexity: O(n! * n)
Expected Space Complexity: O(n! * n)

Constraints:
1 <= length of string <= 5
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        char ch[]=S.toCharArray();
        List<String> res=new ArrayList<>();
        
        Arrays.sort(ch);
        perm(0, new char[S.length()], new String(ch), new boolean[S.length()], res);
        return res;
        
    }
    
    private void perm(int i, char p[], String S, boolean v[], List<String> res){
        if(i==S.length()){
            res.add(new String(p));
            return;
        }
        for(int j=0; j<S.length(); j++)
            if(!v[j])
                if(j>0){
                    if(S.charAt(j-1)!=S.charAt(j) || v[j-1]){
                        p[i]=S.charAt(j);
                        v[j]=true;
                        perm(i+1, p, S, v, res);
                        v[j]=false;
                    }
                }
                else{
                                            p[i]=S.charAt(j);
                        v[j]=true;
                        perm(i+1, p, S, v, res);
                        v[j]=false;
                }
    }
}
