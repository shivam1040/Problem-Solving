/*
Given an array A of integers and another number K. Find all the unique quadruple from the given array that sums up to K.

Also note that all the quadruples which you return should be internally sorted, ie for any quadruple [q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 
Explanation: Sum of 0, 0, 1, 2 is equal
to K.
Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 
        2 4 7 10 
        3 5 7 8 
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function fourSum() which takes the array arr[] and the integer k as its input and returns an array containing all the quadruples in a lexicographical manner. In the output each quadruple is separate by $. The printing is done by the driver's code.

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= N <= 100
-1000 <= K <= 1000
-100 <= A[] <= 100
*/

/*
Intuition:
The idea is to sort the array first, then iterate through the array with two outer loops to select the first two elements of the quadruple. For the remaining two elements, use two pointers to find pairs that sum up to k - (first_element + second_element).

Implementation:
Copy-of-Copy-of-Copy-of-Copy-of-Copy-of-Copy-of-P
Check if the size of the input array a is less than 4. If it is, return an empty vector since a quadruple cannot be formed.
Initialize an empty vector ans to store unique quadruples.
Sort the input array a in ascending order.
Run a loop from i = 0 to a.size() - 3:
Check if the current element a[i] is greater than 0 and greater than k. If it is, break the loop since no quadruplet can be found in this case as a[i] is already greater than k.
Check if i is greater than 0 and if a[i] is equal to the previous element a[i - 1]. If it is, continue to the next iteration to avoid duplicate quadruples.
Run a loop from j = i + 1 to a.size() - 2:
Check if j is greater than i + 1 and if a[j] is equal to the previous element a[j - 1]. If it is, continue to the next iteration to avoid duplicate quadruples.
Initialize two pointers left and right. left starts at j + 1, and right starts at the end of the array a.
Use a while loop with left less than right to find pairs of elements such that the sum of (a[i] + a[j] + a[left] + a[right]) is equal to k.
Inititalize two variable old_l equal to left and old_r equal to right;
Calculate the current sum as sum = a[i] + a[j] + a[left] + a[right].
If the sum is equal to k, add the quadruple {a[i], a[j], a[left], a[right]} to the ans vector.
Run a loop while left < right and a[left] == a[old_l] to skip duplicates.
Run a loop while left < right and a[right] == a[old_r] to skip duplicates.
else if sum is greater than k the move right pointer to left(i.e right--).
else move left pointer to right(i.e left++).
Return the ans vector containing all unique quadruples.

*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        if(arr.length<4)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        Arrays.sort(arr);
        for(int i=0; i<arr.length-3; i++){
            if(arr[i]>0 && arr[i]>k)
                break;
            if(i>0 && arr[i]==arr[i-1])
                continue;
            for(int j=i+1; j<arr.length-2; j++){
                if(j>i+1 && arr[j]==arr[j-1])
                    continue;
                int left=j+1, right=arr.length-1;
                
                while(left<right){
                    int oldL=left, oldR=right;
                    int sum=arr[i]+arr[j]+arr[left]+arr[right];
                    
                    if(sum==k){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[left]);
                        temp.add(arr[right]);
                        res.add(temp);
                        
                        while(left<right && arr[oldL]==arr[left])
                            left++;
                        while(left<right && arr[oldR]==arr[right])
                            right--;
                    }
                    else if(sum>k)
                        right--;
                    else
                        left++;
                }
            }
        }
        return res;
    }
}
