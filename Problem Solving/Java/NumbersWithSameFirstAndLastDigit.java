/*
Given a range of numbers starting with integer L and ending at R, the task is to count the numbers which have same first and last digits.

 

Example 1:

Input:
L = 7 
R = 68
Output:
9
Explanation:
Number with the same 
first and last digits 
in the given range is:
[7, 8, 9, 11, 22, 33, 
44 ,55, 66].

 

Example 2:

Input:
L = 5
R = 40
Output:
8
Explanation:
Number with the same
first and last digits
in the given range is:
[5, 6, 7, 8, 9, 11, 
22, 33, 44].


 

Your Task:

You don't need to read input or print anything. Your task is to complete the function numbersInRange() which takes integers L and R and returns the count of numbers if L>R return 0.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= L,R <= 108
*/

/*
Using above property we can solve given problem, first we break the given interval into two parts that is if interval is l to r, we break this into 1 to l and 1 to r, our answer is obtained by subtracting result of first query from second query. 
Now we remain to find the count of numbers with given property in range 1 to x, for this, we divide x by 10, which gives the number of 10-spans. We add 9 to the span for taking one-digit numbers into account. If the last digit of x is smaller than the first digit of x, then 1 should be decreased in the final answer to discard the last ten span number because that number is out of range
*/
k
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
            String[] inp=read.readLine().split(" ");
            int L=Integer.parseInt(inp[0]);
            int R=Integer.parseInt(inp[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numbersInRange(L,R));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int numbersInRange(int L, int R){
        // code here
        int res=solve(R)-solve(L-1);
        return res>=0 ? res : 0;
    }
    
    static int solve(int x){
        if(x<10)
            return x;
            
        int tens=x/10;
        
        int res=tens+9;
        
        int firstD=getFirst(x);
        int lastD=x%10;
        
        if(lastD<firstD)
            res--;
        
        return res;
    }
    
    static int getFirst(int x){
        while(x>=10)
            x/=10;
        return x;
    }
}
