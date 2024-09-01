/*
 Given an integer N, find its factorial. return a list of integers denoting the digits that make up the factorial of N.

Example 1:

Input: N = 5
Output: [1,2,0]
Explanation : 5! = 1*2*3*4*5 = 120
Example 2:

Input: N = 10
Output: [3,6,2,8,8,0,0]
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

Your Task:
You don't need to read input or print anything. Complete the function factorial() that takes integer N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.


Expected Time Complexity : O(N2)
Expected Auxilliary Space : O(1)


Constraints:
1 ≤ N ≤ 1000
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N) {
        // code here
        ArrayList<Integer> number=new ArrayList<>();
        
        number.add(1);
        for(int i=2; i<=N; i++)
            multiply(i, number);
        Collections.reverse(number);
        return number;
    }
    //basic idea is to store digits in array
    private static void multiply(int n, ArrayList<Integer> number){
        int carry=0;
        
        for(int i=0; i<number.size(); i++){
            int num=n*number.get(i);
            number.set(i, (num+carry)%10);
            carry=(num+carry)/10;
        }
        while(carry>0){
            number.add(carry%10);
            carry/=10;
        }
    }
}

//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val);
            System.out.println();
        }
    }
}
// } Driver Code Ends
