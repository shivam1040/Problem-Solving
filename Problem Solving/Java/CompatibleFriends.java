/*
Suppose there are two friends and now they want to test their friendship that how much compatible they are. Given the numbers n numbered from 1 to n and they are asked to rank the numbers. The task is find the compatibility difference between them. Compatibility difference is the number of mis-matches in the relative ranking of the same movie given by them.

Example 1:

Input : N=5
        a1[] = {3, 1, 2, 4, 5}
        a2[] = {3, 2, 4, 1, 5}
Output : 2
Explanation : Compatibility difference is two
              because first ranks movie 1 before
              2 and 4 but other ranks it after.

Example 2:
 

Input : N=5
        a1[] = {5, 3, 1, 2, 4}
        a2[] = {3, 1, 2, 4, 5}
Output: 5
Explanation: Total difference is four due to
             mis-match in position of 5.
â€‹

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findDifference() that takes array A1,array A2 and integer N as parameters and returns the compatibility difference.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class GFG
{
    long findDifference(long a1[], long a2[], int n)
    {
        //Your code here
        int res=0;
        //just making arrays equal and finding num of mvoes required
        for(int i=0; i<n; i++){
            int temp=i+1;
            
            while(a1[i]!=a2[i]){
                res++;
                
                long temp1=a1[temp];
                a1[temp]=a1[i];
                a1[i]=temp1;
                temp++;
            }
        }
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
    //        int k = Integer.parseInt(br.readLine());
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            //int k = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            long ans=ob.findDifference(a,b,n);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
