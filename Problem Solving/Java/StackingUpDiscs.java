/*
Given N number of circular discs. Each of the discs has a radius R and a thickness (height) H.  A disc of radius R1 and height H1 can be placed above another disc of radius R2 and height H2 if and only if R1 < R2 and H1 < H2.

Find out the height of the highest stack of discs that can be made.

Example 1:

Input:
N=3
R1=5 H1=6
R2=7 H2=5
R3=3 H3=4
Output: 10
Explanation: 
(3, 4)<(5, 6)and(3, 4)<(7, 5).
So we have two options but if we put 
(3, 4) above (5, 6) we get height of 
10 and if we put(3, 4) on (7, 5) 
we get height of 9.
The answer is thus 10. Note we 
can put (5,6) over (7,5) as 6>5.
Example 2:

Input:
N=2
R1=3 H1=7
R2=7 H2=4
Output:7
Explanation:We cannot place any of the
discs on top of another,So maximum height
is 7(of the first disc).

Your Task:
You don't need to read input or print anything. Your task is to complete the function StackingUpDiscs() which takes the integer N and the two arrays R and H as input parameter and returns the height of the highest stack that can be made from the given discs.

Expected Time Complexity:O(N^2)
Expected Auxillary Space:O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ Ri,Hi ≤ 105 for 1<=i<= N
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int R[] = new int[N];
            int H[] = new int[N];
            for(int i=0;i<N;i++){
                String s[]=read.readLine().split(" ");
                R[i]=Integer.parseInt(s[0]);
                H[i]=Integer.parseInt(s[1]);
            }
            Solution ob = new Solution();
            System.out.println(ob.StackingUpDiscs(N,R,H));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int StackingUpDiscs(int N,int R[],int H[]) {
        // code here
        List<Pair> arr = new ArrayList<>();
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr.add(new Pair(R[i], H[i]));
        }

        Collections.sort(arr, new PairComparator());

        dp[0] = arr.get(0).second;
        int ans = dp[0];
        
        for(int i=1; i<N; i++){
            dp[i]=arr.get(i).second;
            
            for(int j=0; j<i; j++){
                if(arr.get(i).first>arr.get(j).first && arr.get(i).second>arr.get(j).second)
                    dp[i]=Math.max(dp[i], dp[j]+arr.get(i).second);
            }
            ans=Math.max(ans, dp[i]);
            }
            return ans;
}
}

    class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.first - b.first;
        }
    }
