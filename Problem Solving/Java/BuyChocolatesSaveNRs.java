/*
Geek wants to buy chocolates. The shop only has two types of chocolates. One costs 3 rupees and the other cost 7 rupees. Geek has 100 rupees. Is it possible for him to save exactly N rupees after visiting the shop?


Example 1:

Input: N = 99
Output: 0
Explanation: Geek needs to save 99 rupees. 
That means he can only spend 1 rupee. But 
no chocolate is available for 1 rupee. Therefore 
there is no way for him to save N rupees. 

Example 2:

Input: N = 97
Output: 1
Explanation: Geek can buy one chocolate 
for 3 rupees and save 97 rupees.

Your Task:
You do not need to read input or print anything. Your task is to complete the function isPossible() which takes N as input parameter and returns 1 if Geek can save N rupees else returns 0.


Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)


Constraints:
0 ≤ N ≤ 100


*/

/*
100 - N: This calculates the amount of money Geek would have left if he buys chocolates worth N rupees. It represents the remaining money after buying chocolates.

(100 - N) % 3: This calculates the remainder when the remaining money is divided by 3. In other words, it checks how much money is left after buying chocolates in multiples of 3 rupees.

(100 - N) % 3 * 7: This part calculates the product of the remainder from step 2 and 7. It represents the additional money Geek can save if the remaining money is spent on 7-rupee chocolates.

100 - N >= (100 - N) % 3 * 7 ? 1 : 0: This is a conditional expression. It checks if the remaining money (100 - N) is greater than or equal to the additional savings calculated in step 3. If this condition is true, it returns 1, indicating that Geek can save exactly N rupees. If the condition is false, it returns 0, indicating that Geek cannot save exactly N rupees.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isPossible(int N){
        // code here
        return 100-N>=(100-N)%3*7 ? 1 : 0;
    }
}
