/*
Given two strings S1 and S2 consisting of only lowercase characters whose anagrams are almost equal. The task is to count the number of characters which needs to be edited(delete) to make S1 equal to S2.

Example 1:

Input:
madame
madam

Output:
1

Explanation:
String S1 = madame, string S2 = madam. character 'e' in 
first string is need to be deleted to make S1 equal to S2.
Example 2:

Input:
suryansh
suryanshzzawesome

Output:
9

Explanation:
String S1 = suryansh, string S2 = suryanshzzawesome. 
All character after "suryansh" in second string are 
need to be deleted to make S1 equal to S2.
Constraints:
1 <= S1, S2 <= 104
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    
	public static void main (String[] args)
	{
	     //taking input using Scanner class
    	 Scanner sc = new Scanner(System.in);
    	 
    	 //taking total number of testcases
    	 int t = sc.nextInt();
    	 
    	 boolean flag = false;
    	 while(t-- > 0){
    	   
    	   //taking the 2 strings
    	   String s1=sc.next();
    	   String s2=sc.next();
    	   
    	   //creating an object of class Geeks
    	   Geeks obj=new Geeks();
    	   
    	   //calling coutChars method
    	   //of class Geeks and passing
    	   //both the Strings and printing
    	   //the result
    	   System.out.println(obj.coutChars(s1,s2));
    	   
    	 }
    }
}




// } Driver Code Ends
//User function Template for Java

/*Function to count number of characters 
* to make s1 and s2 equal
* s1 : first string
* s2 : second string
*/
class Geeks{
    
    static int coutChars(String s1, String s2)
    {
        
       //Your code here
       int aux[]=new int[26];
       int res=0;
       
       for(int i=0; i<s1.length(); i++)
        aux[s1.charAt(i)-'a']++;
       for(int i=0; i<s2.length(); i++)
        aux[s2.charAt(i)-'a']--;
       for(int i:aux)
        res+=Math.abs(i);
       return res;
    }
}

//{ Driver Code Starts.

// } Driver Code Ends
