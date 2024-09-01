/*
Geek has N dollars in his bank account. He wants to withdraw all of it but the bank only allows withdrawal of an amount that is a divisor of the current amount in the bank and is less than the current amount.
If Geek withdraws the maximum possible amount each day, how many days does he need to take out all of his money from the bank? 
Note: If the remaining amount is 1, he can withdraw it.

 

Example 1:

Input: N = 12
Output: 5
Explanation: N = 12
Withdraws 6, Remaining = 6
Withdraws 3, Remaining = 3
Withdraws 1, Remaining = 2
Withdraws 1, Remaining = 1
Withdraws 1, Remaining = 0
 

Example 2:

Input: N = 21
Output: 7
Explanation: N = 21
Withdraws 7, Remaining = 14
Withdraws 7, Remaining = 7
Withdraws 1, Remaining = 6
Withdraws 3, Remaining = 3
Withdraws 1, Remaining = 2
Withdraws 1, Remaining = 1
Withdraws 1, Remaining = 0
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function numberOfDays() which takes an integer N as input parameter and returns the number of days Geek needs to withdraw all of his money. 

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints : 
1 <= N <= 1012
*/

/*
Since N takes large values brute force won't work.
In each case, we need to find the largest divisor of N (excluding N) and subtract it from N until N == 0.
To find this, we iterate through 2 to sqrt(N) and check if the number(i) is divisible by N, if so, N/i is the largest divisor of N.
Repeat until N==1 and then withdraw 1.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            Long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.numberOfDays(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfDays(Long N){
        // code here
        int res=0;

        while(N>1){
            long temp=0;
            
            for(long i=2; i<=Math.sqrt(N); i++)
                if(N%i==0){
                    temp=1;
                    N-=(N/i);
                    
                    res++;
                    break;
                }
            if(temp==0){
                N--;
                res++;
            }
        }
        //this account for last 1 remaining which can be taken out just like that
        return res+1;
    }
}

