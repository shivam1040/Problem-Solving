/*
A sequence a[0], a[1], …, a[N-1] is called decreasing if a[i] >= a[i+1] for each i: 0 <= i < N-1. You are given a sequence of numbers a[0], a[1],…, a[N-1] and a positive integer K. In each 'operation', you may subtract K from any element of the sequence. You are required to find the minimum number of 'operations' to make the given sequence decreasing.
Note: As the answer can be large return your answer modulo 109+7.

 

Example 1:

Input:
N = 4, K = 5
A[] = {1, 1, 2, 3}
Output:
3
Explanation:
One operation is required to change a[2] = 2
into -3 and two opertations are required to
change a[3] = 3 into -7. The resulting
sequence will be 1 1 -3 -7. Hence, in
total 3 operations are required.
 

Example 2:

Input:
N=5, K = 2
A[] = {5, 4, 3, 2, 1}
Output:
0
Explanation:
The sequence is already decreasing. Hence,
no operations are required in both the cases.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minMoves() which takes the array A[], its size N and an integer K as inputs and returns the minimum number of ‘operations’. Return your answer modulo 109+7.



Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 106
1 <= K <= 100
-106 <= a[] <= 106
*/

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.minMoves(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {

    public long minMoves(long a[], long n, long k) {
        long res=0;
        
        for(int i=1; i<n; i++)
            if(a[i]>a[i-1]){
                long diff=a[i]-a[i-1];
                //this gives in how many times the diff can be covered
                long div=(long)Math.ceil((double)diff/k);
                res+=div;
                a[i]=a[i]-div*k;
            }
        return res%1000000007;
        //         long cnt = 0;
        // for (int i = 1; i < n; i++) {
        //     if (a[i] > a[i - 1]) {
        //         long diff = a[i] - a[i - 1];
        //         long times = (int) Math.ceil((double) diff / k);
        //         cnt = (cnt + times) % 1000000007;
        //         a[i] = a[i] - times * k;
        //     }
        // }
        // return cnt % 1000000007;
    }
}
