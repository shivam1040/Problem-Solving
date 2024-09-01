/*
Rahul and his friends decided to play a game in a New Year Party and the winner will be given some cash prize as decided among them.The game is as follows:-
1.N carpets will be arranged in a row and each of them will have a number written on it.
2.A basket full of chocolate is kept there and a person has to take out M chocolates from the basket before starting the game.
3.A person with M chocolates will start at the first carpet ,eat one chocolate and move to the second one,then again eat one chocolate and move to the third one...and so on..
4.If on reaching any carpet ,the number of chocolates in the persons hand is less than the number written on the carpet ,then that  person loses the game.
Find the minimum number of chocolate Rahul should take out of the basket to ensure that he wins the game.
Note:Number of chocolates and the number written on the carpet are compared before the person eats the chocolate on that carpet.See the examples given. 


Example 1:

Input:
N = 5
arr = {6, 5, 4, 3, 2}
Output: 6
Explaination: If Rahul takes 6 chocolates, 
on the first step we have 6 >= 6 everything 
is OK, then after he ate one chocolate,  
the chocolates decreased to 5 and on the 
2nd carpet we'll receive 5 >= 5, again OK, 
and so on.

Example 2:

Input:
N = 5
Arr = {3, 4, 3, 1, 1}
Output: 5
Explaination: If Rahul takes 4 chocolates, 
then he will loose the game on reaching 
the 2nd carpet.

Your Task:
You don't need to read input or print anything. Your task is to complete the function minimumChocolates() which takes the array arr[] and its size N as input parameters and returns the minimum number of chocolate Rahul should take out of the basket to ensure that he wins the game.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumChocolates(arr, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int minimumChocolates(int arr[], int N)
    {
        // code here
        int res=0, count=0;
        
        for(int i:arr){
            if(i>count){
                res+=i-count;
                count+=i-count;
            }
            count--;
        }
        return res;
    }
}

