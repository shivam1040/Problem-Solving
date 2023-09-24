//{ Driver Code Starts
//Initial Template for Java

/*
A number is called faithful if you can write it as the sum of distinct powers of 7. 
e.g.,  2457 = 7 + 72 + 74 . If we order all the faithful numbers, we get the sequence 1 = 70, 7 = 71, 8 = 70 + 71, 49 = 72, 50 = 70 + 72 . . . and so on.
Given some value of N, you have to find the N'th faithful number.

 

Example 1:

Input:
N = 3
Output:
8
Explanation:
8 is the 3rd Faithful number.
Example 2:

Input:
N = 7
Output:
57
Explanation:
57 is the 7th Faithful number.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function nthFaithfulNum() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(log(N))

 

Constraints:
1 <= N <= 105
*/


/*
Just convert n to it's binary representation. Now start from the LSB and check if that bit is set then just add the power(7, that_set_bit_position-1) to the answer. and finally return the answer.  
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nthFaithfulNum(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long nthFaithfulNum(int N) {
       // code here
       long ans=0;
       int i=0;
       
       while(N!=0){
           int lastDigit=N&1;
           ans+=Math.pow(7, i)*lastDigit;
           i++;
           N=N>>1;
       }
       
       return ans;
    }
};
