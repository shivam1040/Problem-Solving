/*
A Lucky number is the largest number made up of only digits 2,3 and 5 such that the count for each digit is divisible by the number obtained by multiplication of remaining two digits. You are provided with the number N and you have to output the lucky number of N digits. If no lucky number exists for the given N output -1.

Example 1:

Input:
N = 4
Output:
-1
Explanation:
There isn't any 4 digit Lucky Number.
Example 2:

Input:
N = 16
Output:
5555553333333333 
Explanation:
There are six '5' and ten '3' in the
number. And also, 2*3=6 and 2*5=10.
There is no 16 digit number greater
which satisfies the conditions.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getLuckyNum() which takes an Integer N as input and returns the answer as a String.

Expected Time Complexity: O(N3)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 103
*/

/*
First take the max of 5 you can print.

Second take the max of 3 and third max of 2.

Condition: (6*i+10*j+15*k)==n; where i is the count of number of 5, j is the count of number of 3 and k is the count of number of 2 in formed Lucky number.

Count of 5 will always will be multiple of 6.

Count of 3 will always will be multiple of 10.

Count of 2 will always will be multiple of 15.
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getLuckyNum(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String getLuckyNum(int N) {
        // code here
        for(int i=N/6; i>=0; i--){
            int n1=N-6*i;
            
            for(int j=n1/10; j>=0; j--){
                int n2=n1-10*j;
                
                for(int k=n2/15; k>=0; k--)
                    if(i*6+j*10+k*15==N){
                        StringBuilder res=new StringBuilder();
                        
                        for(int l=0; l<i*6; l++)
                            res.append(5);
                        for(int l=0; l<j*10; l++)
                            res.append(3);
                        for(int l=0; l<k*15; l++)
                            res.append(2);
                        return res.toString();
                    }
            }
        }
        return "-1";
    }
};
