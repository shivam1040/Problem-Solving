/*
Given two positive numbers L and R (L < R), find out the smallest twins in the range [L , R].Two numbers are twins if they are prime numbers and difference between them is 2.

Example 1:

Input: L = 0, R = 5
Output: [3, 5]
Explanation: Difference between 3 and 5 is 2
and also these two are smallest prime in range.
So the answer is 3, 5. 

Example 2:

Input: L = 5, R = 10
Output: [5, 7]
Explanation: Difference between 5 and 7 is 2
and also these two are smallest prime in range.
So the answer is 5, 7. 

Your Task:  
You dont need to read input or print anything. Complete the function primeTwins() which takes L and R as input parameter and returns a pair if exist else returns -1.

Expected Time Complexity: O(nloglogn)
Expected Auxiliary Space: O(n)

Constraints:
0<= L <=500
2<= R <=1000
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
            int L = Integer.parseInt(input[0]); 
            int R = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            int[] ans = ob.primeTwins(L,R);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] primeTwins(int L, int R)
    {
        // code here
        int res[]=new int[2];
        
        for(int i=L; i<=R; i++)
            if(isPrime(i)){
                if(isPrime(i+2)){
                    res[0]=i;
                    res[1]=i+2;
                    break;
                }
            }
        if(res[0]==0){
            res=new int[1];
            res[0]=-1;
        }
        return res;
    }
    
    private boolean isPrime(int n) 
    { 
        // Corner case 
        if (n <= 1) 
            return false; 
  
        // Check from 2 to sqrt(n) 
        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0) 
                return false; 
  
        return true; 
    } 
} 
