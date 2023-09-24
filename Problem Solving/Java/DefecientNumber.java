/*
â€‹Given a number x, your task is to find if this number is Deficient number or not. A number x is said to be Deficient Number if sum of all the divisors of the number denoted by divisorsSum(x) is less than twice the value of the number x. And the difference between these two values is called the deficiency.

Mathematically, if below condition holds the number is said to be Deficient:
divisorsSum(x) < 2*x
deficiency = (2*x) - divisorsSum(x)

Example 1:

Input: x = 21
Output: YES 
Explanation: Divisors are 1, 3, 7 and
21.Sum of divisors is 32. 
This sum is less than 2*21 or 42.
Example 2:

Input: x = 12
Output: NO
Explanation: Divisors are 1, 2, 3, 4,
6 and 12.Sum of divisors is 28.
This sum is not less than 2*12 or 24.

Your Task:  
You dont need to read input or print anything. Complete the function isDeficient() which takes x as input parameter and returns YES if the number is Deficient otherwise returns NO.

Expected Time Complexity: O(sqrt(n))
Expected Auxiliary Space: O(1)

Constraints:
1<= x <=10000000
*/

/*
If we observe carefully, the divisors of the number n are present in pairs. For example if n = 100, then all the pairs of divisors are: (1, 100), (2, 50), (4, 25), (5, 20), (10, 10)
Using this fact we can speed up our program. 
While checking divisors we will have to be careful if there are two equal divisors as in case of (10, 10). In such case we will take only one of them in calculation of sum.
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long x = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isDeficient(x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isDeficient(long x){
        // code here
        int sum=0;
        
        for(long i=1; i<=Math.sqrt(x); i++){
            if(x%i==0){
                if(x/i==i){
                    sum+=i;
                }
                else{
                    sum+=i;
                    sum+=(x/i);
                }
            }
        }
        
        if(sum<2*x)
            return "YES";
        return "NO";
    }
}
