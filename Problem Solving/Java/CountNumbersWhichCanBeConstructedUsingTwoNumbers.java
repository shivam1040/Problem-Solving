/*
Given three positive integers x, y and n, the task is to find count of all numbers from 1 to n that can be formed using x and y. A number can be formed using x and y if we can get it by adding any number of occurrences of x and/or y.

 

Example 1:

Input:
x = 2, y = 3, n = 10
Output:
9
Explanation:
We can form 9 out of 10 numbers using
2 and 3 and 10; 2 = 2, 3 = 3, 4 = 2+2,
5 = 2+3, 6 = 3+3 7 = 2+2+3, 8 = 3+3+2,
9 = 3+3+3 , 10 = 3+3+2+2.
Example 2:

Input:
x = 5, y = 7, n = 10
Output:
3
Explanation:
We can form 3 out of 10 numbers using
5 and 7 and 10; 5 = 5, 7 = 7, 5+5 = 10.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getCount() which takes 3 Integers x,y and n respctively as input and returns the answer.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

 

Constraints:
1 <= x,y,n <= 105
*/

/*
An efficient solution solution is to use a boolean array arr[] of size n+1. An entry arr[i] = true is going to mean that i can be formed using x and y. We initialize arr[x] and arr[y] as true if x and y are smaller than or equal to n. We start traversing the array from smaller of two numbers and mark all numbers one by one that can be formed using x and y.
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
            
            int x = Integer.parseInt(S[0]);
            int y = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.getCount(x,y,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution {
    static int getCount(int x, int y, int n) {
        // code here
        boolean[] aux=new boolean[n+1];
        
        if(x<=n)
            aux[x]=true;
        if(y<=n)
            aux[y]=true;
        int res=0;
        
        for(int i=Math.min(x, y); i<=n; i++)
            if(aux[i]){
                if(i+x<=n)
                    aux[i+x]=true;
                if(i+y<=n)
                    aux[i+y]=true;
                res++;
            }
        return res;
    }
};`

