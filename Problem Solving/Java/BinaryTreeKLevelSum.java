/*
Given a binary tree and a number K, the task is to find sum of tree nodes at level K. The Binary Tree is given in string form S: (node-value(left-subtree)(right-subtree)).

 

Example 1:

Input:
K = 2
S = "(0(5(6()())(4()(9()())))(7(1()())(3()())))"
Output:
14
Explanation:
The Tree from the above String will be formed as:
                             0
                           /   \
                          5      7
                        /  \    /  \
                       6    4  1    3
                             \
                              9  
Sum of nodes at the 2nd level is 6+4+1+3 = 14.
Example 1:

Input:
K = 1
S = "(4(8()9())"
Output:
17
Explanation:
The Tree from the above String will be formed as:
                             4
                           /   \
                          8     9
Sum of nodes at the 1st level is 8+9 = 17.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kLevelSum() which takes an Integer K and a String S as input and returns the sum of all the node values at Kth level of the tree.

 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

 

Constraints:
5 <= |S| <= 105
0 <= K <= 15
*/

/*
Just keep track of the levels. You dont actually need to construct a tree. Maintain a level count, on encountering any '(' increment the level and similarly on encountering any ')' decrement the current level. Whenever you encounter an integer, that integer will belong to the level stored by the level counter at that point. Make a map to keep track of the same.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(read.readLine().trim());
            
            String S = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.kLevelSum(K,S));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static int kLevelSum(int K, String S) {
        // code here
        int sum=0, level=-1;
        
        for(int i=0; i<S.length(); i++){
            
            if(S.charAt(i)=='(')
                level++;
            else if(S.charAt(i)==')'){
                level--;
            }
            else if(level==K){
                int temp=0;
                while(S.charAt(i)!='(' && S.charAt(i)!=')'){
                    //creating a number from characters
                    temp=temp*10+S.charAt(i)-'0';
                    i++;
                }
                //this i-- accounts for increment in i in while loop beacause of which the while condition breaks
                i--;
                sum+=temp;
            }
        }
        return sum;
    }
}
