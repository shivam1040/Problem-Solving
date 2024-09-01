/*
Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, after concatenating them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

Examples:

Input: n = 5, arr[] =  {"3", "30", "34", "5", "9"}
Output: "9534330"
Explanation: Given numbers are  {"3", "30", "34", "5", "9"}, the arrangement "9534330" gives the largest value.
Input: n = 4, arr[] =  {"54", "546", "548", "60"}
Output: "6054854654"
Explanation: Given numbers are {"54", "546", "548", "60"}, the arrangement "6054854654" gives the largest value.
Expected Time Complexity: O(n*log(n) ).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ n ≤ 105
0 ≤ arr[i] ≤ 1018
The sum of all the elements of the array is greater than 0.
*/

/*
Intuition:
The is to sort the vector using compare function, for sorting we are given two numbers X and Y, decide which number to put first – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). If XY is larger, then X should come before Y in output, else Y should come before. For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.

Implementation:
Copy-of-Copy-of-Copy-of-Copy-of-Copy-of-P-(5)-(1)
Sort the vector arr, based on the myCompare function.
In the myCompare comparator function, We will have the string X and Y.
Initialize a string XY equal to X.append(Y)(i.e. Y appended at the end of X).
and YX equal to Y.append(X)(i.e. X appended at the end of Y).
We return 1 if XY is greater than YX else we return 0.
Initialize a string ans.
Run a loop i from 0 to arr.size().
add arr[i] to the ans.
Return ans.
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
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        //descending order comparison
        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        return String.join("", arr);
    }
}
