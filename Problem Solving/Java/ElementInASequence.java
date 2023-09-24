/*
Consider a sequence of numbers composed of only digits 4 and 7 such as 4, 7, 44, 47, 74,...... 44744,.. etc. Given a number N, we need to find the value of the N-th element in the sequence.

Example 1:

Input:
N = 3
Output:
44
Explanation:
Value of the first term = 4
Value of the second term = 7
Value of the third term = 44
Example 2:

Input:
N = 5
Output:
74
Explanation:
Value of the first term = 4
Value of the second term = 7
Value of the third term = 44
Value of the fourth term = 47
Value of the fifth term = 74
Your Task:  
You don't need to read input or print anything. Your task is to complete the function NthTermOfSeries() which takes an integer N as an input parameter and returns the value of the Nth term of the sequence.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 1000


*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            int ans  = ob.NthTermOfSeries(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int NthTermOfSeries(int N){
        // code here
        int ans=0, count=1;
        
        while(N>0){
            int temp=N%2==0 ? 7 : 4;
            ans=count*temp+ans;
            count*=10;
            //halving to reach to N faster
            if(N%2==0)
                N=(N-2)/2;
            else
                N/=2;
        }
        return ans;
        //another way is to add 4 and 7 to front a string in queueu which is "" initially and then repeat until N>0
    }
}
