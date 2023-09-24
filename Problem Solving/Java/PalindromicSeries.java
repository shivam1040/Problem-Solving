/*
Adobe wants to play a game. He is given a number N. He has to create a alphabetical string in lower case from that number and tell whether the string is palindrome or not. a = 0 , b = 1….. and so on.  For eg : If the number is 61 the substring “gb” will be printed till 7 (6+1) characters i.e. “gbgbgbg” and check if palindrome or not. Adobe is weak in concepts of palindrome and strings, help him in winning the game.
Note: No number will start with zero. Consider alphabets ' a to j ' only i.e. single digit numbers from 0 to 9.

Example 1:

â€‹Input : N = 61
Output : YES
Explanation:
N = 61 the substring “gb” will be 
printed till 7 (6+1) characters i.e. 
“gbgbgbg” and it is palindrome. return 
true.

â€‹Example 2:

Input : N = 1998 
Output :  NO 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function pallan() that takes an integer (N), and return true if the string is a palindrome otherwise return false if not. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:

1 ≤ N ≤ 107
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    Complete obj = new Complete();
		    boolean ans = obj.pallan(N);
		    if(ans == true)
		        System.out.println("YES");
		    else
		        System.out.println("NO");
		    
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static boolean pallan (int n) {
        //Complete the function
        String temp="";
        int temp1=0;
        
        while(n>0){
            int temp2=n%10;
            temp=(char)('a'+temp2)+temp;
            temp1+=temp2;
            n/=10;
        }
        temp=temp.repeat((temp1/temp.length())+1);
        temp=temp.substring(0, temp1);
        return isPalindrome(temp)==true?true:false;
    }
    
    static boolean isPalindrome(String str)
    {
 
        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;
 
        // While there are characters to compare
        while (i < j) {
 
            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;
 
            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }
 
        // Given string is a palindrome
        return true;
    }
    
    
}






