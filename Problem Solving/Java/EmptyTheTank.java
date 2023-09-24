/*
Given a tank with capacity C litres which is completely filled in starting. At the end of every day, tank is filled with L litres of water and in the case of overflow extra water is thrown out. Now on i-th day i litres of water is taken out for drinking. We need to find out the day at which tank will become empty the first time.

Example 1:

Input: C = 5, L = 2
Output: 4 
Explanation: At the start of 1st day, 
water in tank = 5 and at the end of 
the 1st day = (5 - 1) = 4 At the start
of 2nd day, water in tank = 4 + 2 = 6 
but tank capacity is 5 so water = 5 and 
at the end of the 2nd day = (5 - 2) = 3 
At the start of 3rd day, water in 
tank = 3 + 2 = 5 and at the end of the 
3rd day = (5 - 3) = 2 At the start of 4th 
day, water in tank = 2 + 2 = 4 and at the 
end of the 4th day = (4 - 4) = 0 
So final answer will be 4.
Example 2:

Input: C = 6, L = 1
Output: 4
Explanation: At the start of 1st day,
water in tank = 6 and at the end of
the 1st day = (6 - 1) = 5 At the start
of 2nd day, water in tank = 5 + 1 = 6
and at the end of the 2nd day = (5 - 2)= 3
At the start of 3rd day, water in
tank = 3 + 1 = 4 and at the end of the
3rd day = (4 - 3) = 1 At the start of 4th
day, water in tank = 1 + 1 = 2 and at the
end of the 4th day = (2 - 4) < 0
So final answer will be 4.

Your Task:  
You dont need to read input or print anything. Complete the function minDaysToEmpty() which takes C and L as input parameter and returns the the day at which tank will become empty the first time.

Expected Time Complexity: O(logC)
Expected Auxiliary Space: O(1)

Constraints:
1<= C, L <=105
*/

/*
We can see that tank will be full for starting (l + 1) days because water taken out is less than water being filled. After that, each day water in the tank will be decreased by 1 more liter and on (l + 1 + i)th day (C – (i)(i + 1) / 2) liter water will remain before taking drinking water. 

Now we need to find a minimal day (l + 1 + K), in which even after filling the tank by l liters we have water less than l in tank i.e. on (l + 1 + K – 1)th day tank becomes empty so our goal is to find minimum K such that, 
C – K(K + 1) / 2 <= l
*/

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(read.readLine());
            int l = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.minDaysToEmpty(c, l));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static long minDaysToEmpty(long C, long l) {
        // code here
        if(C<=l)
            return C;
        
        int low=0, high=(int)1e4, mid;
        
        while(low<high){
            mid=(low+high)/2;
            int sum=(mid*(mid+1))/2;
            
            if(sum>=C-l)
                high=mid;
            else
              low=mid+1;  
        }
        return low+l;
    }
}
