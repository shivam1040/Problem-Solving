/*
A beautiful sequence is a strictly increasing sequence, in which the term Ai divides all Aj, where j>i. Given N find a beautiful sequence whose last term is N and the length of the sequence is the maximum possible. If there are multiple solutions return any.
 

Example 1:

Input: N = 10
Output: 1 5 10
Explanation: 10 is divisible by
1 and 5, 5 is divisible by 1.
Example 2:

Input: N = 3
Output: 1 3
Explanation: 3 is divisible by 1.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function FindSequenece() which takes N as an input parameter and returns a list of beautiful sequences. The driver will print two space-separated integers the length of the sequence and an integer x where x = 1 if your sequence is beautiful otherwise x = 0.
 

Expected Time Complexity: O(sqrt(N))
Expected Space Complexity: O(sqrt(N))
 

Constraints:
1 < N < 109
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.FindSequenece(N);
            int x = 1;
            for (int i = 1; i < ans.length; i++)
                if (ans[i] <= ans[i - 1] || ans[i - 1] == 0 || ans[i] % ans[i - 1] != 0) {
                    x = 0;
                    break;
                }
            if(ans[ans.length - 1] != N)
                x = 0;
            
            System.out.println(ans.length + " " + x);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindSequenece(int N) {
        // code here
        List<Integer> res=new ArrayList<>();
        
        for(int i=2; i<=Math.sqrt(N); i++)
        //The intuition behind the corrected code is to iteratively find the smallest prime divisor of the number N and add it to the result list. This process is repeated until N becomes 1.
            while(N%i==0){
                res.add(N);
                N/=i;
            }
        if(N>1)
            res.add(N);
        res.add(1);
        Collections.reverse(res);
        return res.stream().mapToInt(i->i).toArray();
    }
}
