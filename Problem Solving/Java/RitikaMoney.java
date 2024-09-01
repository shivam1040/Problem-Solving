/*
Ritika has a coin of  $N but she is the type of person who loves to have as much money as possible. A coin of $N can be exchanged in a bank into three coins of: $n/2, $n/3 and $n/4. But these numbers are all rounded down. Ritika decides to exchange her coin in the greed of money and makes profit. Your task is to find the maximum amout of money she can have at the end of exchange.
 

Example 1:

Input: N = 5
Output: 5
Explanation: 5 => 5/2 + 5/3 + 5/4 = 2 + 1 
+ 1 = 4 < 5 which means 5 can't be 
exchanged to earn profit so it itself is 
the maximum amount.
Example 2:

Input: N = 12
Output: 13
Explanation: 12 => 12/2 + 12/3 + 12/4 = 6 + 4
+ 3 = 13 (>12) after exchange.Now 6,4,3 can't 
be exchanged further to get profit.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function MaxExchangeMoney() which takes N as input parameter and returns maximum amount of money she can make by exchanging.
 

Expected Time Complexity:  O(log(N))
Expected Space Complexity: O(K) where K is constant.
 

Constraints:
1 <= N <= 1010
*/

/*
The intuition behind the solution is to recursively divide the coin into three parts: one part of size n/2, another of size n/3, and a third of size n/4. We continue this process for each of the three parts until the size of the part is less than 12, as there is no profit in further division for parts smaller than 12.

The base case of the recursion is when n is less than 12, in which case the value of the coin cannot be further divided and the maximum amount she can have is n.

At each step of the recursion, we compare the total value of the three parts (n/2 + n/3 + n/4) with the original value n and return the maximum of the two. This ensures that at each step, we are choosing the most profitable option between exchanging the coin and keeping it as is.
*/

//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            long N = Long.parseLong(br.readLine().trim());
            Solution ob = new Solution();
            Long ans = ob.MaxExchangeMoney(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution
{
    Map<Long, Long> aux=new HashMap<>();
    
    public long MaxExchangeMoney(long n)
    {
        // code here
         if (n < 12) {
            return n;
        }
        if(aux.containsKey(n))
            return aux.get(n);
        long temp=Math.max(n, MaxExchangeMoney(n / 2) + MaxExchangeMoney(n / 3) + MaxExchangeMoney(n / 4));
        aux.put(n, temp);
        return temp;
    }
}
