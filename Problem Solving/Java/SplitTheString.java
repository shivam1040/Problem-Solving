/*
Given a string S, you have to check if we can split it into four strings such that each string is non-empty and distinct from each other.
 

Example 1:

Input :
S = "geeksforgeeks"
Output:
1
Explanation:
"geeks", "for", "gee", "ks" are four
distinct strings that can form from
given string.
Example 2:

Input: 
S = "aaabb" 
Output:
0
Explanation:
It's not possible to split string S in four
distinct strings

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isPossible() which takes the string S as input parameter and returns 1 if it's possible to split S into four strings such that each string is non-empty and distinct from each other or return 0 otherwise. 
 

Expected Time Complexity: O(|S|3)
Expected Space Complexity: O(1)


Constraints:
1< |S| <=10000


*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int isPossible(String S){
        // code here
        int length=S.length();
        Set<Character> aux=new HashSet<>();
        
        for(char i:S.toCharArray())
            aux.add(i);
        
        int size=aux.size();
        
        //all these conditions ensure minimu char and length required to get 4 distinct string
        if(size==1 && length<10)
            return 0;
        else if(size==2 && length<=6)
            return 0;
        else if(size==3 && length<6)
            return 0;
        return 1;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(s));
        }
    }
}

// } Driver Code Ends
