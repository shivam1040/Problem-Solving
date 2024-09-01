/*
A x digit number n is called Keith number if it appears in a special sequence (defined below) generated using its digits. The special sequence has first x terms as digits of n and other terms are recursively evaluated as sum of previous x terms.The task is to find if a given number is Keith Number or not.

Example 1:

Input: n = 197
Output: 1 
Explanation: 197 has 3 digits, so n = 3 
The number is Keith because it appears 
in the special sequence that has first
three terms as 1, 9, 7 and remaining
terms evaluated using sum of previous 3
terms. 1, 9, 7, 17, 33, 57, 107, 197, ..... 

Example 2:
Input: n = 12
Output: 0
Explanation: The number is not Keith 
because it doesn't appear in the special 
sequence generated using its digits. 
1, 2, 3, 5, 8, 13, 21, ..... 

Your Task:  
You dont need to read input or print anything. Complete the function isKeith() which takes n as input parameter and returns 1 if a given number is Keith Number else returns 0.

Expected Time Complexity: O(n*k)
Expected Auxiliary Space: O(n)

Constraints:
1<= n <=104
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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isKeith(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int isKeith(int n){
        // code here
        Deque<Integer> aux = new ArrayDeque<>();
        int sum=0, temp=n;
        
        while(n>0){
            aux.addFirst(n%10);
            
            sum+=n%10;
            n/=10;
        }
        while(sum<=temp){
            if(sum==temp)
                return 1;
            aux.addLast(sum);
            
            sum+=sum;
            sum-=aux.removeFirst();
        }
        return 0;
    }
}
