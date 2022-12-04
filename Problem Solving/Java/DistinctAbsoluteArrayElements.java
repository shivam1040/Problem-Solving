/*
Given a sorted array of size N. Count the number of distinct absolute values present in the array.
 

Example 1:

Input:
N = 6
Arr[] = {-3, -2, 0, 3, 4, 5}
Output: 5
Explanation: There are 5 distinct absolute 
values i.e. 0, 2, 3, 4 and 5.

Example 2:

Input:
N = 9
Arr[] = {-1, -1, -1, -1, 0, 1, 1, 1, 1}
Output: 2
Explanation: There are 2 distinct absolute values 
among the elements of this array, i.e. 0 and 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function distinctCount() which takes the array of integers arr[] and its size n as input parameters and returns an integer denoting the answer.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 105
-108 <= Arr[i] <= 108
The array may contain duplicates
*/

/*
The idea is to take advantage of the fact that the array is already Sorted. We initialize the count of distinct elements to number of elements in the array. We start with two index variables from two corners of the array and check for pair in the input array with sum as 0. If pair with 0 sum is found or duplicates are encountered, we decrement the count of distinct elements.Finally we return the updated count.
*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int i=0, j=n-1, sum=0;
        
        while(i<j){
            //find all duplicates, update n
            while(i!=j && arr[i]==arr[i+1]){
                n--;
                i++;
            }
            while(i!=j && arr[j]==arr[j-1]){
                n--;
                j--;
            }
            if(i==j)
                break;
            //find if there exists numbers whose sum is zero
            sum=arr[i]+arr[j];
            
            if(sum==0){
                n--;
                i++;
                j--;
            }
            //if sum is less than zero then move forward to find similar number as the array is sorted
            else if(sum<0){
                i++;
            }
            //if more than move backwards from end
            else
                j--;
        }
        return n;
    }
}

