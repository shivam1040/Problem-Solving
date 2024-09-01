/*
There is a game "Choose a number and win money", in which, a person playing a game has to select a number N and he/she will be awarded some money in Rupees accordingly. Some of the observations of selecting a number N and money awarded(M) are:-

N: 1   2   3   4   5   6   7   8   9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24 ..........

M: 3   2   1   6   5   4   3   2   1   12   11   10   9     8     7      6      5     4     3    2     1    24  23  22...............

i.e. if you selects a number N=1,she gets M=Rs 3,if N=2,M=Rs 2,if N=3 ,M=Rs 1 and so on..

 

Example 1:

Input:
N = 30
Output:
16
Explanation:
As per the distribution,
you earn Rs 16.
 

 

Example 2:

Input:
N = 1
Output:
3
Explanation:
As per the distribution,
you earn Rs 3.
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function totalMoney() which takes an integer N and returns total money.

 

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1<=N<=109
*/

//{ Driver Code Starts
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
            System.out.println(ob.totalMoney(N));
        }
    }
}

// } Driver Code Ends


class Solution{
    static Long totalMoney(Long N){
        // code here
        long m=3;
        
        while(m<N){
            N-=m;
            m*=2;
        }
        return m+1-N;
    }
}
