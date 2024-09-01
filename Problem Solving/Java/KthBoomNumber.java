/*
Boom numbers are numbers consisting only of digits 2 and 3. Given an integer K, display the K-th Boom number.

Example 1:

Input:
K = 5
Output: 32
Explanation:
The Boom series is 2, 3, 22, 23, 32, 33, 222....
and, for K=5, answer = 32
 

Example 2:

Input:
K = 100
Output: 322323

Your Task:  
You don't need to read input or print anything. Your task is to complete the function BoomNumber() which takes an interger K as input parameter and returns the Kth boom number in the form of a string.

 

Expected Time Complexity: O( log(K) )
Expected Auxiliary Space: O( log(K) )


Constraints:
1 ≤ K ≤ 1012
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); 
        while (t-- > 0) {
            long K = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            System.out.println(obj.BoomNumber(K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String BoomNumber(long k) {
        // code here 
        long p=2;
        String res="";
        //gives position of kth in series starting from index 0;
        while(k>p){
            k-=p;
            p*=2;
        }
        p/=2;
        while(p>0){
            if(k<=p)
                res+="2";
            else{
                k-=p;
                res+="3";
            }
            p/=2;
        }
        return res;
    }
}


