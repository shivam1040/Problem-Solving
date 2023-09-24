/*
Given a string str. Calculate the total number of unique substrings of the given string.

Example 1:

Input:
abd

Ouput:
6

Explanation:
str = abd. The 6 unique substrings 
are {a, b, d, ab, bd, abd}.
Example 2:

Input:
jaja

Ouput:
7

Explanation:
str = jaja. The substrings will be j, a, j, a, 
ja, aj, ja, jaj, aja, jaja. Out of these the 
unique are j, a, ja, aj, jaj, aja, jaja.
User Task:
You need to complete the function unique_substring() that takes str as a parameter and returns the count of unique substrings.

Constraints:
1 <= |str| <= 100
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.ListIterator;
class GFG {
	public static void main (String[] args) {
		
		//Taking input using class Scanner
		Scanner sc = new Scanner(System.in);
		
		//Taking count of total number of testcases
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		  
		  
		  //Taking the string as input
		  String str=sc.nextLine();
		  Solution ob = new Solution();
		  //Calling the unique_substring method
		  //and printing the result
		  System.out.println(ob.unique_substring(str));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
        public static int unique_substring(String str)
    {
        //Your code here
        Set<String> aux=new HashSet<>();
        
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                aux.add(str.substring(i, j));
            }
        }
        return aux.size();
    }
}
