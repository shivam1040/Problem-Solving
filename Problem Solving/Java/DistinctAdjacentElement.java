/*
Given an array arr[] of size N, the task is to check whether it is possible to obtain an array having distinct neighboring elements by swapping two neighboring array elements.

Example 1:

Input: N = 3, arr[] = {1, 1, 2}
Output:  YES
Explanation: Swap 1 (second last element) 
and 2 (last element), to obtain 1 2 1,
which has distinct neighbouring elements.

Example 2:

Input: N = 4, arr[] = {7, 7, 7, 7}
Output: NO
Explanation: We can't swap to obtain 
distinct elements in neighbor .

Your Task:
You don't need to read input or print anything. You just need to complete the function distinctAdjacentElement() that takes array arr[]  and its size N as input parameters and returns a boolean value denoting if distinct neighbours are possible or not. 
Note: The generated output is YES or NO according to the returned value.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
2 ≤ N ≤ 106
*/

/*
To obtain an array having distinct neighbouring elements is possible only, when the frequency of most occurring element is less than or equal to half of size of array i.e ( <= (n+1)/2 ). 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    if(ob.distinctAdjacentElement(arr,n))
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean distinctAdjacentElement(int arr[] , int n)
    {
        //code here.
        Map<Integer, Integer> aux=new HashMap<>();
        int temp=Integer.MIN_VALUE;
        
        for(int i:arr)
            aux.put(i, aux.getOrDefault(i ,0)+1);
        
        for(int i:aux.values())
            if(i>temp)
                temp=i;
        return temp<=(n+1)/2;
    }
}
