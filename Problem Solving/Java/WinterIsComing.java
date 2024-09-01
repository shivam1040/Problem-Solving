/*
Winter is coming, along with winter comes the white walkers who may destroy every human life on the planet. Only Brandon can stop it from happening but he is kidnapped by the White Walkers. His brother Jon wishes to set him free so that they can stop the destruction.
To set his brother free Jon has to kill the White Walkers who stand against the cave where his brother is kept as slave. Jon has somehow managed to place few of his men among the White Walkers who may help him in rescuing Brandon. Jon has the power to kill at most k White Walkers at a time, after which he would need one of his friends to help him gain back his power. Every time Jon meets any of his friend his power is restored to k.

The n White Walkers (all assumed to be White Walkers apparently) stand in the given order denoted by some numbers. The ith person will have the number a[i] associated with them. Jon can identify his friend with the help of the numbers. If the number is prime, it is Jon’s friend who stands there else it’s the White Walkers.

Given the order, comment whether Jon will be able to rescue his brother or not.


Example 1:

Input:
n = 5, k = 2
Arr = {6 , 3, 4, 5, 6}
Output: 1
Explaination: Jon can kill at most 2 White 
Walkers before reaching his friend. 
He kills the first (6) and he finds his 
friend (3) then again he kills one (4) and 
finds his friend (5). He now only has to kill 
one White Walker (6) to reach his brother.

Example 2:

Input:
n = 6, k = 3
Arr = {1, 2, 10, 4, 6, 8}
Output: 0
Explaination: same logic as the previous one.

Your Task:
You don't need to read input or print anything. Your task is to complete the function ableTorescue() which takes the array Arr[] and its size n and k as input parameters and returns 1 if Jon is able to rescue his brother, 0 if he cannot.


Expected Time Complexity: O(nloglogn)
Expected Auxiliary Space: O(n)


Constraints:
1 <= k <= n <=105
1 <= Arr[i] <= 105


*/

//{ Driver Code Starts
//Initial Template for Java

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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int k = Integer.parseInt(input[1]); 
            String input_line[] = br.readLine().trim().split("\\s+");
            int Arr[]= new int[n];
            for(int i = 0; i < n; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.ableTorescue(Arr, n, k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int ableTorescue(int Arr[], int n, int k)
    {
        // code here
        int temp=k;
        
        for(int i:Arr){
            if(i%2!=0)
                temp=k;
            else
                temp--;
            if(temp<0)
                return 0;
        }
        return 1;
    }
}
