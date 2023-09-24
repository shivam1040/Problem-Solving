/*
There are N people in a room. If two persons shake hands exactly once, find the maximum number of handshakes possible. 

 

Example 1:

Input: N = 2
Output: 1
Explaination: There are two people and they 
can shake hands maximum one time.
 

Example 2:

Input: N = 3
Output: 3
Explaination: Let the people be person 1, 2 and 3. 
So the possible handshakes are (1, 2), (2, 3) and 
(1, 3).
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function handShakes() which takes N as input parameter and returns the maximum number of handshakes possible.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
2 ≤ N ≤ 109
*/

/*
To maximize the number of handshakes, each person should shake hand with every other person in the room. For the first person, there would be N-1 handshakes. For second person there would N-1 person available but he had already shaken hand with the first person. So there would be N-2 handshakes and so on. 
So, Total number of handshake = N-1 + N-2 +….+ 1 + 0, which is equivalent to ((N-1)*N)/2 
(using the formula of sum of first N natural number).
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
            long N = Long.parseLong(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.handShakes(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long handShakes(long n){
        // code here
        return n*(n-1)/2;
    }
}
