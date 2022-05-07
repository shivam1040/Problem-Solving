// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        char arr[]=str.toCharArray();
        int prev;
        int curr[]=new int[arr.length+1];
        for(int i=1; i<=arr.length; i++){
            prev=0;
            for(int j=1; j<=arr.length; j++){
                 int prev1=curr[j];
                if(arr[i-1]==arr[j-1] && i!=j){
                   curr[j]=1+prev;
                }
                else{
                    curr[j]=Math.max(curr[j], curr[j-1]);
                }
                prev=prev1;
            }
        }
         return curr[arr.length-1];   
    }

}

//this can be solved recursively
/*
Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.

Example 1:

Input:
str = "axxzxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x z x y 
0 1 2 3 4 5

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 4  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.
Example 2:

Input:
str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y 
0 1 2 3 4

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.

Your Task:
You don't need to read or print anything. Your task is to complete the LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.


Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)


Constraints:
1 <= |str| <= 103
*/

/*
Recursively program is formed using these steps
think in terms of indexes when it is string
think about all the possibilities
think about base case for function exit

in this question

Character of string at i index should be equal to Character of string at j imdex and i!=j

if above case is met then decrement both the indexes by 1 run the function again

if not then decrement only one index and call the function, decrement only second index and find max between both

store this answers in a dp array to use memoization

if(i<0 || j<0)
    return 0;
    
if(s[i]==s[j] && i!=j)
    return 1+f(i-1, j-1)
if(s[i]!=s[j])
    return max(f(i-1, j), f(i, j-1))
    
*/