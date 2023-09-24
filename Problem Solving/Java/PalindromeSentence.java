/*
Given a single sentence s, check if it is a palindrome or not. Ignore white spaces and any other character you may encounter. 

Example 1:

Input:
s = race car.
Output: 1 
Explanation: processing str gives us
"racecar" which is a palindrome.

Example 2:

Input:
s = hello world.
Output: 0
Explanation: processing str gives us
"helloworld" which is not a palindrome.

Your Task:  
You dont need to read input or print anything. Complete the function sentencePalindrome() which takes a string s as input parameter and returns a boolean value denoting if sentence is a palindrome or not.

Note: The driver code prints 1 if the returned value is true, otherwise 0.


Expected Time Complexity: O(N) where N is length of s.
Expected Auxiliary Space: O(1)


Constraints:
1<= s.length() <= 104
All the alphabets used in the sentence are in lower case.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
       public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String str = sc.nextLine();
            Solution ob = new Solution();
            if(ob.sentencePalindrome(str))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution { 

    static boolean sentencePalindrome(String s) { 
        // code here
        int l=0, h=s.length()-1;
        s=s.toLowerCase();
        
        while(l<=h){
            char left=s.charAt(l);
            char right=s.charAt(h);
            
            if(!(left>='a' && left<='z'))
                l++;
            else if(!(right>='a' && right<='z'))
                h--;
            else if(left==right){
                l++;
                h--;
            }
            else
                return false;
        }
        return true;
    }
}
