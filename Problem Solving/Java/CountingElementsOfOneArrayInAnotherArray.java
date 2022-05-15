/*
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Example 1:

Input:
m = 6, n = 6
arr1[] = {1,2,3,4,7,9}
arr2[] = {0,1,2,1,1,4}
Output: 4 5 5 6 6 6
Explanation: Number of elements less than
or equal to 1, 2, 3, 4, 7, and 9 in the
second array are respectively 4,5,5,6,6,6
Example 2:

Input:
m = 5, n = 7
arr1[] = {4 8 7 5 1}
arr2[] = {4,48,3,0,1,1,5}
Output: 5 6 6 6 3
Your Task :
Complete the function countEleLessThanOrEqual() that takes two array arr1[], arr2[],  m, and n as input and returns an array containing the required results(the count of elements less than or equal to it in arr2 for each element in arr1 where ith output represents the count for ith element in arr1.)

Expected Time Complexity: O((m + n) * log n).
Expected Auxiliary Space: O(1).

Constraints:
1<=m,n<=10^5
1<=arr1[i],arr2[j]<=10^5
*/

/*
Approach: Sort the elements of 2nd array, i.e., array arr2[]. Then perform a modified binary search on array arr2[]. For each element x of array arr1[], find the last index of the largest element smaller than or equal to x in sorted array arr2[]. The index of the largest element will give the count of elements.
Algorithm: 
 


Sort the second array.
Traverse through the elements of the first array from start to end.
For every element in the first array.
Do a binary search on the second array and find the index of the largest element smaller than or equal to the element of the first array.
The index of the largest element will give the count of elements. Print the count for every index.
*/

// { Driver Code Starts
    import java.util.*;

    class Count
    {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int m = sc.nextInt();
                int n = sc.nextInt();
                
                int arr1[] = new int[m];
                int arr2[] = new int[n];
                
                for(int i = 0; i < m; i++)
                  arr1[i] = sc.nextInt();
                  
                for(int i = 0; i < n; i++)
                  arr2[i] = sc.nextInt();
                  
                Solution gfg = new Solution();
                ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
                for (int i = 0; i < res.size(); i++)
                    System.out.print (res.get (i) + " ");
                System.out.println();
            }
            
        }
    }// } Driver Code Ends
    
    
    
    // Complete the function given below
    
    
    class Solution
    {
        public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
        {
           ArrayList<Integer> res=new ArrayList<Integer>();
           Arrays.sort(arr2);
           for(int i=0; i<arr1.length; i++){
               res.add((binarySearch(arr2, arr1[i]))+1);
           }
           return res;
        }
        
        static int binarySearch(int arr[], int x)
        {
            int l=0;
            int h=arr.length-1;
            while(l<=h){
                int mid=(l+h)/2;
                if(arr[mid]<=x)
                    l=mid+1;
                else
                    h=mid-1;
            }
            return h;
        }
    }