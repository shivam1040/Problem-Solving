/*
Find the Nth term of the Mysterious series.
N    Nth term
1    5
2    10
3    26
4    50
5    122
.
.
.
10    842

Example 1:

Input: N = 1
Output: 5 
Explanation: First term of the series is 5.
Example 2:

Input: N = 2
Output: 10
Explanation: Second term of the series is 10. 


Your Task:  
You dont need to read input or print anything. Complete the function nthMysterious() which takes N as input parameter and returns the Nth term of the Mysterious series.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)

Constraints:
1<= N <=103


*/

//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthMysterious(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long nthMysterious(long N){
        // code here
        List<Long> aux=new ArrayList<>();
        long temp=0;
        
        for(int i=2; i<100_000; i++){
            if(prime(i)){
                //see the pattern in questipn it's 2nd prime * 2nd prime +1 for N=2
                aux.add((long)i*i+1);
            }
            if(temp==N)
                break;
        }
        
        return aux.get((int)N-1);
    }
    
    static boolean prime(int n)
    {  
        if(n==0 || n==1)
             return false;
         for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
