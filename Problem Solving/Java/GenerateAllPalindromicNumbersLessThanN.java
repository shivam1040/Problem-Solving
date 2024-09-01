/*
Count the number of palindromic numbers less than N.

Example 1:

Input:
N = 12
Output:
10
Explanation:
There are 10 palindrome number less than 12.
1 2 3 4 5 6 7 8 9 11
Example 2:

Input:
N = 104
Output:
19
Explanation:
There are 19 palindrome number less than 104.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function palindromicNumbers() which takes an integer N as input parameter and returns the count of the number of the palindromic numbers which are less than N.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105


*/

//{ Driver Code Starts
//Initial Template for Java//Initial Template for Java
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
            int ans  = ob.palindromicNumbers(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int palindromicNumbers(int N){
        // code here
        int res=0, temp1;
        
        //finding all odd and even length palin
        for(int i=0; i<2; i++){
            //start creating palin from 1
            int temp=1;
            while((temp1=gen(temp, i%2!=0 ? true : false))<N){
                temp++;
                res++;
            }
        }
        return res;
    }
    
    private static int gen(int input, boolean isOdd){
        int palin=input;
//        // if odd then neglect the last digit of input in
        // finding reverse as in case of odd number of
        // digits middle element occur once
        //10, remove 0, so that on appending revers to 10 we get 101        
        if(isOdd)
            input/=10;
            //append the reverse of number to itself to create palin
        while(input>0){
            palin=palin*10+(input%10);
            input/=10;
        }
        return palin;
    }
}
