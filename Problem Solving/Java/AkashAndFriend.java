/*
Akash is good at mathematics and games. He also has a nature of boasting about it. He invites his best friend to dinner and ask him to play his newly invented game.

He presents N numbers and an integer K. The game goes like this:

Each player will be given turn one by one. In each of their turn they can choose any number (non-zero) from the given array and divide (Integer division) it with K. The player who is unable to complete his move looses. Akash is very confident about his skills and knowledge about the game so he gives the first chance to his friends.
 

Example 1:

Input: nums = [1, 2, 3], k = 2
Output: Akash
Explanation: Friend will choose 2, then numbers
will become [1, 1, 3]. Akash will choose 3, 
then numbers will become [1, 1, 1].Friend will 
choose 1 then numbers become [0, 1, 1]. Akash 
will choose 1 then numbers will become 
[0, 0, 1]. Friend will choose 1 then numbers 
will become [0, 0, 0]. Now akash can't make 
a move.
Example 2:

Input: nums = [2, 4, 6], k = 2
Output: Friend
Explanation: Akash will win the game.
 

Your Task:
You don't have to read or print anything. Your task is to complete the function Play() which takes the list of numbers as input parameter and returns "Akash" if his friend wins otherwise returns "Friend" (Without quotes).
 

Expected Time Complexity: O(n * c) where c is constant.
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 100000
2 <= k <= 1000000
1 <= numbers <= 1000000
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
            String s = br.readLine().trim();
            String s1 = br.readLine().trim();
            String[] S1 = s.split(" ");
            String[] S2 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            int[] nums = new int[n];
            for(int i = 0; i < S2.length; i++)
                nums[i] = Integer.parseInt(S2[i]);
            Solution ob = new Solution();
            String ans = ob.Play(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String Play(int[] nums, int k)
    {
        // code here
        boolean temp=false;
        
        for(int i:nums)
        //keep on dividing the number, move to next until not 0, find turns by using boolean
            while(i>0){
                temp=!temp;
                i/=k;
            }
        return temp ? "Akash" : "Friend";
    }
}

