/*
There are three piles of pens. A pens in the first pile and B pens in the second Pile.Find the minimum number of pens that should be there in the third pile so that sum of all three piles produces either a prime number or unity. 
Note: there should be atleast one pen in the third pile.

Example 1:

Input: A = 1, B = 3
Output: 1
Explanation: A + B + K = prime
K = 1, 1 + 3 + 1 = 5.So answer = 1
becuase 5 is minimum possible prime. 

Example 2:

Input: A = 4, B = 3
Output: 4
Explanation: A + B + K = prime
K = 4, 4 + 3 + 4 = 11.So answer = 4
becuase 11 is minimum possible prime.

Your Task:  
You dont need to read input or print anything. Complete the function minThirdPiles() which takes A and B as input parameter and returns the the minimum number of pens that should be there in the third pile so that sum of all three piles produces a prime number.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(1)

Constraints:
1 <= A <=1000
1 <= B <=1000
*/

//{ Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int A = Integer.parseInt(input[0]); 
            int B = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.minThirdPiles(A,B));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int minThirdPiles(int A, int B)
    {
        // code here
        int sum=A+B;
        
        while(true){
            if(isPrime(++sum))
                return sum - (A+B);
        }
    }
    
    private static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
 
        if (n == 2 || n == 3)
            return true;
 
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
}
