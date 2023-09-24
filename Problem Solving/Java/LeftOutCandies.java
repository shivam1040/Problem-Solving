/*
Given N students sitting in a circle, distribute M candies to these students. The ith student can take only i candies. If ith student does not get the required amount of candies he will not take it. Distribute the candies starting from the 1st student and moving along the circle of students till you reach a student you can not give candies to. You need to find the amount of candies left.


Example 1:

Input:
N = 4, M = 11
Output: 0
Explanation: You first give 1 candy to 1st student, 
2 to 2nd , 3 to 3rd , 4 to 4th then again 1 to first. 
All candies are finished with none left out.

Example 2:

Input:
N = 4, M = 12
Output: 1
Explanation: You are left with only one candy.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function leftCandies() which takes two integers n and m as input parameters and returns an integer denoting the amount of candies left.

 

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
 

Constraints:
1 ≤ N ≤ 109
1 ≤ M ≤ 1018
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
            long n = Long.parseLong(inputLine[0]);
            long m = Long.parseLong(inputLine[1]);

            long ans = new Solve().leftCandies(n, m);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solve {
    long leftCandies(long n, long m) {
        // code here
        long sumUntiln=(n*(n+1)/2);
        long rem=m%sumUntiln;
        
        for(long i=1; i<=n; i++){
            if(rem>=i)
                rem-=i;
            else
                return rem;
        }
        return 0;
    }
}
	
