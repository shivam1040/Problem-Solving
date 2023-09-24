/*
Given a number N, count the numbers from 1 to N that don’t contain digit 3 in their decimal representation.
 

Example 1:

Input:
N = 5
Output:
4
Explanation:
From 1 - 5, only 3 contains
3 in its decimal representation
so output is 4
Example 2:

Input:
N = 25
Output:
22
Explanation:
In between 1 to 25,
3,13,23 contain 3 in their
decimal representaion so 
output is 25 - 3 = 22

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes an integer N as input parameter and returns an integer, the total count of numbers from 1 to N that don’t contain digit 3 in their decimal representation.
 

Expected Time Complexity: O(log N)
Expected Space Complexity: O(1)
 

Constraints:
0 <= N <= 500
*/

/*
The given code provides an alternative implementation for counting the numbers from 1 to N that don't contain the digit 3 in their decimal representation. Let's explain how it works:

1. The function `count` takes an integer `n` as input and returns the count of numbers from 1 to `n` that don't contain the digit 3.

2. The first two base cases handle the scenarios when `n` is less than 3 or between 3 and 9. If `n` is less than 3, the function simply returns `n`. If `n` is between 3 and 9, it returns `n-1` because there is one number (3) that contains the digit 3.

3. The code calculates `po`, which represents the highest power of 10 that is less than or equal to `n`. This is done by finding the number of digits in `n` and using a while loop to increment `po` until it is greater than `n`. For example, if `n` is 578, `po` will be 100.

4. The code then finds the most significant digit (msd) of `n` by dividing `n` by `po`. For example, if `n` is 578, `msd` will be 5.

5. The code checks if the most significant digit (`msd`) is not equal to 3. If this condition is true, it means that the numbers from 1 to `n` don't have the digit 3 in the most significant position.

6. In the case when the most significant digit is not 3, the code recursively calculates the count for three different parts:

   a. `count(msd) * count(po - 1)`: This calculates the count of numbers formed by the most significant digit (`msd`) multiplied by the count of numbers formed by the remaining digits (represented by `po - 1`). For example, for `n = 578`, this part calculates the count for numbers in the range 100-499 (4 * count(99)).

   b. `count(msd)`: This adds the count for the most significant digit (`msd`) itself. In the example above, it adds the count for the number 5.

   c. `count(n % po)`: This recursively calculates the count for the remaining digits of `n` after removing the most significant digit. For example, for `n = 578`, this part calculates the count for numbers in the range 500-578.

   Finally, it returns the sum of these three parts.

7. If the most significant digit (`msd`) is 3, it means that all the numbers from 1 to `n` with the most significant digit as 3 will contain the digit 3. In this case, the function returns the count of numbers in the range 100-299 for the given number of digits (`msd * po - 1`).

The approach used in this code leverages the concept of recursion and the properties of decimal representation to count the numbers without explicitly iterating through each number. It achieves the desired result with an efficient time complexity.
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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long count(int n)        
    {
        // code here
        if(n<3)
            return n;
        else if(n>=3 && n<10)
            return n-1;
        
        int pod=1;
        
        while(n/pod>9)
            pod*=10;
        
        int msd=n/pod;
        
        if(msd!=3)
            return count(msd)*count(pod-1)+count(msd)+count(n%pod);
        else
            return count (msd*pod-1);
    }
}

