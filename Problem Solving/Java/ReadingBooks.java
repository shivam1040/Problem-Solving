/*
Geek is at a book fair. There are total N kinds of books. He has to choose a book of a particular kind and read it loudly as many times as he can in the given time and earn points. Geek knows that reading a book of kind i once needs Ai minutes and it will give him Bi points. Geek has K minutes for reading books. During this time, he can only read a book of a particular kind as many times as he can so as to maximize his points. But he can not pick books of different kinds, he has to read the same book again and again. Find the maximum points Geek can get. 


Example 1:

Input: 
N = 3, K = 10
A = {3, 4, 5}
B = {4, 4, 5}
Output: 12
Explaination: 
If Geek picks book of first kind he can
read it 3 times, he will get 3*4 = 12 points. 
If Geek picks book of second kind he can 
read it 2 times, he will 2*4 = 8 points.
If Geek picks book of third kind he can 
read it 2 times, he will get 2*5 = 10 points.
So the maximum possible points which he 
can earn in those 10 minutes is 12.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maxPoint() which takes N, K and A and B as input parameters and returns the maximum points Geek can earn.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ K, Ai, Bi ≤ 109  
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            long K = Long.parseLong(arr[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            String a2[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            long B[] = new long[N];
            for(int i = 0;i < N;i++){
                A[i] = Long.parseLong(a1[i]);
                B[i] = Long.parseLong(a2[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxPoint(N, K, A, B));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static long maxPoint(int N, long K, long A[], long B[])
    {
        // code here
        long res=0;
        
        for(int i=0; i<N; i++){
            long temp=K/A[i];
            if(temp*B[i]>res)
                res=temp*B[i];
        }
        return res;
    }
}
