/*
Given two integers b and p. Find the number of integral solutions to x2 = 1 (mod p) in the closed interval [1, b].

 

Example 1:

Input:
b = 5, p = 7
Output:
1
Explanation:
12 = 1%7 = 1. 1 is the only possible
solution in the range [1,5].
Example 2:

Input:
b = 8, p = 6
Output:
3
Explanation:
There are 3 possible solutions.
12 = 1%6 = 1
52 = 25%6 = 1
72 = 49%6 = 1
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfSol() which takes 2 Integers b, and p as input and returns count of numbers in the range [1,b] that give a reamainder of 1 when the squared number is divided with p.

 

Expected Time Complexity: O(p)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= b <= 109
1 <= p <= 105
*/

/*
One simple solution is to go through all numbers from 1 to n. For every number, check if it satisfies the equation. We can avoid going through the whole range. The idea is based on the fact that if a number x satisfies the equation, then all numbers of the form x + i*p also satisfy the equation. We traverse for all numbers from 1 to p and for every number x that satisfies the equation, we find the count of numbers of the form x + i*p. To find the count, we first find the largest number for given x and then add (largest-number – x)/p to the result.



The code iterates through all values of 
�
x from 1 to 
�
−
1
p−1, checking if 
(
�
2
)
m
o
d
 
 
�
(x 
2
 )modp equals 1. If it does, then it finds the last value of 
�
x in the interval 
[
1
,
�
]
[1,b] that satisfies this condition. This is done by adding multiples of 
�
p to 
�
x until the next multiple exceeds 
�
b, and then subtracting 
�
p to get the last value within the interval.

The number of solutions for this particular 
�
x is then calculated as 
last
−
�
�
+
1
p
last−x
​
 +1, which represents the number of multiples of 
�
p in the interval 
[
�
,
last
]
[x,last]. The total number of solutions is accumulated in the variable res.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            Long b = Long.parseLong(S[0]);
            Long p = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.noOfSol(b,p));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long noOfSol(Long b, Long p) {
        // code here
        long res=0;
        
        for(long x=1; x<p; x++)
            if((x*x)%p==1){
                long last=x+p*(b/p);
                
                if(last>b)
                    last-=p;
                res+=(last-x)/p+1;
            }
        return res;
    }
};
