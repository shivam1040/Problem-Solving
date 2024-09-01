/*
An employee's wallet can contain no more than M notes or coins. A boss pays his salary by the minimum notes possible. However the employee may have to leave out some money. Find how much money he has to lose if his original salary is N.
Note: The values of notes or coins available are 1000, 500, 100, 50, 20, 10, 5, 2 and 1.

Example 1:

Input:
N = 1712, M = 4
Output:
12
Explanation:
The boss will give him one 1000, one 500
and two 100 notes, one note of 10 and
one of 2. But because the employee can't
have more notes than 4, he can have a
maximum amount of 1700.
So, he will lose 12.
Example 2:

Input:
N = 1023, M = 2
Output:
3
Explanation:
The boss will give him one 1000, one 20
one 2 and one note of 1. But because the
employee can't have more notes than 2,
he can have a maximum amount of 1020.
So, he will lose 3.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getLoss() which takes 2 Integers N and M as input and returns the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N,M <= 105
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
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.getLoss(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getLoss(int N, int M) {
        // code here
        while(M>0){
            if(N>=1000)
                N-=1000;
            else if(N>=500)
                N-=500;
            else if(N>=100)
                N-=100;
            else if(N>=50)
                N-=50;
            else if(N>=20)
                N-=20;
            else if(N>=10)
                N-=10;
            else if(N>=5)
                N-=5;
            else if(N>=2)
                N-=2;
            else if(N>=1)
                N-=1;
            if(N==0)
                break;
            M--;
        }
        return N;
    }
};
