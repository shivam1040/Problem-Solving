/*
Pappu is confused between 6 & 9. He works in the billing department of abc company and his work is to return the remaining amount to the customers. If the actual remaining amount is given we need to find the maximum possible extra amount given by the pappu to the customers.

Example 1:

Input: amount = 56
Output: 3
Explanation: maximum possible extra 
             amount = 59 - 56 = 3.
Example 2:

Input: amount = 66
Output: 33
Explanation: maximum possible extra 
             amount = 99 - 66 = 33.
User Task:
Your task is to complete the function findDiff() which takes single argument(amount) and returns the answer. You need not take any input or print anything.

Expected Time Complexity: O(log10amount).
Expected Auxiliary Space: O(log10amount).

Constraints
1 ≤ N≤ 10000001
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
            long amount = Long.parseLong(read.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.findDiff(amount);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long findDiff(long amount) 
    {
        // code here
        String temp=String.valueOf(amount);
        String aux="";
        
        for(int i=0; i<temp.length(); i++){
            char ch=temp.charAt(i);
            
            if(ch=='6')
                ch='9';
            aux+=ch;
        }
        
        return Long.parseLong(aux)-amount;
    }
} 

