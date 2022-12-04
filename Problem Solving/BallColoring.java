/*
Given n balls . All of them are initially  uncolored . You have to color the balls with two colors RED and BLUE such that there can be atmost 2 positions where a RED ball is touching BLUE ball or vice versa. You have to color all the balls.Find the number of ways in which balls can be colored.

Example 1:

Input: n = 1
Output: 2
Explanation: Possible ways to color are {{R},{B}}. 
So the answer is 2 .

Example 2:

Input: n = 2
Output: 4
Explanation: Possible ways to color are 
{{RB},{BR},{RR},{BB}}.So the answer is 4.

Your Task:  
You dont need to read input or print anything. Complete the function noOfWays() which takes n as input parameter and returns  the number of ways in which balls can be colored.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= n <=105
*/

/*
We can color all the balls in 3 ways.

NO RED AND BLUE TOUCHING :  We can color N balls in this way in 2 ways , For example ,  RRR , BBB is valid coloring for 3 balls
RED AND BLUE TOUCHING IN ONE POSTION :  We can color N balls in this way in 2*(N-1) ways . For example RRB,RBB,BBR,BRR  for 3 balls
RED AND BLUE TOUCHING IN TWO POSITIONS : In this case, we have to change the color of balls in 2 positions. For N balls we can choose 1st position in (N-1) ways and 2nd position in (N-2) ways. So we can color all the balls in (N-2)*(N-1) ways . Because at least First and Last Ball should have same color to satisfy the condition . For example RBR , BRB 
So total number of ways is ANS = 2 + 2*(N-1) + (N-2)*(N-1) = 2 + N*(N-1)
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.noOfWays(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long noOfWays(long N){
        // code here
        return 2 + 2*(N-1) + (N-2)*(N-1);
    }
}
