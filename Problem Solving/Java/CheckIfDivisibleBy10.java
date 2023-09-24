/*
Given a binary number in the form of string, the task is to check whether the decimal representation of the given binary number is divisible by 10 or not. The number could be very large and may not fit even in long long int.

Example 1:

Input:
bin = "1010"
Output:
1
Explanation:
The decimal representation of given 
string is 10 which is divisible by 10.
So, answer is 1.
Example 2:

Input:
bin = "10"
Output:
0
Explanation:
The decimal representation of bin is 
2, which is not divisible by 10, so 
answer is 0.

Your Task:
You don't need to read input or print anything.Your Task is to complete the function isDivisibleBy10() which takes a binary string bin as input parameter and returns 0 if the decimal representaion of bin is not divisible by 10.Otherwise it returns 1.


Expected Time Complexity:O(N)
Expected Auxillary Space:O(1)

Constraints:
1 <= |bin| <= 105
*/

/*
We can also solve this problem without converting the binary string to decimal by using the concept of modular arithmetic. The idea is to iterate through the binary string from right to left, and keep track of the remainder after dividing the current number by 10. If the final remainder is 0, then the binary string is divisible by 10. 
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.isDivisibleBy10(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDivisibleBy10(String bin) {
        // code here
        int rem=0;
        
        for(char ch:bin.toCharArray()){
            int temp=Character.getNumericValue(ch);
            //this step is to recreate the same number by shifting it to left and finding mod of every digit
            rem=(rem*2+temp)%10;
        }
        return rem==0?1:0;
    }
}
