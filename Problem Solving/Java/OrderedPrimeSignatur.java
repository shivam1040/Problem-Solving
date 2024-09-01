/*
Given a number n, find the ordered prime signatures and find the number of divisor of n.Any positive integer, ‘n’ can be expressed in the form of its prime factors. If ‘n’ has p1, p2,  etc. as its prime factors, then n can be expressed as :
n = {p_1}^{e1} * {p_2}^{e2} * ...
Arrange the obtained exponents of the prime factors of ‘n’ in non-decreasing order. The arrangement thus obtained is called the ordered prime signature of the positive integer ‘n’.

Example 1:

Input: n = 20
Output: 1 2
        6
Explaination: 20 can be written as 22 * 5. The 
ordered pair is 2 1 and the factors are 1, 2, 4, 
5, 10, 20.
Example 2:

Input: n = 13
Output: 1
        2
Explaination: 13 itself is a prime number 
and it has two factors 1 and 13.
Your Task:
You do not need to read input or print anything. Your task is to complete the function orderedPrime() which takes n as input parameter and returns a list containing the powers in non-decreasing manner and the number of factors at the end of the list. The driver code will itself print the number of factors (last element of the returned list) in a new line.

Expected Time Complexity: O(nsqrt(n))
Expected Auxiliary Space: O(n)

Constraints:
2 ≤ n ≤ 106  
*/

/*
Initialization:

List<Integer> res = new ArrayList<>();: Initialize an empty list res to store the exponents of prime factors.
int temp = 1;: Initialize a variable temp to calculate the number of divisors. This variable is set to 1 initially.
Prime Factorization:

The code iterates through numbers from 2 to n, where i represents a potential prime factor.
It checks if i is a factor of n (i.e., n is divisible by i).
It further checks if i is a prime number using the isprime function.
Counting Exponents:

If i is both a factor of n and a prime number, it means that i is a prime factor of n.
The code counts the number of times i divides n and appends that count to the res list. These counts represent the exponents of prime factors.
Ordered Prime Signature:

After iterating through all the potential prime factors, the code sorts the res list. Sorting the exponents ensures that the ordered prime signature is arranged in non-decreasing order.
Calculating the Number of Divisors:

The number of divisors of n can be calculated by multiplying all the exponents in the ordered prime signature.
Each exponent is incremented by 1 to account for the divisor count of 1 (i.e., the number itself).
The code stores this divisor count in the temp variable.
Returning the Results:

The res list contains the ordered prime signature (exponents) and the temp variable contains the number of divisors.
The ordered prime signature is returned as a list, where the last element is the number of divisors.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.orderedPrime(n);
            for(int i = 0;i < ans.size()-1;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println(); 
            System.out.println(ans.get(ans.size()-1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> orderedPrime(int n){
        // code here
        List<Integer> res=new ArrayList<>();
        int temp=1;
        
        for(int i=2; i<=n; i++){
            if(n%i==0 && isprime(i)){
                int count=0;
                //finding prime factor and storing the count of their repeatition in res
                while(n>0 && n%i==0){
                    count++;
                    n/=i;
                }
                res.add(count);
            }
        }
        Collections.sort(res);
        for(int i:res)
            temp*=i+1;
        res.add(temp);
        return res;
    }
    
    private static boolean isprime(int n)
    {
        if(n==0 || n==1)
        return false;
        
        for(int i=2;i<n;i++)
        if(n%i==0) return false;
        
        return true ;
    }
}
