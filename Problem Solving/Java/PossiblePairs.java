/*
Given X and Y as the GCD and LCM of two numbers A and B. Find all possible pairs of (A,B).
Note: (a, b) and (b, a) are considered as two different pairs.

Example 1:

Input: x = 2, y = 12
Output: 4
Explaination: The pairs are (2, 12), 
(4, 6), (6, 4) and (12, 2).

Example 2:

Input: x = 3, y = 6
Output: 2
Explaination: The pairs are (3, 6) and 
(6, 3).

Example 3:

Input: x = 6, y = 4
Output: 0
Explaination: There is no such pair such 
that gcd is 6 and lcm is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function pairCount() which takes x and y as input parameters and returns the number of possibe pairs.


Expected Time Complexity: O(sqrt(N)*LogN)    [N is maximum of x and y]
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ x, y ≤ 104
*/

/*
Since a and b both will be less than or equal to lcm(a, b) L, so we try all possible pairs that have product equal to L * G. Note that product of a and b is same as product of gcd(a, b) and lcm(a, b), a*b = G*L.
Here is our algorithm 
 

p = G*L
count = 0
for a = 1 to L
    if p%a == 0 and gcd(a, p/a) = G
        count++
    end if
end for
return count
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
            String arr[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.pairCount(x, y));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int pairCount(int x, int y){
        // code here
        int res=0, p=x*y;
        
        for(int i=1; i<=y; i++)
            if(p%i==0 && gcd(i, p/i)==x)
                res++;
        return res;
    }
    
     static int gcd(int a, int b){
        if (a == 0)
            return b;
        return gcd(b%a , a);
    }
}
