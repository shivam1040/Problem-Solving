/*
You are given a number N, you have to represent this number as the sum of the minimum number of possible pseudo-binary numbers. A number is said to be a pseudo-binary number if its decimal number consists of only two digits (0 and 1).
Few examples of pseudo-binary numbers are 0, 1, 10, 11, 101, 110 etc 

Example:

Input:
N = 31

Output:
11 10 10

Explanation: 
31 can be represented as the sum of
minimum 3 pseudo-binary numbers as 11+10+10.
Example:

Input:
N = 12

Output:
11 1

Explanation: 
12 can be represented as sum of
minimum 2 psuedo-binary numbers as 11+1.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumPseudoBinary() which takes an integer N as an input parameter and return the list of the minimum number of pseudo-binary numbers in non-increasing order that sums up to N.

Expected Time Complexity: O(NLogN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 106
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
            ArrayList<Integer> nums  = ob.minimumPseudoBinary(N);
            for(int num : nums){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

 
//User function Template for Java
class Solution{
    static ArrayList<Integer> minimumPseudoBinary(int n){
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        
        while(n!=0){
            int temp=n, m=0, p=1;
            //getting 11 or 10 type number for every part of n remaining
            while(temp!=0){
                int rem=temp%10;
                temp/=10;
                
                if(rem!=0)
                    m+=p;
                p*=10;
            }
            res.add(m);
            n-=m;
        }
        return res;
    }
}
