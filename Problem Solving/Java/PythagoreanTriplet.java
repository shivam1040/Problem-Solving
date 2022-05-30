/*
Given an array arr of N integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2, otherwise false.

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
Complete the function checkTriplet() which takes an array arr, single integer n, as input parameters and returns boolean denoting answer to the problem. You don't to print answer or take inputs. 
Note: The driver will print "Yes" or "No" instead of boolean.

Expected Time Complexity: O(max(Arr[i])2)
Expected Auxiliary Space: O(max(Arr[i]))

Constraints:
1 <= N <= 107
1 <= Arr[i] <= 1000
*/

// { Driver Code Starts
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
}// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        Map<Double, Integer> aux=new HashMap<Double, Integer>();
        for(int i=0; i<arr.length; i++)
            aux.put((double)arr[i], aux.getOrDefault(arr[i], 0)+1);
        for(int i=0; i<arr.length; i++){
             int a=arr[i]*arr[i];
            for(int j=0; j<arr.length; j++){
                if(i!=j){
                    int b=arr[j]*arr[j];
                    double c=Math.sqrt(a+b);
                    double z=arr[i];
                    if(aux.containsKey(c)){
                        //System.out.println(c+" "+a+" "+b);
                        if(c==arr[j] && aux.get(arr[j])<1)
                            continue;
                        else if(c==arr[i] && aux.get(arr[i])<1)
                            continue;
                        else if(c==arr[i] & c==arr[j] && aux.get(arr[i])<3)
                            continue;
                        else
                            return true;
                    }
                }
        }
    }
    return false;
}
}