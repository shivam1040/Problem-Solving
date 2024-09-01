/*
Given a sorted array arr containing n elements with possibly some duplicate, the task is to find the first and last occurrences of an element x in the given array.
Note: If the number x is not found in the array then return both the indices as -1.


Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  
2 5
Explanation: 
First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 
Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  
6 6
Explanation: 
First and last occurrence of 7 is at index 6.
Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function find() that takes array arr, integer n and integer x as parameters and returns the required answer.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
1 ≤ arr[i],x ≤ 109
*/

/*
Initialize a vector ans of size 2 to store the first and last occurrence of x.
Finding the First Occurrence of x:
Initialize two pointers, left equal to 0 and right equal to n-1, to represent the search range within the array.
While left is less than or equal to right,
calculate the middle index mid = left + (right - left) / 2.
If the element at mid is equal to x, update ans[0] to mid (potential first occurrence) and move the right pointer to mid - 1 to search for the first occurrence in the left subarray.
If the element at mid is less than x, update left to mid + 1 to search on the right side.
If the element at mid is greater than x, update right to mid - 1 to search on the left side.
Finding the Last Occurrence (ans[1]):
Reinitialize the left equal to 0 and right equal to n-1 pointers to search for the last occurrence within the array.
While left is less than or equal to right,
calculate the middle index mid = left + (right - left) / 2.
If the element at mid is equal to x, update ans[1] to mid (potential last occurrence) and move the left pointer to mid + 1 to search for the last occurrence in the right subarray.
If the element at mid is less than x, update left to mid + 1 to search on the right side.
If the element at mid is greater than x, update right to mid - 1 to search on the left side.
Return the ans array.
*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
               int l=0, r=n-1, lRes=-1, rRes=-1;
        ArrayList<Integer> res=new ArrayList<>();
        
        while(l<=r){
            int mid=(l+r)/2;
            
            if(arr[mid]<x)
                l=mid+1;
            else{
                r=mid-1;
                lRes=mid;
            }
        }
        l=0;
        r=n-1;
        
        while(l<=r){
            int mid=(l+r)/2;
            
            if(arr[mid]<=x){
                l=mid+1;
                rRes=mid;
            }
            else
                r=mid-1;
        }
        if(arr[lRes]!=x || arr[rRes]!=x){
            res.add(-1);
            res.add(-1);
        }
        else{
            res.add(lRes);
            res.add(rRes);
        }
        return res;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends
