/*
Given an array Arr[] of N distinct integers. Write a program to find the count of groups of 2 or 3 integers that can be formed by choosing integers from the given array such that sum of integers in each of the group is divisible by three.

 

Example 1:

Input:
N = 4
Arr[] = {1, 2, 3, 5}
Output:
4
Explanation:
There are only 4 possible groups: (1,2,3);
(1,2) ; (1,5) ; (1,3,5)
Example 2:

Input:
N = 3
Arr[] = {1, 1, 1}
Output:
1
Explanation:
There is only 1 possible group: (1,1,1).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfGroups() which takes an Integer N and an array Arr as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= Arr[i] <= 105
*/

/*
If we carefully look at every number, we realize that 3 options exist: 
 

The number is divisible by 3
The number leaves a remainder of 1, when divided by 3
The number leaves a remainder of 2, when divided by 3

Now, for groups of two being divisible by 3, either both number have to belong to category 1 (both are divisible by 3), or one number should leave a remainder 1, and the other a remainder 2. This way the remainders add up to 3, making the sum divisible by 3. 
To form a group of three, either all three numbers should give the same remainder, or one should give remainder 0, another should give 1, and the last should give 2.
In this way, we do not care about the numbers themselves, but their respective remainders. Thus by grouping them into three categories, we can find the total possible groups using a simple formula. 
Let C1 be number of elements divisible by 3. 
Let C2 be number of elements leaving remainder 1. 
Let C3 be number of elements leaving remainder 2. 
 

Answer = 
C2 * C3 + C1 * (C1 - 1) / 2    --> Groups of 2
+ C1 * (C1 - 1) * (C1 - 2) / 6 
+ C2 * (C2 - 1) * (C2 - 2) / 6 
+ C3 * (C3 - 1) * (C3 - 2) / 6 --> Groups of 3 
                   with elements of same remainder
+ C1 * C2 * C3 --> Groups of three with all
                         distinct remainders
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
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            
            int[] Arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                Arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.noOfGroups(N,Arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long noOfGroups(int N , int[] Arr) {
        // code here
        /*
        count 0,1,2's remainder of every digit.
Then for 2 digit combination 2 possible way:
1) 2 r0
2) 1 r1, 1 r2
Then for 3 digit combination 4 possible way
1)3 r0
2)3 r1
3)3 r2
4)1 r0, 1 r1, 1 r2
result is the sum of all possibility
        */
        long c[]=new long[3];
        for(int i:Arr)
            c[i%3]++;
        return c[1]*c[2]+c[0]*(c[0]-1)/2+c[0]*(c[0]-1)*(c[0]-2)/6+c[1]*(c[1]-1)*(c[1]-2)/6+c[2]*(c[2]-1)*(c[2]-2)/6+c[0]*c[1]*c[2];
    }
};
