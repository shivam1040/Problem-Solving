/*
You are given a number. Your task is to check if there exists a permutation of the digits of this number which is divisible by 4.  

 

Example 1:

Input: 003 

Output: 1

Explanation: For 003, we have a permutation
300  which is  divisible by 4.
Example 2:

Input:
123456
Output:
1
Explanation:
For 123456, we have 123564 which is a
permutation of 123456 and is divisible by 4.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function divisible_by_four() which takes string as input parameter and returns 1 if any permutaion of string is divisible by 4 otherwise returns 0.

 

Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(1)

 

Constraints:

1<=|S|<=200
*/

/*
Consider a number 928160
Its rotations are 928160, 092816, 609281, 160928, 
    816092, 281609.
Now form pairs from the original number 928160
as mentioned in the approach.
Pairs: (9,2), (2,8), (8,1), (1,6), 
         (6,0), (0,9)
We can observe that the 2-digit number formed by the these 
pairs, i.e., 92, 28, 81, 16, 60, 09, are present in the last
2 digits of some rotation.
Thus, checking divisibility of these pairs gives the required
number of rotations. 

Note: A single digit number can directly
be checked for divisibility.
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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.divisible_by_four(s);
            System.out.println(ans);            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    public int divisible_by_four(String s)
    {
        // Code here
                int n = s.length();
        // If the number has only one digit.
        if (n == 1) {
            // Checking if the digit is divisible by 4.
            int num = Character.getNumericValue(s.charAt(0));
            if (num % 4 == 0)
                return 1;
            else
                return 0;
        }
        //the basic idea is to find a perm of 2 digits which is divisible by 4
        // Iterating over all possible pairs of digits in the number.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Checking if the two numbers are divisible by 4.
                // int num1 = Integer.parseInt(s.substring(i, i + 1) + s.substring(j, j + 1));
                // int num2 = Integer.parseInt(s.substring(j, j + 1) + s.substring(i, i + 1));
                	int  num1 = (s.charAt(i)-'0')*10 + (s.charAt(j)-'0');
					int  num2 = (s.charAt(j)-'0')*10 + (s.charAt(i)-'0');

                if (num1 % 4 == 0 || num2 % 4 == 0)
                    return 1;
            }
        }
        return 0;
    }
}
