/*
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....

If there are multiple solutions, find the lexicographically smallest one.

Example 1:

Input:
n = 5
arr[] = {1,2,3,4,5}
Output: 2 1 4 3 5
Explanation: Array elements after 
sorting it in wave form are 
2 1 4 3 5.
Example 2:

Input:
n = 6
arr[] = {2,4,7,8,9,10}
Output: 4 2 8 7 10 9
Explanation: Array elements after 
sorting it in wave form are 
4 2 8 7 10 9.
Your Task:
The task is to complete the function convertToWave(), which converts the given array to a wave array.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ n ≤ 106
0 ≤ arr[i] ≤107
*/
// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
            
            while(t-->0)
            {
                int n = Integer.parseInt(br.readLine().trim());// taking size of array
                int arr[] = new int[n]; // declaring array of size n
                String inputLine[] = br.readLine().trim().split(" ");
                for(int i=0; i<n; i++){
                    arr[i]=Integer.parseInt(inputLine[i]); // input elements of array
                }
                
                Solution obj = new Solution();
                
                
                obj.convertToWave(arr, n);
                
                StringBuffer sb = new StringBuffer(); 
                for (int i = 0; i < n; i++) 
                    sb.append(arr[i] + " "); 
                    
                System.out.println(sb); // print array
            }
        }
    }
    
    
     // } Driver Code Ends
    class Solution{
    
        
        // arr: input array
        // n: size of the array
        //Function to sort the array into a wave-like array.
        public static void convertToWave(int arr[], int n){
            
            int first=0;
            int second=1;
            for(int i=0; i<n/2; i++){
                int temp=arr[first];
                arr[first]=arr[second];
                arr[second]=temp;
                first+=2;
                second+=2;
            }
            
        }
        
    }
    
    
    // { Driver Code Starts.
      // } Driver Code Ends