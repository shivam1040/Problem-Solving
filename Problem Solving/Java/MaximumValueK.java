/*
Given an array Arr of N positive integers. Find the maximum possible value of K such that the array has at-least K elements that are greater than or equal to K.

Example 1:

Input:
N = 6
Arr[] = {2, 3, 4, 5, 6, 7}
Output: 4
Explanation: 4 elements [4, 5, 6, 7] 
are greater than equal to 4.

Example 2:

Input:
N = 4
Arr[] = {1, 2, 3, 4}
Output: 2
Explanation: 3 elements [2, 3, 4] are 
greater than equal to 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaximumNum() which takes the array of integers arr and its size n as input parameters and returns an integer denoting the answer.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
2 <= N <= 105
0 <= Arr[i] <= 106
The array is unsorted and may contain duplicate values.
*/

/*
The idea is to construct auxiliary array of size n + 1, and use that array to find count of greater elements in input array. Let the auxiliary array be freq[]. We initialize all elements of this array as 0.
We process all input elements. 
If an element arr[i] is less than n, then we increment its frequency, i.e., we do freq[arr[i]]++. 
Else we increment freq[n].
After step 2 we have two things. 
Frequencies of elements for elements smaller than n stored in freq[0..n-1]. 
Count of elements greater than n stored in freq[n].
Finally, we process the freq[] array backwards to find the output by keeping sum of the values processed so far.
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

            long ans = new Solution().findMaximumNum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int findMaximumNum(int[] arr, int n) {
        // code here
        int freq[]=new int[n+1];
        
        for(int i:arr)
            if(i<n)
                freq[i]++;
            else
                freq[n]++;
        
        int sum=0;
        
        for(int i=n; i>=0; i--){
            sum+=freq[i];
            
            if(sum>=i)
                return i;
        }
        return 0;
    }
}

