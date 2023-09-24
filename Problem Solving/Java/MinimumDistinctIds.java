/*
Given an array of items, the i'th index element denotes the item id’s and given a number m, the task is to remove m elements such that there should be minimum distinct id’s left. Print the number of distinct id’s.

Example 1 -

Input:
n = 6
arr[] = {2, 2, 1, 3, 3, 3}
m = 3
Output:
1
Explanation : 
Remove 2,2,1
Example 2 -

Input:
n = 8
arr[] = {2, 4, 1, 5, 3, 5, 1, 3}
m = 2
Output:
3
Explanation:
Remove 2,4
Your Task:
This is a function problem. You don't have to take any input. Your task is to complete the distinctIds() which takes sorted array, its size n, and m as its parameter. You only need to find the minimum number of distinct IDs and return it. The driver code will print the returned value.

Expected Time Complexity: O(n log(n))
Expected Auxillary Space: O(n)

Constraints:
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 106
1 ≤ m ≤ 103
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            int arr[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            
            System.out.println(new Solution().distinctIds(arr, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int distinctIds(int arr[], int n, int m)
    {
        // Complete this function
      Map<Integer, Integer> aux=new LinkedHashMap<>();
        
        for(int i:arr)
            aux.put(i, aux.getOrDefault(i, 0)+1);
            
        aux= aux.entrySet().stream().sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
        .collect(Collectors.toMap(
            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)
            );

        int res=0;
        
        for (Map.Entry<Integer, Integer> i :
             aux.entrySet()) {
             m-=i.getValue();
             if(m>=0)
                res++;
                
        }
        
        return aux.size()-res;
    }
}
