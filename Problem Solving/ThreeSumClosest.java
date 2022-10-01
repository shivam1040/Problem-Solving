/*
Given an array, Arr of N numbers, and another number target, find three integers in the array such that the sum is closest to the target. Return the sum of the three integers.

Note: If there are multiple solutions, print the maximum one.

Example 1:

Input:
N = 6, target = 2
A[] = {-7,9,8,3,1,1}
Output: 2
Explanation: There is one triplet with sum
2 in the array. Triplet elements are -7,8,
1 whose sum is 2.
Example 2:

Input:
N = 4, target = 13
A[] = {5,2,7,5}
Output: 14
Explanation: There is one triplet with sum
12 and other with sum 14 in the array.
Triplet elements are 5, 2, 5 and 2, 7, 5
respectively. Since abs(13-12) ==
abs(13-14) maximum triplet sum will be
preferred i.e 14.
Your Task:
Complete threeSumClosest() function and return the expected answer.

Expected Time Complexity: O(N*N).
Expected Auxiliary Space: O(1).

Constraints:
3 ≤ N ≤ 103
-105 ≤ A[i] ≤ 105
1 ≤ target ≤ 105
*/

/*
Create three nested loops with counter i, j and k respectively.
The first loop will start from start to end, the second loop will run from i+1 to end, the third loop will run from j+1 to end.
Check if the difference of the sum of the ith, jth and kth element with the given sum is less than the current minimum or not. Update the current minimum
Print the closest sum.
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int target = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.threeSumClosest(array,target));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] array, int target)  
	{ 
        // code here
        Arrays.sort(array);
        int closest=Integer.MAX_VALUE;
       for(int i=0; i<array.length-2; i++){
           int leftPointer=i+1, rightPointer=array.length-1;
           while(leftPointer<rightPointer){
               int sum=array[i]+array[leftPointer]+array[rightPointer];
               if(Math.abs(target-sum)==Math.abs(target-closest))
                closest=sum>closest ? sum :closest;
               else if(Math.abs(target-sum)<Math.abs(target-closest))
                closest=sum;
               if(sum>target)
                rightPointer--;
               else
                leftPointer++;
           }
       }
       return closest;
    
	} 
} 
