/*
Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.

Example 1:

Input:
5
4 2 -3 1 6

Output: 
Yes

Explanation: 
2, -3, 1 is the subarray 
with sum 0.
Example 2:

Input:
5
4 2 0 1 6

Output: 
Yes

Explanation: 
0 is one of the element 
in the array so there exist a 
subarray with sum 0.
Your Task:
You only need to complete the function subArrayExists() that takes array and n as parameters and returns true or false depending upon whether there is a subarray present with 0-sum or not. Printing will be taken care by the drivers code.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 104
-105 <= a[i] <= 105
*/

// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG {
        public static void main (String[] args) {
            //code
                //code
                
            //taking input using class Scanner
            Scanner scan = new Scanner(System.in);
            
            //taking total number of testcases
            int t = scan.nextInt();
            while(t>0)
            {
                //taking total count of elements
                int n = scan.nextInt() ;
                
                //Declaring and Initializing an array of size n
                int arr[] = new int[n];
                
                //adding elements to the array
                for(int i = 0; i<n;i++)
                {
                    arr[i] = scan.nextInt();
                }
                
                t--;
                
                 //calling the method findSum
                 //and print "YES" or "NO" based on the result
                 System.out.println(new Solution().findsum(arr,n)==true?"Yes":"No");
            }
        }
        
        
    }// } Driver Code Ends
    
    //Idea here is to check if two opposite sums exist or not
    class Solution{
        //Function to check whether there is a subarray present with 0-sum or not.
        static boolean findsum(int arr[],int n)
        {   
            Set<Integer> hs = new HashSet<Integer>();
            int sum=0;
            for(int i=0; i<n; i++){
              // Add current element to sum
                sum += arr[i];
    
                // Return true in following cases
                // a) Current element is 0
                // b) sum of elements from 0 to i is 0
                // c) sum is already present in hash set
                if (arr[i] == 0 
                    || sum == 0 
                    || hs.contains(sum))
                    return true;
    
                // Add sum to hash set
                hs.add(sum);
                }
                return false;
            }
        }
    