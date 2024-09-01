/*
Given a number X and another number Y . There are a total  N cycles ,  and alternatively we perform operation on each number . In each cycle , we multiply the number by 2 . Starting with X .

Suppose after all the N cycles, the number X has become W and  number Y has become Z . Find the integer division of the maximum number among W and Z by the minimum number among W and Z .
 

Example 1:

Input: x = 1, y = 2, n = 1
Output: 2
Explanation:  the initial numbers are (X = 1,
Y = 2). There is only one turn. In this turn X 
is multiplied by 2. Hence, we get (X = 2, 
Y = 2) 
Therefore W = 2, and Z = 2. 
max (W , Z) / min (W , Z) =  2 / 2  = 1. 
Hence the first output is 1.
Example 2:

Input: x = 3, y = 2, n = 3
Output: 3
Explanation: the initial numbers are (X = 3,
Y = 2). There three turns. In the first cycle 
X is multiplied by 2.So, we get (X = 6, Y = 2).
In the second cycle Y (Y = 2) multiplies his 
number by 2. Hence, we get  ( X = 6,  Y = 4 ). 
In the third cycle  X ( X = 6) is multiplied by 
2. So, we get (X = 12, Y = 4) . As N = 3 , 
completed with 3 cyles, therefore W = 12 and 
Z = 4. max (W ,  Z) / min (W , Z) = 12 / 4 = 3. 
Hence the second output is 3. 
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function find_division() which takes X, Y and N as input parameter and returns the integer division of max(w, z) / min(w, z)
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= X, Y <= 108
1 <= N <= 109
*/

/*
The code checks if N is odd (n % 2 != 0). If it is odd, it means that the last operation was a multiplication by 2 for X. This is because, in each cycle, either X or Y is multiplied by 2, and if N is odd, it implies that X was the last to be multiplied.

If N is odd, the code multiplies X by 2. This ensures that both X and Y have undergone the same number of multiplications by 2.

After making sure that X and Y have undergone the same number of operations, it calculates the maximum and minimum values between X and Y.

Finally, it performs the integer division of the maximum by the minimum to get the result.

The key insight here is that, regardless of the number of cycles, if both X and Y have undergone the same number of multiplications by 2, their ratios will remain the same. Therefore, the code only needs to adjust X to ensure this equality and then calculates the result efficiently without simulating all N cycles. This approach is based on mathematical reasoning and reduces the problem to O(1) time complexity.
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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int x = Integer.parseInt(S[0]);
            int y = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            int ans = ob.find_division(x, y, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int find_division(int x, int y, int n)
    {
        // code here
        //basic maths we know even if we multiple a number into v then the ratio is always gonna remian same with the other number if it goes through same multiplication cycle, so in this case taking one cycle into consideration
        x=n%2!=0 ? x*2 : x;
        
        return Math.max(x,y)/Math.min(x,y);
    }
}
