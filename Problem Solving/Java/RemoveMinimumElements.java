/*
Given an unsorted array Arr of size N. Find the minimum number of removals required such that twice of minimum element in the array is greater than or equal to the maximum in the array.

Example 1:

Input:
N = 9
Arr[] = {4,5,100,9,10,11,12,15,200}
Output: 4
Explanation: In the given array 4 elements 
4, 5, 200 and 100 are removed from the
array to make the array such that
2*minimum >= max (2*9 > 15).
Example 2:

Input:
N = 4
Arr[] = {4,7,5,6}
Output: 0
Explanation: We don't need to remove any
element as  4*2 > 7 (Note that min = 4,
max = 7).
Your Task:
You don't need to read input or print anything. Your task is to complete the function minRemoval() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 107
1 ≤ Arri ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().minRemoval(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int minRemoval(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int sub=0;
        
    for(int i=0; i<n; i++){  
        int low=i;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            //finding index of element which satisfies condition
            if(2*arr[i]>=arr[mid]){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            }
        if(ans!=-1)
            sub=Math.max(sub, ans-i+1);
        }
        return n-sub;
    }
    }
