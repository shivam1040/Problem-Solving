/*
Joey is a food lover, but Monica is concerned about his health and thus refuses to give him any more food. But on Joey's request, she agrees to give him more food only if he solves this problem. You have two integers a and b which are the number of C's and the number of S's. You need to find the maximum number of words of "SCC" which can be formed from this.
Note:  2 C's can form a S.

Example 1:

Input:
a = 2 
b = 1

Output:
1

Explanation:
We have a = 2 which means we have 2 C's and b = 1
which means we have a S.
therefore we can make only 1 "SCC".
Example 2:

Input:
a = 3 
b = 1

Output:
1

Explanation:
We have a = 3 which means we have 3 C's and b = 1
which means we have a S.
therefore we can make only 1 "SCC". and 1 C is
remaining which cannot be used to form more "SCC".
Your Task:  
You don't need to read input or print anything. Your task is to complete the function countSCC() which takes two integers a and b as input parameter and returns the count of "SCC" formed using a number of C and b number of S.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= a,b <= 108
*/

/*
If the number of 'C's (a) is less than twice the number of 'S's (2*b), it means that we'll run out of 'S's before forming the complete 'C's pair required. In this case, we can form a / 2 words of "SCC".
If the number of 'C's is greater than or equal to twice the number of 'S's, then we know that with two 'C's we can form one 'S'. So, we can form b complete 'S's with the available 'C's (2*b). After that, we can create more 'S's from the remaining 'C's, considering each 'S' requires two 'C's and one 'S' can form one "SCC". Hence, the formula becomes (b + (a - 2*b) / 4).
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int a=sc.nextInt();
			int b=sc.nextInt();
            
            Solution ob = new Solution();
            int ans  = ob.countSCC(a,b);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int countSCC(int a,int b){
        // code here
        return a<2*b ? a/2 : (b + (a - 2*b)/4);
    }
}
