/*
There are N trees in a circle. Each tree has a fruit value associated with it. A bird has to sit on a tree for 0.5 sec to gather all the fruits present on the tree and then the bird can move to a neighboring tree. It takes the bird 0.5 seconds to move from one tree to another. Once all the fruits are picked from a particular tree, she can’t pick any more fruits from that tree. The maximum number of fruits she can gather is infinite.

Given N and M (the total number of seconds the bird has), and the fruit values of the trees. Maximize the total fruit value that the bird can gather. The bird can start from any tree.

 

Example 1:

Input:
N=7 M=3
arr[] = { 2 ,1 ,3 ,5 ,0 ,1 ,4 }
Output: 9
Explanation: 
She can start from tree 1 and move
to tree2 and then to tree 3.
Hence, total number of gathered fruits
= 1 + 3 + 5 = 9.
 

Example 2:

Input:
N=6 M=2
arr[] = { 1, 6, 2, 5, 3, 4 }
Output: 8
Explanation: 
She can start from tree 1 and move 
to tree 2. In this case she will gather
6 + 2 = 8 fruits. She can also start 
from tree 3 and move to tree 4. In this
case, too, she will gather 5 + 3 = 8 
fruits.
 

Your Task:
You don't need to read input, or print anything. You just need to complete the function maxFruits() that takes array arr, integer N and integer M as parameters and returns the maximum number of fruits she can gather.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
2 ≤ N ≤ 106


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
    long maxFruits(long arr[] ,int n,int m)
    {
        long sum=0, res=0;
        int i=0;
        
        //calculating sum until window m, since time taken for moving form one ele to another is .5+.5
        for(; i<m; i++)
            sum+=arr[i];
        
        res=Math.max(sum, res);
        //if fruit value is equal to number of elements then just return it
        if(i==n)
            return res;
        
        //this code takes care of tree in a circle constraint, so basically with the intial window sum we traverse the array in a circular fashion and come back to the intial m indexed element. this way we find the maximum subarray sum in circular fashion 
        for(int j=0; j<n; j++){
            sum=(sum-arr[j])+arr[i];
            res=Math.max(sum, res);
            //this takes care of not overflowing the index out of array and maintain circularity
            i=(i+1)%n;
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
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int m =Integer.parseInt(a2[1]);
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.maxFruits(a,n,m);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends
