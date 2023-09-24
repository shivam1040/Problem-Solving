/*
Given two positive integers x and y, and an array arr[] of positive integers. We need to find the longest prefix index which contains an equal number of x and y. Print the maximum index of largest prefix if exist otherwise print -1.

 

Example 1:

Input:
N=11
X=7  Y=42
arr[] = [ 7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7 ]
Output: 9
Explanation: The longest prefix with same 
number of occurrences of 7 and 42 is:
7, 42, 5, 6, 42, 8, 7, 5, 3, 6 
Example 2:

Input:
N=3
X=1 Y=2 
arr[] = [ 1,2,2 ]
Output: 1

Your Task:
Since this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function findIndex() that takes array arr, integer X, integer Y, and integer N as parameters and return the desired result.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
2 ≤ N ≤ 105
X != Y


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
    long findIndex(long arr[] ,int X,int Y,int N)
    {
        
        // Your code goes here
        int x=0, y=0, res=-1;
        
        for(int i=0; i<N; i++){
            if(arr[i]==X)
                x++;
            else if(arr[i]==Y)
                y++;
            if(x==y && x!=0)
                res=i;
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
//            int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int x =Integer.parseInt(a2[1]);
            int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            GFG ob=new GFG();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.findIndex(a,x,y,n);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends
