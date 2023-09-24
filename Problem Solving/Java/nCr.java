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
            int n = sc.nextInt();
            int r = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.ncr(n, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long ncr(int n, int r){
        //complete the function here
        long res=1, mod=1000000007;
        
        for(int i=0; i<r; i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
}

