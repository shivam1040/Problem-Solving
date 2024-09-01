/*
Given a string S. Let k be the maximum number of partitions possible of the given string with each partition starts with a distinct letter. The task is to find the number of ways string S can be split into k partition (non-empty) such that each partition starts with a distinct letter. Print number modulo 1000000007.

Note : S consists of lowercase letters only.

 

Example 1:

Input:
S = "abb"
Output:
2
Explanation:
 "abb" can be maximum split into 2 partitions
{a, bb} with distinct starting letter, for k = 2.
And, the number of ways to split "abb"
into 2 partitions with distinct starting letter
are 2 {a, bb} and {ab, b}.
Example 2:

Input:
S = "abbcc"
Output:
4
Explanation:
"abbcc" can be maximum split into 3 partitions
with distinct letter, so k=3. Thus the number
of ways to split "abbcc" into 3 partitions with
distinct letter is 4 i.e. {ab, b, cc},
{ab, bc, c},{a, bb, cc} and {a, bbc, c}. 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function waysToSplit() which takes a String S and returns the answer.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|1|)

 

Constraints:
1 <= |S| <=105
*/

/*
Let’s take an example, say s = “acbbcc”, we have discussed about first character ‘a’ above. Now, to deal with ‘b’ and ‘c’, observe ‘b’ occurs at two positions in the string whereas ‘c’ at three. If we select any positions out of two for ‘b’ and any one position out of three for ‘c’, then, we can partition the string at those positions. Note that number of parts will be equal to 3 (equals to number of distinct characters in s i.e k).

So generalizing the observation, let counti be the number of occurrences of character i in s. So our answer will be product of counti of all i’s such that i occurs in the string and i is not equal to first character of the string.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.waysToSplit(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int waysToSplit(String S){
        // code here
        Map<Character, Integer> aux=new HashMap<>();
        int res=1;
        
        for(char i:S.toCharArray())
            aux.put(i, aux.getOrDefault(i, 0)+1);
        aux.put(S.charAt(0), 1);
        for(int i:aux.values()){
            res*= i;
            res%=1000000007;
        }
        return res;
    }
};
