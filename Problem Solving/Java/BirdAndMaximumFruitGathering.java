/*
There are N trees in a circle. Each tree has a fruit value associated with it. A bird has to sit on a tree for 0.5 sec to gather all the fruits present on the tree and then the bird can move to a neighboring tree. It takes the bird 0.5 seconds to move from one tree to another. Once all the fruits are picked from a particular tree, she cant pick any more fruits from that tree. The maximum number of fruits she can gather is infinite.

Given N and M (the total number of seconds the bird has), and an array arr[] containing the fruit values of the trees. Maximize the total fruit value that the bird can gather. The bird can start from any tree.

 

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

/*

The provided code seems to be an implementation of a sliding window approach to solve the problem. It maintains a window of size m (the total number of seconds the bird has) and slides it over the array arr to maximize the total fruit value that the bird can gather.

Here's a breakdown of the code:

Initialize ans and sum to 0.
Calculate the initial sum of the first m elements of arr and store it in sum.
Set ans to the initial sum.
Iterate over the array from index m to n + m - 1 (using modulo n for cyclic traversal).
Update ans by adding the current element and subtracting the element that is m positions behind the current element (again, using modulo n).
Update sum to be the maximum of sum and ans.
Return sum, which contains the maximum total fruit value that the bird can gather.
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
        int ans=0, sum=0;
        
        for(int i=0; i<m; i++)
            sum+=arr[i];
        ans=sum;
        //Iterate over the array from index m to n + m - 1 (using modulo n for cyclic traversal)
        for(int i=m; i<n+m; i++){
            ans+=arr[i%n]-arr[(i-m)%n];
            sum=Math.max(sum, ans);
        }
        return sum;
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
