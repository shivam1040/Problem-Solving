/*
A n digit number has n*(n+1)/2 sub-numbers.  For example, all possible sub-numbers of 975 are 9 7 5 97 75 975. A number is called Lucky if all sub-numbers have different digit product.  Digit product of a number is product of its digits.  

For example, the number 23 is Lucky.  Sub-numbers of it are 2, 3 and 23 and digit products are 2, 3 and 6 respectively (All digit products are different). 975 is also lucky. Print 1 if given Number is Lucky else Print 0.

 

Example 1:

Input:
N = 324
Output:
1
Explanation:
All subsequences form different Digit
Products. So, Output is 1.
Example 2:

Input:
N = 323
Output:
0
Explanation:
Subsequences 32, and 23 form same
Digit Product, i.e, 6. So, Output is 0.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isLuckyOrNot() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O((Number of Digits)2)
Expected Auxiliary Space: O(Number of Digits)

 

Constraints:
1 <= N <= 1018
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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isLuckyOrNot(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static int isLuckyOrNot(Long N) {
        // code here
        Set<Long> aux=new HashSet<>();
        
        if(N<9)
            return 1;
        
        long x=0;
        
        while(N>0){
            //edge case, if 1 is there then product repeats
            if(N%10==1)
                return 0;
            //basically checking all digits different or not
            if(aux.contains(N%10))
                return 0;
            aux.add(N%10);
            x++;
            N/=10;
        }
        
        return 1;
    }
};
