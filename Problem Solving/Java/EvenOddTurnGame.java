/*
Given three positive integers X, Y and P. Here P denotes the number of turns. Whenever the turn is odd X is multiplied by 2 and in every even turn Y is multiplied by 2.Find the value of Max(X, Y) ÷ Min(X, Y) after the completion of P turns.

Example 1:

Input:
X=1
Y=2
P=1
Output:
1
Explanation:
After 1st turn,
X=2,Y=2.
Now Max(X,Y)/Min(X,Y)=1.
Example 2:

Input:
X=2
Y=1
P=2
Output:
2
Explanation:
After first turn,
X=4,Y=1
After Second turn,
X=4,Y=2.
Now,Max(X,Y)/Min(X,Y)=4/2=2.

Your Task:
You don't need to read input or print anything.Your task is to complete the function findValue() which takes 3 integers X,Y,P as input parameters and returns the value of Max(X,Y)/Min(X,Y) after P turns.


Expected Time Complexity:O(1)
Expected Auxillary Space:O(1)


Constraints:
1<=X,Y,P<=109
*/

/*
Lets play the above game for 8 turns : 
 

| i    | 0 | 1  | 2  | 3  | 4  | 5  | 6  | 7   | 8   |
|------|---|----|----|----|----|----|----|-----|-----|
| X(i) | X | 2X | 2X | 4X | 4X | 8X | 8X | 16X | 16X |
| Y(i) | Y | Y  | 2Y | 2Y | 4Y | 4Y | 8Y | 8Y  | 16Y |
Here we can easily spot a pattern : 
 

if i is even, then X(i) = z * X and Y(i) = z * Y.
if i is odd, then X(i) = 2*z * X and Y(i) = z * Y.
Here z is actually the power of 2. So, we can simply say – 
 

If P is even output will be max(X, Y) ÷ min(X, Y) 
else output will be max(2*X, Y) ÷ min(2*X, Y).
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] inp = read.readLine().split(" ");
            int X = Integer.parseInt(inp[0]);
            int Y = Integer.parseInt(inp[1]);
            int P = Integer.parseInt(inp[2]);
            Solution ob = new Solution();
            System.out.println(ob.findValue(X, Y, P));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int findValue(int X, int Y, int P) {
        // code here
        //keeping multiplying wouldn't make any difference since they all would be power of two so single multiplication with 2 is fine
        return P%2==0 ? Math.max(X, Y)/Math.min(X, Y) : Math.max(X*2, Y)/Math.min(X*2, Y);
    }
}
