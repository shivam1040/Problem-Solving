/*
Let Max be the maximum possible mean of a multiset of values obtained from an array Arr of length N. Let Min be the minimum possible mean of a multiset of values obtained from the same array. Note that in a multiset values may repeat. The task is to find the number of multisets with mean as Max and the number of multisets with mean as Min. The answer may be too large so output the number of multisets modulo 109+7.

 

Example 1:

Input:
N = 5
Arr = {3, 1, 2, 3, 4} 
Output:
1 1
Explanation:
The maximum possible Mean of a Subset
of the array is 4. There can be only 1
such subset - {3, 1, 2, 3, 4}.
The minimum possible Mean of a Subset
of the array is 1. There can be only 1
such subset - {3, 1, 2, 3, 4}.
Example 2:

Input:
N = 3
Arr = {1, 2, 1} 
Output:
1 3
Explanation:
The maximum possible Mean of a Subset
of the array is 2. There can be only 1
such subset - {1, 2, 1}.
The minimum possible Mean of a Subset
of the array is 1. There can be 3 such
subsets - {1, 2, 1}; {1, 2, 1}; {1, 2, 1}.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfSubsets() which takes an Integer N and an array Arr[] as input and returns a vector of two numbers- the number of multisets with mean as Max and the number of multisets with mean as Min.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= Arr[i] <= 105
*/

/*
The maximum mean of any multi-subset will happen if and only if the multi-subset consists of only the largest element in our array.

{1,2,3,3,3}
 

3 is the largest element and it occurs 3 times. 

There can be 2^(3) - 1 = 7 such multi-subsets.

*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().split(" ");
            int[] Arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                Arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.numOfSubsets(Arr,N);
        
            System.out.println(ptr[0] + " " + ptr[1]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] numOfSubsets(int[] Arr , int N) {
        // code here
        Map<Integer, Integer> aux=new HashMap<>();
        
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        
        for(int i:Arr){
            aux.put(i, aux.getOrDefault(i, 0)+1);
            max=Math.max(max, i);
            min=Math.min(min, i);
        }
        
        return new int[]{(int)Math.pow(2, aux.get(max))-1, (int)Math.pow(2, aux.get(min))-1};
    }
};
