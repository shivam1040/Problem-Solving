/*
Given an array arr of n integers, write a function that returns true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.

Example 1:

Input:
N = 5
Arr[] = {3, 2, 4, 6, 5}
Output: Yes
Explanation: a=3, b=4, and c=5 forms a
pythagorean triplet.
Example 2:

Input:
N = 3
Arr[] = {3, 8, 5}
Output: No
Explanation: No such triplet possible.
Your Task:
You don't have to take any input or print any thing. You have to complete the function checkTriplet() which takes an array arr, a single integer n, as input parameters and returns boolean denoting answer to the problem.
Note: The driver will print "Yes" or "No" instead of corresponding to the boolean value returned.

Expected Time Complexity: O(n+max(Arr[i])2)
Expected Auxiliary Space: O(max(Arr[i]))

Constraints:
1 <= n <= 105
1 <= arr[i] <= 1000
*/

/*
Intuition:
The approach involves iterating through all possible triplets (a, b, c) and checking if they form a Pythagorean triplet. To optimize the process, a hash table is used to count the occurrences of each element in the array. The iteration considers all possible values of a and b, calculates c using the Pythagorean theorem, and checks if c is present in the array.

Implementation:
1-(1).png1-(1).png
Initialize a variable maximum equal to 0.
Find the maximum element in the array and store it in the maximum variable.
Create a hash array of size maximum+1 to count the occurrences of each array element.
Iterate through the array and store the count of occurence of every element in the hash array.
Run a loop i from 1 to maximum+1.
If i is not present in the hash then continue.
Run a loop j from 1 to maximum+1,
If i and j are the same and there is only one occurrence of i, or if j is not present in the array, skip to the next iteration.
Initialze a variable val and calculate its value sqrt(i * i + j * j).
If val^2 is not a perfect square, skip to the next iteration.
If val exceeds the maximum value, skip to the next iteration.
If val is present in the array, return true (Pythagorean triplet found).
If no triplet is found, return false.

*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        int max=-1;
        
        for(int i:arr)
            max=Math.max(max, i);
        int temp[]=new int[max+1];
        
        for(int i:arr)
            temp[i]++;
        for(int i=01; i<=max; i++)
            for(int j=i+1; j<=max; j++)
                if(temp[i]>0 && temp[j]>0){
                    int c=i*i+j*j;
                    int d=(int)Math.sqrt(c);
                    
                    if(d*d==c && d<=max && temp[d]>0)
                        return true;
                }
        return false;
    }
}
