/*
Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes.  

Example 1:

Input:
N = 10

Output:
2 3 5 7

Explanation:
Prime numbers less than equal to N 
are 2 3 5 and 7.
Example 2:

Input:
N = 35

Output:
2 3 5 7 11 13 17 19 23 29 31

Explanation:
Prime numbers less than equal to 35 are
2 3 5 7 11 13 17 19 23 29 and 31.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function sieveOfEratosthenes() which takes an integer N as an input parameter and return the list of prime numbers less than equal to N.

Expected Time Complexity: O(NloglogN)
Expected Auxiliary Space: O(N)

Constraints:
1<= N <= 104
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
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        int arr[]=new int[N+1];
        ArrayList<Integer> res=new ArrayList<Integer>();
        
        //in sieve of erosthenes we basically mark all the numbers until n which are divisible by each of the numbers until n
        for(int i=2; i<=N; i++){
            if(arr[i]==0){
                //starting from i*i is an optimization since all previous multiples of i at this point must have been marked already, and j+i means always checking next multiple of i not all the numbers
                for(int j=i*i; j<=N; j+=i)
                    arr[j]=1;
            }
        }
        for(int i=2; i<=N; i++)
            if(arr[i]==0)
                res.add(i);
        return res;
    }
}
