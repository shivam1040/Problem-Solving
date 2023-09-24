/*
Count the given numbers on your fingers and find the correct finger on which the number ends.

The first number starts from the thumb, second on the index finger, third on the middle finger, fourth on the ring finger and fifth on the little finger.
Again six comes on the ring finger and so on.

Example 1:

Input:
N = 3
Output:
3
Explanation:
3 ends on the finger 3.
Example 2:

Input:
N = 6
Output:
4
Explanation:
6 ends on the finger 4.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function fingerCount() which takes an integer N as input parameter and returns the finger number on which this number ends.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^6
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
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.fingerCount(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int fingerCount(int N){
        // code here
        int r=N%8;
        
        if(r==2 || r==8)
            return 2;
        else if(r==3 || r==7)
            return 3;
        else if(r==4 || r==6)
            return 4;
        else if(r==5)
            return 5;
        else if(r==0)
            return 2;
        return 1;
    }
}
