/*
Given two numbers A and B count all the number between the given range whose second least significant digit in the binary representation of the number is 1.
 

Example 1:

Input:
A = 1
B = 4
Output:
2
Explanation:
In the given range 2 (10)
and 3 (11) are the numbers
whose second least 
significant digit in its
binary representation is 1.
Example 2:

Input:
A = 8
B = 10
Output:
1
Explanation:
In the given range 10 (1010)
is the number whose second
least significant digit in its
binary representation is 1

Your Task:
You don't need to read input or print anything. Your task is to complete the function find() which takes integers A, B as input parameters and returns the count of all the numbers between the given range whose second least significant digit in the binary representation of the number is 1.
 

Expected Time Complexity: O(1)
Expected Space Complexity: O(1)
 

Constraints:
1 <= A,B <= 109
*/

/*
The given function find calculates the number of integers in the range [A, B] (inclusive) whose binary representation has a second least significant digit of 1. The function achieves this by manipulating the range [A, B] to align it with the boundaries of the blocks of 4 numbers where the second least significant digit is 1, and then counting the number of such blocks within the range.

Here's a breakdown of the logic:

If A is 1 modulo 4, we can adjust A to the next multiple of 4 by adding 3 to it. This is because if A is 1 modulo 4, the next multiple of 4 will have the second least significant digit as 1. In this case, we increment the count by 2 (since there are 2 numbers in this block with the second least significant digit as 1).

If A is 2 modulo 4, we can adjust A to the next multiple of 4 by adding 2 to it. This is similar to the previous case, and we also increment the count by 2.

If A is 3 modulo 4, we can adjust A to the next multiple of 4 by adding 1 to it. In this case, we increment the count by 1.

Similarly, if B is 2 modulo 4, we can adjust B to the previous multiple of 4 by subtracting 2 from it and increment the count by 1.

If B is 3 modulo 4, we can adjust B to the previous multiple of 4 by subtracting 3 from it and increment the count by 2.

Finally, the number of integers in the range [A, B] whose binary representation has a second least significant digit of 1 is equal to (B - A) / 4 * 2 (since there are 2 such integers in each block of 4 numbers).

The function returns the total count of such integers in the range [A, B].
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0)
        {
            int A = in.nextInt();
            int B = in.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.find(A,B));
        }
    }
}
// } Driver Code Ends


class Solution{
    int find(int A,int B){
        // code here
        int ans=0;
        if(A%4==1){
            A+=3;
            ans+=2;
        }
        else if(A%4==2){
            A+=2;
            ans+=2;
        }
        else if(A%4==3){
            A+=1;
            ans+=1;
        }
        if(B%4==2){
            B-=2;
            ans+=1;
        }
        else if(B%4==3){
            B-=3;
            ans+=2;
        }
        ans+=(B-A)/4*2;
        return ans;
    }
};
