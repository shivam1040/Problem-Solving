/*
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input: str1 = "heap", str2 = "pea"
Output: 3
Explanation: 2 deletions and 1 insertion
p and h deleted from heap. Then, p is 
inserted at the beginning One thing to 
note, though p was required yet it was 
removed/deleted first from its position 
and then it is inserted to some other 
position. Thus, p contributes one to the 
deletion_count and one to the 
insertion_count.
Example 2:

Input : str1 = "geeksforgeeks"
str2 = "geeks"
Output: 8
Explanation: 8 deletions
 

Your Task:
You don't need to read or print anything. Your task is to complete the function minOperations() which takes both strings as input parameter and returns the minimum number of operation required.

Expected Time Complexity: O(|str1|*|str2|)
Expected Space Complexity: O(|str1|*|str2|)

Constraints:
1 ≤ |str1|, |str2| ≤ 1000
All the characters are lower case English alphabets
*/

/*
An efficient approach uses the concept of finding the length of the longest common subsequence of the given two sequences.

Algorithm: 

str1 and str2 be the given strings.
m and n be their lengths respectively.
len be the length of the longest common subsequence of str1 and str2
minimum number of deletions minDel = m – len (as we only need to delete from str1 because we are reducing it to str2)
minimum number of Insertions minInsert = n – len (as we are inserting x in str1 , x is a number of characters in str2 which are not taking part in the string which is longest common subsequence )
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int lcs=LongestRepeatingSubsequence(str1, str2);
	    return str1.length()-lcs+str2.length()-lcs;
	}
	
	 public int LongestRepeatingSubsequence(String str1, String str2)
    {
        int prev;
        int curr[]=new int[str2.length()+1];
        
        for(int i=1; i<=str1.length(); i++){
            prev=0;
            for(int j=1; j<=str2.length(); j++){
                 int prev1=curr[j];
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                   curr[j]=1+prev;
                }
                else{
                    curr[j]=Math.max(curr[j], curr[j-1]);
                }
                prev=prev1;
            }
        }
         return curr[str2.length()];
    }
}
