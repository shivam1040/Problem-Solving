/*
A knockout tournament is going on. A total of N number of players are participating. Each match will have two players. Every player has a distinct rating associated with him. The player with the more rating wins in a match. In one round, the 1st player will play a match against 2nd player, 3rd player will play a match against 4th player and so on. If there is odd number of players, last one will qualify to the next round without playing a match. Since it is a knockout tournament, whoever loses a match leaves the tournament. Rating of each player is unique.

Your task is to find out the number of matches each player wins in the tournament. The tournament ends when there is only one player remaining in the end.

 

Example 1:

Input:
N = 5
A[] = {7, 1, 5, 3, 9}
Output:
3 1 2 1 1
Explanation:
players: 7 1 5 3 9
The first round: (7 has a match with 1),
(5 has a match with 3), (9 has no matches
automatically qualifies)

players: 7 5 9
The second round: (7 has a match with 5),
(9 has no matches automatically qualifies)

players: 7 9
The third round: (7 has a match with 9).
The player with rating 7 played 3 matches. 
The player with rating 1 played 1 match. 
The player with rating 5 played 2 matches.
The player with rating 3 played 1 match.  
The player with rating 9 played 1 match.
 

Example 2:

Input:
N = 6
A[] = {8, 4, 3, 5, 2, 6}
Output:
3 1 1 2 1 2 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function getAnswer() which takes the array A[] and its size N as inputs and stores the number of wins of each player in the answer[] array.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105 
0 ≤ rating of player ≤ 106
The rating of the players will be distinct.
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n+5];
            int answer[] = new int[n+5];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.getAnswer(arr, answer, n);
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
            output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static void getAnswer(int arr[], int answer[], int n) 
    {
        // Your task is to store the answer of each index in the 'answer' array
        // Note: indexing is 0 based
        Map<Integer, Integer> aux=new HashMap<>();
        int size=n;
        
                for(int i=0; i<n; i++){
            aux.put(arr[i], i);
        }
        
        while(size>1){
            int counter=0;
            
            for(int i=0; i<size; i+=2){
                if(i+1<size){
                    ++answer[aux.get(arr[i])];
                    ++answer[aux.get(arr[i+1])];
                    //this sorts of create a new array by shifting winners to the left
                    // so 7 1 5 3 9 becomes 7 5 9 3 9 in first pass   
                    arr[counter++]=Math.max(arr[i], arr[i+1]);
                }
                else
                    arr[counter++]=arr[i];
            }
            size=counter;
        }
        }
    }

