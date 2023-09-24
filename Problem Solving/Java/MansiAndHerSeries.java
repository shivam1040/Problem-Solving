/*
Mansi is fond of solving mental ability questions. Today while solving some questions she came across a series which she was unable to solve. Help her to find the nth term of the series.
n  nth term
1  3
2  8
3  18
4  32
5  60
.
.
.
10  300

Example 1:

Input: n = 1
Output: 3 
Explanation: The first term of the series is 3.
Example 2:

Input: n = 2
Output: 8
Explanation: The second term of the series is 3. 

Your Task:  
You dont need to read input or print anything. Complete the function nthTerm() which takes n as input parameter and returns the nth term of the series.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)

Constraints:
1<= n <=6000
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthTerm(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

//User function Template for Java
class Solution {
    static int nthTerm(int n){
        // code here
        //logic is find nth prime, do (prime+1)*n
                int i=0;
        int ans=0;
        for(int num=2;i<n;num++){
            if(prime(num)){
                ans=num;
                i++;
            }
        }
        return (ans+1)*n;
    }
    
        static boolean prime(int n)
    {
              for(int i=2;i<=Math.sqrt(n);i++){
          if(n%i==0){
              return false;
          }
      }
      return true;
    }
}
