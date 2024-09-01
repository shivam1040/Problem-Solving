/*
Given a number N, generate all the possible cyclic permutations of the number.

Example 1:

Input:
N = 123

Output:
123 312 231

Explanation:
For 123 there are 3 cyclic permutations possible.
Example 2:

Input:
N = 5674

Output:
5674 4567 7456 6745

Explanation:
For 5674 there are 4 cyclic permutations possible.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function cyclicPermutations() which takes an integer N as input parameter and returns the list of unique cyclic permutations of N.
Note: Cyclic permutation should not contain leading zeros

Expected Time Complexity: O(X)
Expected Auxiliary Space: O(X), Where X is the number of the digit of N.

Constraints: 
1 <= N <= 109


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
            ArrayList<Integer> ans  = ob.cyclicPermutations(N);
            for(int permutation : ans){
                System.out.print(permutation+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> cyclicPermutations(int N){
        // code here
       ArrayList<Integer> res = new ArrayList<>();
       int num = N, count = countdigit(N);
       
       while(true){
           res.add(num);
           
           int rem=num%10;
           int dev=num/10;
           num=(int)((Math.pow(10, count-1))*rem+dev);
           
           if(num==N)
            break;
       }
       return res;
    }
    
    static int countdigit(int n){
       int count = 0;
       while(n>0){
          
           count++;
           n = n/10;
       }
       return count;
   }
}

