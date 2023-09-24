/*
Given a string S and an array roll where roll[i] represents rolling first roll[i] characters in the string, the task is to apply every roll[i] on the string and output the final string. Rolling means increasing the ASCII value of character, like rolling ‘z’ would result in ‘a’, rolling ‘b’ would result in ‘c’, etc.

 

Example 1:

Input: s = "bca"
roll[] = {1, 2, 3} 
Output: eeb
Explanation: arr[0] = 1 means roll 
first character of string -> cca
arr[1] = 2 means roll 
first two characters of string -> dda
arr[2] = 3 means roll
first three characters of string -> eeb
So final ans is "eeb".
 
Example 2:

Input: s = "zcza"
roll[] = {1, 1, 3, 4}
Explanation: debb
 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findRollOut() that takes String S, array roll, and integer N as parameters and returns the modified string.

Note- The length of the array roll and length of the string are equal.

 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 107
*/

//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    String findRollOut(String s,long roll[], int n)
    {
        /*
        char aux[]=s.toCharArray();
        StringBuilder res = new StringBuilder();
        
        for(long i:roll){
            int j=0;
            
            while(j<i){
                if(aux[j]=='z'){
                    aux[j]='a';
                }
                else
                    aux[j]++;
                j++;
            }
        }
        
        for(char c:aux)
            res.append(c);
        
        return res.toString();
        */
        
        int hash[] = new int[n+2];
        char ch[]=s.toCharArray();
        StringBuilder res = new StringBuilder();
        
	    for(int i=0; i<n; i++)
	        hash[(int)roll[i]]++;
	        
	    for(int i=n; i>=0; i--)
	        hash[i] += hash[i+1];
	   
	    for(int i=1; i<=n; i++){
	        int a=((ch[i-1]-'a')+hash[i])%26 + 'a';
	        ch[i-1]=(char)a;
	    }
	    
	    for(char c:ch)
            res.append(c);
        
        return res.toString();
	    
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s=br.readLine();
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            String ans=ob.findRollOut(s,a,n);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
