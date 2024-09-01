/*
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded, as the answer can be large return the answer modulo 109 + 7.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0s, extra trailing 0s and two or more consecutive 0s then it is an invalid string.

Example 1:

Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).
Example 2:

Input: str = "90"
Output: 0
Explanation: "90" cannot be decoded as it's an invalid string and we cannot decode '0'.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function CountWays() which takes the string as str as input parameter and returns the total number of ways the string can be decoded modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(n) where n  = |str|

Constraints:
1 <= |str| <= 104


*/

/*
Intuition:
One of the basic intuition is that we need to find the total number of  ways to decode the given string such that each and every number in the string must lie in between the range of [ 1 , 26 ] both inclusive and without any leading 0’s.

Implementation:
Example: str = “123”

If we observe carefully we can observe a pattern over here i.e., the number of ways a particular substring can be decoded depends on the number of ways the remaining string is going to be decoded . For example , we want the number of ways to decode the string with “1” as a prefix the result depends on the number of ways the remaining string, i.e., “23” can be decoded . The number of ways the string “23” can be decoded are “2” , “3” and “23” there are 2 ways in both of these cases we can just append “1” to get the number of ways the given string can be decoded with “1” as a prefix i.e., “1” , “2” , “3” and “1” , “23” . Now we have found the number of ways we can decode the given string with “1” as a prefix but “12” also lies in between the range of [ 1 , 26 ] both inclusive the number of ways to decode the given string with “12” as a prefix depends on the result on how the remaining string is decoded . Here the remaining string is “3” it can be decoded in only 1 way so we can just append “12” in front of the string “3” to get it i.e., “12” , “3” . So the total number of ways the given string can be decoded are 3 ways .

But we can see some of the overlapping of subproblems over here i.e., when we are computing the total number of ways to decode the string “23” we are computing the number of ways the string “3” can be decoded as well as when we are computing the number of ways the string “12” can be decoded we are again computing the number of ways the string “3” can be decoded . So we can avoid this by storing the result of every substring . Here we can identify each and every sub problem through the index of the string . So , if at any point of time if we have already computed the number of ways the substring can be decoded we can directly return the result and that leads to a lot of optimization.


*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String s)
    {
        // code here
        if(s.charAt(0)=='0')
            return 0;
        char[] str=s.toCharArray();
        int mod=1000000007;
        int[] dp=new int[s.length()+1];
        //setting base case
        dp[0]=dp[1]=1;
        
        for(int i=0; i<str.length; i++)
        //if any char is 0 then not possible 
            if(str[i]=='0' && str[i-1]>'2')
                return 0;
        for(int i=2; i<=str.length; i++){
            //considering first digit as pair
            if(str[i-1]>'0')
                dp[i]=dp[i-1];
            //considering last two digit as pair
            if(str[i-2]=='1' || (str[i-2]=='2' && str[i-1]<'7'))
                dp[i]+=dp[i-2];
            dp[i]%=mod;
        }
        return dp[s.length()];
    }
}
