/*
You are given a list of integers nums where each number represents a vote to a candidate. Return the ids of the candidates that have greater than n/3 votes, If there's not a majority vote, return -1. 

Example 1:
Input:
n = 11
nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output:
[5,6]
Explanation:
5 and 6 occur more n/3 times.
 

Example 2:
Input:
n=5
nums = [1,2,3,4,5]
Output:
[-1]
Your Task:
You don't need to read input or print anything. Your task is to complete the function Solve() which takes a integer n denoting a number of element and a list of numbers and return the list of number which occur more than n/3 time.

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraint:
1 <=  n  <= 5 * 104
-109 <= nums[i] <= 109


*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.Solve(n, nums);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> Solve(int n, int[] nums) {
        // code here
        int num1=-1, num2=-1, count1=0, count2=0;
        ArrayList<Integer> res=new ArrayList<>();
        
        //boye moore voting algo
        
        for(int i:nums){
            if(num1==i)
                count1++;
            else if(num2==i)
                count2++;
            else if(count1==0){
                num1=i;
                count1=1;
            }
            else if(count2==0){
                num2=i;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1=count2=0;
        
        for(int i:nums){
            if(i==num1)
                count1++;
            else if(i==num2)
                count2++;
        }
        
        if(count1>n/3)
            res.add(num1);
        if(count2>n/3)
            res.add(num2);
        if(res.size()==0)
            res.add(-1);
        return res;
        
    }
}
        

