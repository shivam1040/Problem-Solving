/*
Given a permutation of first n natural numbers as an array and an integer k. Print the lexicographically largest permutation after at most k swaps.

Example 1:

Input:
n=5
k=3
arr[] = {4, 5, 2, 1, 3}
Output: 5 4 3 2 1
Explanation: Swap 1st and 2nd elements: 5 4 2 1 3 
             Swap 3rd and 5th elements: 5 4 3 1 2 
             Swap 4th and 5th elements: 5 4 3 2 1 
Example 2:

Input:
n=3
k=1
arr[] = {2, 1, 3}
Output: 3 1 2
Explanation: Swap 1st and 3re elements: 3 1 2 

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function KswapPermutation() that takes array arr, integer n and integer k as parameters and modifies the array arr and does not return anything.

 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).


Constraints:
2 ≤ n ≤ 106

1 ≤ k ≤ n
*/

/*
This is a greedy approach. The largest permutation is found when the largest elements are at the front of the array, i.e. the largest elements are sorted in decreasing order. There are at most k swaps so put the 1st, 2nd, 3rd, …, kth largest element at their respective position.

Note: If the number of swaps allowed is equal to the size of the array, then there is no need to iterate over the whole array. The answer will simply be the reverse sorted array.

Algorithm: 

Create a HashMap or an array of length n to store element-index pair or map element to its index.
Now run a loop k times.
In each iteration swap the ith element with the element n – i. where i is the index or count of the loop. Also swap their position, i.e. update the hashmap or array. So in this step the largest element in remaining element is swapped to the front.
Print the output array.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    void KswapPermutation(long arr[] ,int n, int k)
    {
        int[] aux=new int[n+1];
        
        for(int i=0; i<n; i++)
            aux[(int)arr[i]]=i;
        for(int i=0; i<n && k>0; i++){
            if(arr[i]!=n-i){
                int temp=aux[n-i];
                aux[(int)arr[i]]=temp;
                aux[n-i]=i;
                long temp1=arr[temp];
                arr[temp]=arr[i];
                arr[i]=temp1;
                k--;
            }
        }
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
            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                arr[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            ob.KswapPermutation(arr,n,k);
            for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}





// } Driver Code Ends
