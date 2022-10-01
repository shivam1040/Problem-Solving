/*
Ishika got stuck on an island. There is only one shop on this island and it is open on all days of the week except for Sunday. Consider following constraints:

N – The maximum unit of food you can buy each day.
S – Number of days you are required to survive.
M – Unit of food required each day to survive.
Currently, it’s Monday, and she needs to survive for the next S days.
Find the minimum number of days on which you need to buy food from the shop so that she can survive the next S days, or determine that it isn’t possible to survive.

Example 1:

Input: S = 10, N = 16, M = 2
Output: 2
Explaination: One possible solution is to 
buy a box on the first day (Monday), 
it’s sufficient to eat from this box up to 
8th day (Monday) inclusive. Now, on the 9th 
day (Tuesday), you buy another box and use 
the chocolates in it to survive the 9th and 
10th day.
Example 2:

Input: S = 10, N = 20, M = 30
Output: -1
Explaination: She can’t survive even if 
she buy food because the maximum number 
of units she can buy in 1 day is less the 
required food for 1 day.
Your Task:
You do not need to read input or print anything. Your task is to complete the function minimumDays() which takes S, N, and M as input parameters and returns the minimum number of days Ishika needs to buy food. Otherwise, returns -1 if she cannot survive.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N, S ≤ 50
1 ≤ M ≤ 30
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        //checking if a week's byu-able supply is more than a week's requirement and also if per day buyable supply is more than required supply
        if(((N * 6) < (M * 7) && S > 6) || N<M)
            return -1;
        
        float aux=(S*M);
        aux/=N;
        int res=(S*M)/N;
        if(aux>res)
            res+=1;
        return res;
    }
}
