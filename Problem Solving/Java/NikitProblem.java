/*
Nikit has to give a short contest of duration "n" minutes. The contest is divided into 2 sections-Easy and Hard. x and y marks will be awarded per problem for Easy and Hard respectively. Assume that he will take p minutes to solve an Easy problem and q minutes to solve a Hard problem successfully.
There are a and b number of Easy and  Hard problems respectively. Calculate how many problems of a particular section should he perform to get the maximum score in time.
Note: Assume he will always try to solve the easiest problem.
 

Example 1:

Input: n = 180, x = 2, y = 5, a = 4
b = 6,p = 20, q = 40
Output: 1 4
Explanation: Maximum marks get scored 
when he solves 1 easy and 4 hard problems.
Example 2:

Input: n = 50, x = 5, y = 10, a = 5 
b = 3, p = 10, q = 20
Output: 5 0
Explanation : Maximum marks gets scored 
when he solves 5 easy problems or 1 easy 
and 2 hard problems or 3 easy and 1 hard 
problem. But he always try to solve the 
easiest problem therefore solves 5 easy 
problems.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function maximumScore() which takes n, x, y, a, b, p, and q as input parameter and returns a list which contains the total number of easy problems and hard problems required to solve to get the maximum score.
 

Expected Time Complexity: O(a * b)
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 1000
1 <= x < y <= 100
1 <= a, b <= 100
1 <= p < q <= 100
*/

//{ Driver Code Starts

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
            String [] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            String s2 = br.readLine().trim();
            String [] S2 = s2.split(" ");
            int x = Integer.parseInt(S2[0]);
            int y = Integer.parseInt(S2[1]);
            String s3 = br.readLine().trim();
            String [] S3 = s3.split(" ");
            int a = Integer.parseInt(S3[0]);
            int b = Integer.parseInt(S3[1]);
            String s4 = br.readLine().trim();
            String [] S4 = s4.split(" ");
            int p = Integer.parseInt(S4[0]);
            int q = Integer.parseInt(S4[1]);
            Solution ob = new Solution();
            int[] ans = ob.maximumScore(n, x, y, a, b, p, q);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();         
        }
    }
}

// } Driver Code Ends



class Solution
{
    public int[] maximumScore(int n, int x, int y, int a, int b, int p, int q)
    {
        // Code here
        List<Pair<Integer, Integer>> aux = new ArrayList<>();
        int total=0, maxi=0, easy, hard;
        //finding all the pairs then getting max
        for(int i=0; i<=a; i++)
            for(int j=0; j<=b; j++)
                if(i*p+j*q<=n){
                    total=x*i+y*j;
                    if(total>=maxi){
                        maxi=total;
                        aux.add(new Pair<>(i, j));
                    }
                }
        int res[]=new int[2];
        //always store last value since max easy is given first preference
        Pair<Integer, Integer> i=aux.get(aux.size()-1);
        res[0]=i.first;
        res[1]=i.second;
        
        return res;
    }
}

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

