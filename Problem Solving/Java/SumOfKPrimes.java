/*
Given two numbers N and K. Find out if ‘N’ can be written as a sum of ‘K’ prime numbers.

Input:
N = 10 and K = 2
Output: 1
Explanation:
10 can be written as 5 + 5
 

Example 2:

Input:
N = 2 and K = 2
Output: 0

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isSumOfKprimes() which takes the integer N and an integer K as input parameters and returns the true if N can be expressed as a sum of K primes else return false.
If function returns true, driver code will print 1 in output and 0 if the function returns false.

Expected Time Complexity: O(SQRT(N))
Expected Auxiliary Space: O(1)

 

 

Constraints:
1 <= N,K <= 109
*/

/*
The idea is to use Goldbach’s conjecture which says that every even integer (greater than 2) can be expressed as sum of two primes.
If the N >= 2K and K = 1: the answer will be Yes if N is a prime number
If N >= 2K and K = 2: If N is an even number answer will be Yes(Goldbach’s conjecture) and if N is odd answer will be No if N-2 is not a prime number and Yes if N-2 is a prime number. This is because we know odd + odd = even and even + odd = odd. So when N is odd, and K = 2 one number must be 2 as it is the only even prime number so now the answer depends on whether N-2 is odd or not. 
If N >= 2K and K >= 3: Answer will always be Yes. When N is even N – 2*(K-2) is also even so N – 2*(K – 2) can be written as sum of two prime numbers (Goldbach’s conjecture) p, q and N can be written as 2, 2 …..K – 2 times, p, q. When N is odd N – 3 -2*(K – 3) is even so it can be written as sum of two prime numbers p, q and N can be written as 2, 2 …..K-3 times, 3, p, q 
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
        
        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            boolean ans = ob.isSumOfKprimes(N, K);
            if(ans)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    
    boolean isSumOfKprimes(int N, int K){
        // Code here
        if(N<2*K)
            return false;
        if(K==1)
            return isPrime(N);
        if(K==2){
            if(N%2==0)
                return true;
            isPrime(N-2);
        }
        return true;
    }
    
    private boolean isPrime(int x)
    {
        // check for numbers from 2 to sqrt(x)
        // if it is divisible return false
        for (int i=2; i*i<=x; i++)
            if (x%i == 0)
             
                return false;
        return true;
    }
    
}

