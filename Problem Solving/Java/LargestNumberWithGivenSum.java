/*
Geek lost the password of his super locker. He remembers the number of digits N as well as the sum S of all the digits of his password. He know that his password is the largest number of N digits that can be made with given sum S. As he is busy doing his homework, help him retrieving his password.

Example 1:

Input:
N = 5, S = 12
Output:
93000
Explanation:
Sum of elements is 12. Largest possible 
5 digit number is 93000 with sum 12.
Example 2:

Input:
N = 3, S = 29
Output:
-1
Explanation:
There is no such three digit number 
whose sum is 29.
Your Task : 
You don't need to read input or print anything. Your task is to complete the function largestNumber() which takes 2 integers N and S as input parameters and returns the password in the form of string, else return "-1" in the form of string.

Constraints:
1 ≤ N ≤ 104
0 ≤ S ≤ 9*104

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)
*/

/*
There is a Greedy approach to solve the problem. The idea is to one by one fill all digits from leftmost to rightmost (or from most significant digit to least significant). 
We compare the remaining sum with 9 if the remaining sum is more than 9, we put 9 at the current position, else we put the remaining sum. Since we fill digits from left to right, we put the highest digits on the left side, hence get the largest number
*/

// { Driver Code Starts
    import java.io.*;
    import java.lang.*;
    import java.util.*;
    
    class Driverclass
    {
        public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            //testcases
            int t = Integer.parseInt(br.readLine().trim());
            
            while(t-- >0)
            {
                String inputLine[] = br.readLine().trim().split(" ");
                
                //taking n and sum
                int n = Integer.parseInt(inputLine[0]);
                int sum = Integer.parseInt(inputLine[1]);
                
                //calling largestNumber() function
                System.out.println(new Solution().largestNumber(n, sum));
            }
        }
    }// } Driver Code Ends
    
    
    
    class Solution
    {
        //Function to return the largest possible number of n digits
        //with sum equal to given sum.
        static String largestNumber(int n, int sum)
        {
            if(sum==0)
                return "0";
            if(sum>9*n)
                return "-1";
                
            int res[]=new int[n];
            for(int i=0; i<n; i++){
                if(sum>=9){ //here we are storing largest digits(9) starting from left in res
                    res[i]=9;
                    sum-=9; //updating the sum since according to question sum should be equal to sum of digits
                }
                else{
                    res[i]=sum; //if there's any digit which is lowere than 9, can be stored in res and store zero for remaining indexes of array
                    sum=0;
                }
                //so for sum 12 of 5 digits, first loop will store 9, sume updates to 3, next loop stores 3, sum updates to zero and remaining gets zero stored
            }
            
            String temp="";
            for(int i=0; i<n; i++)
                temp+=res[i];
            return temp;
        }
    }
    
    
    