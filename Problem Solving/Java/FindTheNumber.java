/*
A Lucky number is a number which has only the digits 4 and 7. There's a special function F(n) for a positive integer n that returns all good digits of number n from the left to the right. For example, the output for number 147 is number 47. There are two numbers :

An integer a 
A Lucky number b.
Find the minimum number c (c > a) such that F(c) = b.

 

Example 1:

Input:
a = 1, b = 7
Output:
7
Explanation:
The minimum number x greater than 1 such that
F(x) = 7, is 7 and so it is the answer. 
Example 2:

Input:
a = 5, b = 4
Output:
14
Explanation:
The minimum number x greater than 5 such that
F(x) = 4, is 14 and so it is the answer.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findTheNum() which takes 2 Integera a, and b as input and returns the minimum number x greater than a such that F(x) = b.

 

Expected Time Complexity: O(b)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= a,b <= 105
*/

/*
You can see that, in worst case, the answer will be equal to 177777. It can't be greater. So, only thing you need is to write some function F(x) which will return all good digits of x in order from left to right. After that you need to write such kind of code:

x = a + 1;
while (F(x) is not equal to b)
increase x;
and x will contain the answer.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.findTheNum(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTheNum(int a, int b) {
        // code here
        int x=a+1;
        
        while(f(x)!=b)
            x++;
        return x;
    }
    
    private static int f(int x){
        String temp="";
        
        for(char i:String.valueOf(x).toCharArray())
            if(i=='7' || i=='4')
                temp+=i;
        if(temp.equals(""))
            temp="-1";
        return Integer.parseInt(temp);
    }
};
