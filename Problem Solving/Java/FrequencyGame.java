/*
Given an array A of size N. The elements of the array consists of positive integers. You have to find the largest element with minimum frequency.

Input Format: First line of input contains number of testcases T. For each testcase there will be two lines. First line contains N, next line contains N elements separated by spaces.

Output Format: For each testcase, print the largest element with minimum frequency.

Example:

Input: 
5
2 2 5 50 1

Output:
50

Explanation :
Testcase 1: All elements are having frequency 1 except 2.
 50 is the maximum element with minimum frequency.
Note: use HashMap to compute the element and its frequency.

User Task:
Your task is to complete the provided function LargButMinFreq(A, n) which accepts array A and n. Hence you have to return the largest element with minimum frequency.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 106


*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Geeks obj = new Geeks();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Geeks {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        Map<Integer, Integer> aux=new HashMap<>();
        int minFreq=Integer.MAX_VALUE;
        int largestEle=Integer.MIN_VALUE;
        
        for(int i:arr){
            aux.put(i, aux.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> i : aux.entrySet()){
            if(i.getValue()<minFreq)
                minFreq=i.getValue();
        }
        for(Map.Entry<Integer, Integer> i : aux.entrySet()){
            if(i.getValue()==minFreq && i.getKey()>largestEle)
                largestEle=i.getKey();
        }
        //System.out.println(aux);
        return largestEle;
    }
}
