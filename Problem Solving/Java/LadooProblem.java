/*
Bheem has N friends. And he has a ladoo for each day. Given an Array A[] denoting on which day ith friend wants a ladoo. If Bheem is unable to give a ladoo to a friend, he loses his friendship with them. Find out the maximum number of Friends he can have at the end.

 

Example 1:

Input:
N = 5
A[] = {3, 3, 1, 2, 4}
Output:
4 
Explanation:
He will lose either his 1st or 2nd
friend and therefore will be left
with 4 friends.
Example 2:

Input:
N = 2
A[] = {1, 2}
Output:
2
Explanation:
He can give a ladoo to each of his friends,
and will have 2 friends by the end.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function divideLadoo() which takes an Integer N and an Array A as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= A[i] <= 105
*/

//{ Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.divideLadoo(N,A));
        }
    }
}
// } Driver Code Ends



class Solution {
    static int divideLadoo(int N , int[] A) {
        // code here
        Set<Integer> aux=new HashSet<>();
        
        for(int i:A)
            aux.add(i);
       
        return aux.size();
    }
};
