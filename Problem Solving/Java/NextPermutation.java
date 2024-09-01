/*
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10000
*/

/*
 Intuition
The algorithm follows the logic of finding the position to perform the next permutation, swapping elements appropriately, and then reversing the remaining portion to achieve the lexicographically next greater permutation. If no such greater permutation is possible, the array is already in the lexicographically smallest order, and the original array is returned.

Example
Arr= { 1, 2, 3, 6, 5, 4}

ind=0
Finding Position for Next Permutation
Iterate from the second last element to the first element.
Find that arr[2] (3) < arr[3] (6).
Set ind = 2 and break from the loop.
Finding Smallest Greater Element
Iterate from the last element to the ind-th element.
Find that arr[5] (4) is the smallest element greater than arr[2] (3).
Swap arr[5] with arr[2].
The array becomes {1, 2, 4, 6, 5, 3}.
Reverse the Elements
Reverse the elements from the ind + 1 position to the end of the array.
Reverse the elements from arr[3] to the end: {1, 2, 4, 3, 5, 6}.
Return {1, 2, 4, 3, 5, 6}.
Implementation
Copy Array and Initialize Variables:
Make a copy of the input array to avoid modifying the original array.
Initialize a variable (ind) to 0 to keep track of the position for the next permutation.
Finding Position for Next Permutation:
Iterate through the array from the second last element to the first element.
Check if the current element is smaller than the next element.
If true, set ind to the current index and break from the loop.
Finding Smallest Greater Element:
Iterate through the array from the last element to the ind-th element.
Find the smallest element greater than the element at ind.
Swap the found element with the element at ind.
Reverse the Elements:
Reverse the elements from the ind + 1 position to the end of the array.
This step ensures that the remaining portion of the array is in the lexicographically smallest order.
Return the Result:
Return the modified array as the next permutation.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int ind=0;
        int v[]=arr.clone();
        //finding index i such that a[i]<a[i+1]
        for(int i=N-2; i>=0; i--)
            if(v[i]<v[i+1]){
                ind = i;
                break;
            }
        //swap all smallese ele compared to ind to its right
        for(int i=N-1; i>ind; i--)
            if(v[i]>v[ind]){
                swap(i, ind, v);
                ind++;
                break;
            }
        //reverse
        for(int i=0; i<(N-ind)/2; i++)
            swap(i+ind, N-i-1, v);
            
        List<Integer> li = new ArrayList<>();
        for(int x : v) 
            li.add(x);
        return li;
    }
    
    private static void swap(int i, int j, int arr[]){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
