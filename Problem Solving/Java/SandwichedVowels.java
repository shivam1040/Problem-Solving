/*
For a given string S, comprising of only lowercase English alphabets, eliminate the vowels from the string that occur between two consonants(sandwiched between two immediately adjacent consonants). Print the updated string on a new line.

Example 1:

Input : S = "bab"
Output : bb
Explanation:
a is a vowel occuring between two consonants i.e. b. 
Hence the updated string eliminates a.

Example 2:

Input : S = "ceghij"
Output : cghj
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function Sandwiched_Vowel() that takes a String (s), and return the updated String. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:

1 ≤ L ≤ 105, where L is length of string S

'a' ≤ S[i] ≤ 'z', i is an integer denoting index of S
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String s = br.readLine().trim();
		  
		    Complete obj = new Complete();
		    
		    System.out.println(obj.Sandwiched_Vowel(s));
		        
		}
		
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    public static String Sandwiched_Vowel(String str) 
    { 
        // Complete function
        StringBuilder res=new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(i!=0 && i!=str.length()-1 && !isVowel(str.charAt(i-1)) && isVowel(str.charAt(i)) && !isVowel(str.charAt(i+1))){
                continue;
            }
            res.append(str.charAt(i));
                
        }
        return res.toString();
    }
    
    private static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}

// a b c d e
// 0 1 2 3 4
