/*
You are given an array arr[] of size N.
The array consists of a permutation of the set {1, 2, 3, … , N} for some positive integer N. You have to start at the position which has 1 in the array and then travel to the position which has 2. Then from 2, you travel to 3 and so on till you reach the position which has N.
When you travel from Arr[i] to Arr[j], the distance travelled is | i– j |.
Find the total distance you have to travel to reach N when you start from 1.


Example 1:

Input:
N = 5
Arr[] = {5, 1, 4, 3, 2}
Output: 7
Explanation: The numbers and their respective 
indices are given below:
1->1
2->4
3->3
4->2
5->0
Total distance =|4-1|+|3-4|+|2-3|+|0-2| 
= 3+1+1+2 = 7.

Example 2:

Input:
N = 6
Arr[] = {6, 5, 1, 2, 4, 3}
Output: 8
Explanation: 
Total distance = |2-3|+|3-5|+|5-4|+|4-1|+|1-0| 
= 1+2+1+3+1 = 8.

Your Task:
You don't need to read input or print anything. Your task is to complete the function distance() which takes the array of integers arr[] and its size n as input parameters and returns the total distance.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= N <= 107
1<= Arri <= N


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

            long ans = new Solution().distance(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long distance(int[] arr, int n) {
        // code here
        Map<Integer, Integer> aux=new TreeMap<>();
        long res=0;
        
        for(int i=0; i<n; i++)
            aux.put(arr[i], i);
            
        Iterator<Map.Entry<Integer, Integer>> itr = aux.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = itr.next();
        int a=entry.getValue();
        
        while(itr.hasNext())
        {
             entry = itr.next();
             int b=entry.getValue();
             res+=Math.abs(b-a);
             a=b;
        }
        return res;
    }
}

