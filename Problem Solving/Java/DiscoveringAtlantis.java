/*
Jack and Jelly are on the ship en route to discover Atlantis and decide to play a game. The distance between their starting point and the city of Atlantis is N kilometers. They take turns manning the ship and each of them can steer the ship for 1, 2, or 4 kilometers in one turn. This should never exceed the remaining distance. The captain who is in charge of the ship when they react Atlantis wins the game.
If Jelly starts as the captain in charge of the ship, find who wins the game, i.e., who will be in charge of the ship when they reach Atlantis given both Jack and Jelly play optimally.


Example 1:

Input: N = 2
Output: JELLY
Explaination: Jelly can cover 2 Km 
in his first turn itself.

Example 2:

Input: N = 3
Output: JACK
Explaination: On his first turn Jelly can 
cover either 1 or 2km. In either case, Jack 
will cover the remaining distance in his turn.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function captain() which takes the N as the input parameter and returns a string ("JACK" or "JELLY") denoting the name of the final captain.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N ≤ 107
*/

//{ Driver Code Starts
// Intitial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.captain(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static String captain(int N){
        // code here
        //notice the pattern whenever n mod 3 is zero Jelly loses
        
        return N%3==0 ? "JACK" : "JELLY"; 
    }
}
