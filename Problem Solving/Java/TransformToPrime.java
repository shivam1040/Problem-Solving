/*
Given an array of n integers. Find the minimum positive number to be inserted in array, so that sum of all elements of array becomes prime. If sum is already prime, then return 0.

 

Example 1:

Input:
N=5
arr[] = { 2, 4, 6, 8, 12 }
Output:  5
Explanation: 
The sum of the array is 32 ,we can add
5 to this to make it 37 which is a
prime number .

Example 2:

Input:
N=3
arr[] = { 1, 5, 7 }
Output:  0 
Explanation: 
The sum of the array is 13 
which is already prime. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minNumber() that takes array arr and integer N as input parameters and returns the minimum positive number to be inserted in the array so as to make it's sum a prime number.

 

Expected Time Complexity: O(N log(log N))
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    private boolean[] isPrime = new boolean[100005];
    
    {
        sieveOfEratostheneses();
    }
    
    long minNumber(long arr[], int n)
    {
        int sum = 0;
 
    // To find sum of array elements
    for (int i = 0; i < n; i++)
        sum += arr[i];
 
    if (!isPrime[sum])
        return 0;
        
    int num = findPrime(sum);
    
    return num - sum;
    }
    
    
    private void sieveOfEratostheneses()
{
    isPrime[1] = true;
    for (int i = 2; i * i < 100005; i++)
    {
        if (!isPrime[i])
        {
            for (int j = 2 * i; j < 100005; j += i)
                isPrime[j] = true;
        }
    }
}

private int findPrime(int n)
{
    int num = n + 1;
 
    // To return prime number
    // greater than n
    while (num > 0)
    {
        // check if num is prime
        if (!isPrime[num])
            return num;
 
        // increment num
        num = num + 1;
    }
    return 0;
}


}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
    //        int k = Integer.parseInt(br.readLine());
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < n; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            GFG ob = new GFG();
            long ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends
