/*
Given a floating point number in string format s, check whether it is even or odd.
 

Example 1:

Input: 
n = 4
s = 97.8
Output: EVEN
Explanation: 8 is even number.

Example 2:

Input:
n = 6
s = 100.70
Output: ODD
Explanation: Trailing 0s after dot do not matter.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isEven() which accepts a string s(floating point number) and the integer n(denotes the length of the string s) as input parameter and returns a boolean value.

 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= n <= 105

n is the length of the string s. 
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
            int n = Integer.parseInt(read.readLine());
            String s = read.readLine().trim(); 
            Solution obj = new Solution();
            if(obj.isEven(s,n))
                System.out.println("EVEN");
            else
                System.out.println("ODD");
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean isEven(String s,int n) 
    { 
        // code here
        boolean passed=false;
        for(int i=n-1; i>=0; i--){
            char ch=s.charAt(i);
            if(s.charAt(i)=='.'){
                continue;
            }
            int temp=Character.getNumericValue(s.charAt(i));
            
            if(temp==0 && !passed)
                continue;
            if(temp%2==0)
                return true;
            else
                return false;
        }
        return false;
    }
} 
