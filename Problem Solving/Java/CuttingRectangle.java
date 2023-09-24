/*
Given a rectangle of dimensions L x B find the minimum number (N) of identical squares of maximum side that can be cut out from that rectangle so that no residue remains in the rectangle. Also find the dimension K of that square.

Example 1:

Input: L = 2, B = 4
Output: N = 2, K = 2
Explaination: 2 squares of 2x2 dimension.

Example 2:

Input: L = 6, B = 3
Output: N = 2, K = 3
Explaintion: 2 squares of 3x3 dimension. 

Your Task:
You do not need to read input or print anything. Your task is to complete the function minimumSquares() which takes L and B as input parameters and returns a list of 2 integers containing the values of N and K respectively.


Expected Time Complexity: O(log min(L, B))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ L, B ≤ 109


*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long B = Long.parseLong(input_line[1]);

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<Long>();
            ans = ob.minimumSquares(L, B);
            System.out.print(ans.get(0)+" ");
            System.out.println(ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Long> minimumSquares(long L, long B)
    {
        // code here
        long x=gcd(L, B);
        long y= (L/x) * (B/x);
        List<Long> res = new ArrayList<>();
        
        res.add(y);
        res.add(x);
        return res;
        
    }
    
      private static long gcd(long a, long b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;
 
        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
}
