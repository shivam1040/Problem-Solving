/*
If all decimal numbers are concatenated in a string then we will get a string which looks like string P as shown below. We need to tell Nth character of this string.
P = “12345678910111213141516171819202122232425262728293031….”

Example 1:

Input: N = 10
Output: 1
Explaination: From the given portion of the 
string you can see that the 10th character is 
'1'.
Example 1:

Input: N = 11
Output: 10
Explaination: From the given portion of the 
string yuou can see that the 11th character is 
'0'.
Your Task:
You do not need to read input or print anything. Your task is to complete the function NthCharacter() which takes N as input parameter and returns the Nth character of the string P.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105  
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
             Solution ob = new Solution();
            System.out.println(ob.NthCharacter(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char NthCharacter(int N){
        // code here
        int i=0, j=1;
        
        while(true){
            int nc=(int)Math.log10(j)+1;
            
            if(i+nc>=N){
                int temp=j;
                List<Character> arr=new ArrayList<>();
                
                while(temp>0){
                    arr.add((char) (temp%10+'0'));
                    temp/=10;
                }
                Collections.reverse(arr);
                return arr.get(N-i-1);
            }
            i+=nc;
            j++;
        }
    }
}
