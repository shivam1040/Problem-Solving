/*
Given a string of digits 0 – 9. The task is to count the number of substrings which when converting into integer form an even number.

Example 1:

Input : s = "1234".
Output : 6
Explanation: "2", "4", "12", "34", "234",
"1234" are 6 substring which are even.
Example 2:

Input : s = "154".
Output : 3
Explanation: "154", "54", "4" are the 
even substrings.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function evenNumSubstring() which takes the string as inputs and returns the count of even substring.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105
*/

/*
For each iteration, we check if the current digit at position i in the string is even. We do this by converting the character to an integer using int(string[i]) and checking if the resulting number modulo 2 (int(string[i]) % 2) equals 0. If it does, it means the digit is even.

If the digit is even, we increment the count by the index i. This is because for each even digit, all the substrings ending at position i and starting from a previous even digit will form new even numbers. By adding i to the count, we account for all these additional substrings.

For example, let's consider the string "12345". The even digits are "2" and "4". When i is 1 (corresponding to the digit "2"), we add 1 to the count. When i is 4 (corresponding to the digit "4"), we add 4 to the count. This accounts for substrings like "2", "4", "24", "4", and "4".
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String S= read.readLine();
            
            Solution ob = new Solution();
            long ans = ob.evenNumSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long evenNumSubstring(String s)
    {
        //Your code here
        long res=0;
        
        for(int i=0; i<s.length(); i++){
            int c=s.charAt(i) - '0';
            
            if(c%2==0)
                res+=(i+1);
            
        }
        return res;
    }
}
