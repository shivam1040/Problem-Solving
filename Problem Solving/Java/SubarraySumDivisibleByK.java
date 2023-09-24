/*
You are given an array A of N positive and/or negative integers and a value K. The task is to find the count of all sub-arrays whose sum is divisible by K.

Example 1:

Input: N = 6, K = 5
       arr[] = {4, 5, 0, -2, -3, 1}
Output: 7
Explanation: There are 7 sub-arrays whose 
is divisible by K {4, 5, 0, -2, -3, 1}, {5}, 
{5, 0}, {5, 0, -2, -3}, {0}, {0, -2, -3} 
and {-2, -3}
Example 2:

Input: N = 6, K = 2
       arr[] = {2, 2, 2, 2, 2, 2}
Output: 21
Explanation: All subarray sums are 
divisible by 7

 

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function subCount() that takes array arr, integer N, and integer K as parameters and returns the desired output.

Expected Time Complexity: O(N+K).
Expected Auxiliary Space: O(K).

 

Constraints:
2 ≤ N ≤ 105


*/

//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    long subCount(long arr[] ,int n,int k)
    {
        Map<Long, Integer> aux=new HashMap<>();
        long sum=0, res=0, rem=0;
        
        //putting 1 bexause 0 sum is already accounted 1 time
        aux.put(sum, 1);
        
        for(long i:arr){
            sum+=i;
            rem=sum%k;
            
            if(rem<0)
            //doing this to tackle negative rem
                rem+=k;
            if(aux.containsKey(rem))
		//here we are adding freq of remainders to res because that would mean that at that given rem the subarray was div by k
                res+=aux.get(rem);
            aux.put(rem, aux.getOrDefault(rem, 0)+1);
        }
        
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
    //        int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.subCount(a,n,k);
            System.out.println(ans);
        }
    }
}






// } Driver Code Ends
