/*
You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.
Note - Strings S1 and S2 can be empty.

 

Example 1:

Input  : []][][
Output : 2
Explanation :
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]

 

Example 2:

Input : [[][]]
Output : 0 
Explanation:
String is already balanced.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function minimumNumberOfSwaps() which takes the string S and return minimum number of operations required to balance the bracket sequence.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:

1<=|S|<=100000
*/

/*
We can just keep a counter variable " imbalance " that checks the balance i.e. if the number of closing brackets is more than opening bracket than it would have a positive value. Whenever we come across an opening bracket  ' [ ' we would check if the " imbalance " is positive or not. If found positive that means we have to swap this bracket with the previous characters and reach the position where imbalance first becomes positive. As we are only concerned with the number of operations, it will take " imbalance " number of operations to perform the swap
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {   
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String S){
        // code here
        int res=0, imbalance=0, left=0, right=0;
        
        for(int i=0; i<S.length(); i++){
            char c=S.charAt(i);
            if(c=='['){
                //count of left brackets
                left++;
                if(imbalance>0){
                    //adding swap required to result
                    res+=imbalance;
                    //one swwap can only solve only one pair of imbalance hence single decrement
                    imbalance--;
                }
            }
            else if(c==']'){
                right++;
                //updating imbalance count;
                imbalance=right-left;
            }
        }
        return res;
    }
}
