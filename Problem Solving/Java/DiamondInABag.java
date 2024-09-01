/*
A big diamond is hidden in one of N identical bags. A balance scale is being used to determine which bag is the heaviest in order to locate the diamond. Find the minimum number of time you need to use the balance scale to find the bag containing the diamond.


Example 1:

Input:
N = 3
Output: 1
Explaination: 
The balance scale is needed only once. 
Take any two bags and put them on the 
scale. Either one of them will turn out 
to be heavier or they will be of equal 
weight and the left out third bag will 
contain the diamond.

Example 2:

Input:
N = 10
Output: 3
Explaination: 
The balance scale is needed 3 times. 
1st Put 5 bags on each side and determine 
which side is heavier. Take those 5 bags 
and put 2 on one side and 2 on the other 
leaving 1 out of the balance scale. If the 
scale is perfectly balanced, then the left 
out bag has teh diamond. Otherwise if one 
side is heavier, put those two in the balance. 

Your Task:
You do not need to read input or print anything. Your task is to complete the function minScale() which takes N as input parameter and returns the minimum number of times you need to use the balance scale to get the bag with diamond.


Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
*/

/*
If there is only one bag (N=1), no weighings are needed, so the function returns 0.
If there are 2 or 3 bags, one weighing is enough to determine the heaviest bag, so the function returns 1.
For N > 3, the function calculates the minimum number of weighings needed by iteratively multiplying a product by 3 until it exceeds N, counting the number of iterations. This is because in each weighing, you can eliminate roughly one-third of the bags as lighter or heavier, reducing the number of possible bags by a factor of 3 each time.
This approach is based on the idea of using a ternary search tree to find the bag containing the diamond. Each weighing divides the bags into three groups, allowing you to eliminate one-third of the bags each time, leading to a logarithmic growth in the number of weighings needed as the number of bags increases.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minScale(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minScale(int N){
        // code here
        if(N==1)
            return 0;
        if(N==2 || N==3)
            return 1;
        int res=0, prod=1;
        
        while(prod<N){
            res++;
            prod*=3;
        }
        return res;
    }
}
