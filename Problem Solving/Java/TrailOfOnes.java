/*
Given a number N, find the number of binary strings of length N that contains consecutive 1's in them.

 

Example 1:

Input:
N = 2
Output:
1
Explanation:
There are 4 strings of 
length 2, the strings 
are 00, 01, 10, and 
11. Only the string 11 
has consecutive 1's.
 

 

Example 2:

Input:
N = 5
Output:
19
Explanation:
There are 19 strings
having consecutive 1's.
 


 

Your Task:

You don't need to read input or print anything. Your task is to complete the function numberOfConsecutiveOnes() which takes an integer N and returns the number of binary strings that contain consecutive 1's in them.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 

 

Constraints
2 <= N <=30
*/

/*
Compute the number of binary strings without consecutive 1's using the approach discussed here. Let this count be c.
Count of all possible binary strings of length n is 2^n.
Total binary strings with consecutive 1 is 2^n - c.`
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
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
i
            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int numberOfConsecutiveOnes(int N){
        // code here
       // https://www.youtube.com/watch?v=Bq9lgqC1YwE
        if(N<1)
            return 0;
        
        int c0=1, c1=1;
        
        for(int i=1; i<N; i++){
            int temp=c1;
            c1=c0;
            c0+=temp;
        }
        
        return (1<<N)-(c0+c1);
    }
}

