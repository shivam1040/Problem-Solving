/*
Assume you are an awesome parent of N children and want to give your children some cookies out of given M cookies. But, you should give each child atmost one cookie.
Each child i has a greed factor greed [ i ], which is the minimum size of cookie that the child will be content with; and each cookie j has a size sz [ j ]. If sz [ j ] >= greed [ i ], we can assign the cookie j to the child ith, and the child i will be content.
Your goal is to maximize the number of your content children and return the maximum number.

Example 1:

Input:
N = 3 
M = 2
greed [ ] = {1, 2, 3}
sz [ ] = {1, 1}
Output: 1
Explanation: 
You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to return 1.
 

Example 2:

Input:
N = 2 
M = 3
greed [ ] = {1, 2}
sz [ ] = {1, 2, 3}
Output: 2
Explanation: 
You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children.
You need to output 2.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxChildren() which takes the interger N, integer M and two integer array greed [ ] and sz [ ] as parameters and returns the maximum number of content children.

Expected Time Complexity: O(max( NlogN , MlogM ))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤  5 * 104
1 ≤ M ≤  5 * 104
1 ≤ greed [ i ] , sz [ i ] ≤ 109


*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int b[] = new int[m];
      for(int i=0;i<m;i++){
        b[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.maxChildren(n, m,a, b);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxChildren(int N,int M,int greed[], int sz[]) {
    // code here
    int res=0;
    
    Arrays.sort(greed);
    Arrays.sort(sz);
    
    for(int i=0, j=0; i<sz.length && j<greed.length; i++){
        if(sz[i]>=greed[j]){
            res++;
            j++;
        }
    }
    
    return res;
  }
}

