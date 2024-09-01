/*
Dr. Zora built an algorithm to set the destructive or danger year,  his algorithm contains a pattern of years which were set by Hydra for attacks. As the Avengers needs to be ready mentally as well as physically. Agent Natalia Romanoff is assigned the task to detect the pattern of the selection of destruction year, and help Avengers. Agent Romanoff observes from the past details that, year ........,1824, 1842, 1848, 1860........, 1912, 1918, ......2012 were Destructive Years. Now observing the pattern Agent Romanoff needs to design an algorithm to determine future Destructive Years. Help her!   

Example 1:

Input: Year = 1848 
Output: "Destructive Year" 
Explanation:  According to agent Romanoff
Year 1848 is Destructive.

Example 2:

Input: Year = 1973
Output: "Non-Destructive Year"
Explanation: According to agent Romanoff
Year 1973 is Non-Destructive. 

Your Task:  
You dont need to read input or print anything. Complete the function isDestructive() which takes year as input parameter and returns that its Destructive or Non-Destructive.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
200<= year <=9999
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
            int year = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isDestructive(year));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String isDestructive(int year){
        // code here
        int temp=year, sum=0;
        
        while(temp!=0){
            int temp1=temp%10;
            sum+=temp1;
            temp/=10;
        }
        int last2=year%100;
        
        if(sum%2!=0 && last2%6==0)
            return "Destructive Year";
        return "Non-Destructive Year";
    }
}
