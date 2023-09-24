/*
The worlds most successful thief Albert Spaggiari was planning for his next heist on the world bank. He decides to carry a sack with him, which can carry a maximum weight of C kgs. Inside the world bank there were N large blocks of gold. All the blocks have some profit value associated with them i.e. if he steals ith block of weight w[i] then he will have p[i] profit. As blocks were heavy he decided to steal some part of them by cutting them with his cutter.
The thief does not like symmetry, hence, he wishes to not take blocks or parts of them whose weight is a perfect square. Now, you need to find out the maximum profit that he can earn given that he can only carry blocks of gold in his sack. 
Note: The answer should be precise upto 3 decimal places.

Example 1 :

N = 3, C = 10
w[] = {4, 5, 7}
p[] = {8, 5, 4)
Output: 
7.857
Explanation: As first blocks weight is 4
which is a perfect square, he will not use 
this block. Now with the remaining blocks 
the most optimal way is to use 2nd block 
completely and cut 5kg piece from the 3rd 
block to get a total profit of 5 + 2.857 
= 7.857
Your Task:
You don't need to read or print anything. Your task is to complete the function maximumProfit() which takes N, C, w[ ] and p[ ] as input parameters and returns the maximum profit thief can achieve with precision upto 3 decimal places.

Expected Time Complexity: O(N * LogN)
Expected Space Complexity : O(N)

Constraints:
1 ≤ N ≤ 103
1 ≤ C ≤ 1018
1 ≤ Wi ≤ 109
1 ≤ Pi ≤ 109
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            long C = Long.parseLong(S1[1]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            long [] w = new long[n];
            long [] p = new long[n];
            for(int i = 0; i < n; i++){
                w[i] = Long.parseLong(S2[2*i]);
                p[i] = Long.parseLong(S2[(2*i)+1]);
            }
            Solution ob = new Solution();
            double ans = ob.maximumProfit(n, C, w, p);
            String a1 = String.format("%.3f",ans);
            System.out.println(a1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Pair{
    double per;
    long w;
    
    Pair(double per, long w){
        this.per=per;
        this.w=w;
    }
}
class Solution
{
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        // Code here
        List<Pair> aux=new ArrayList<>();
        
        for(int i=0; i<N; i++){
            int temp=(int)Math.sqrt(w[i]);
            if(temp*temp!=w[i]){
            aux.add(new Pair((double)p[i]/(double)w[i], w[i]));
            }
        }
        
        Collections.sort(aux,new Comparator<Pair>() {
    @Override
    public int compare(Pair a, Pair b) {
         if (a.per == b.per)
                return 0;
            else if (a.per > b.per)
                return 1;
            else
                return -1;
    }
});



Collections.reverse(aux);
//System.out.println(aux);

int i=0;
double res=0;

while(i<N && C>0){
    long weightToTakeEvenAfterSlicing=Math.min(C, aux.get(i).w);
    res+=weightToTakeEvenAfterSlicing*aux.get(i).per;
    C-=weightToTakeEvenAfterSlicing;
    i++;
}

return res;

    }
}
