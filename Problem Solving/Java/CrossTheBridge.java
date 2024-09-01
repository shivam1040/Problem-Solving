/*
Given a string S of '$'s and '.'s. '$' are planks on the bridge and '.'s are the broken sections of the bridge. You can jump up to only that much gap (number of '.') of the broken section which you have already jumped over previously otherwise it takes you 1 day to learn how to jump that far. You have to find how many days will you take to cross the bridge.

Example 1:

Input:
S = $$..$$...$.$
Output:
2
Explanation:
1 day is required to practice
for 2 dots.Then next time 3 
dots are encountered so 1 more
day to practice. Then since 1 
dot is there you can easily do
that because you have already 
mastered for 3 dots.
Example 2:

Input:
S = $$$$.$
Output:
1
Explanation:
Only one is required to learn
to jump 1 gap.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findDays() which takes the string S as input parameters and returns the total number of days you would take to cross the bridge.
 

Expected Time Complexity: O(|S|)
Expected Space Complexity: O(|S|)
 

Constraints:
1 ≤ T ≤ 100
1 ≤ |S| ≤ 104
S will consist of only the characters '$' and '.'
The first and the last characters of S will be '$'
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String X =read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.findDays(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{   
    static int findDays(String S){
        //code here
        int temp=0, learn=0, days=0;
        
        for(char i:S.toCharArray()){
            if(i=='$' && temp>0){
                if(temp>learn){
                    learn=temp;
                    days++;
                }
                temp=0;
            }
            else if(i=='.')
             temp++;
        }
        return days;
    }
}
