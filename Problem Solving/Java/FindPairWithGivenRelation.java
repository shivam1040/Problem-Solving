/*
Given an array of distinct integers, write a program to find if there exist two pairs (a, b) and (c, d) such that ab = cd, where a, b, c and d are distinct elements. If such pairs exists then print 1 else -1.

 

Example 1:

Input:
N=7
arr[] = {3, 4, 7, 1, 2, 9, 8} 
Output: 1
Explanation:
Product of 4 and 2 is 8 and also,
the product of 1 and 8 is 8.  
 

Example 2:

Input:
N=6
arr[] = {1, 6, 3, 9, 2, 10} 
Output: 1

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findPairs() that takes array arr and n  as parameters and return 1 if any such pair is found otherwise return -1. 

 

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

 

Constraints:
1 ≤ N ≤ 103
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
      long findPairs(long arr[],int n)
    {
        Map<Long, String> aux=new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                long temp=arr[i]*arr[j];
                
                if(!aux.containsKey(temp))
                    aux.put(temp, "");
                else
                    return 1;
            }
        }
        return -1;
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
            int n=Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.findPairs(a,n);
            System.out.println(ans);
        }
    }
}


//User function Template for Java



// } Driver Code Ends
