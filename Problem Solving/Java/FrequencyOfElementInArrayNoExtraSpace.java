/*
Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all elements from 1 to N.
Note: The elements greater than N in the array can be ignored for counting.


Example 1:

Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation: 
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
Example 2:

Input:
N = 4
arr[] = {3,3,3,3}
P = 3
Output:
0 0 4 0
Explanation: 
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 0 times.
3 occurring 4 times.
4 occurring 0 times.

Your Task:
Complete the function frequencycount() that takes the array and n as input parameters and modify the array in place to denote the frequency count of each element from 1 to N. i,e element at index 0 should represent the frequency of 1 and so on.


Note: Can you solve this problem without using extra space (O(1) Space) !


Constraints:
1 ≤ N ≤ 105
1 ≤ P ≤ 4*104 
1 <= A[i] <= P
*/

/*
The idea is to traverse the given array, use elements as an index and store their counts at the index. Consider the basic approach, a Hashmap of size n is needed and the array is also of size n. So the array can be used as a hashmap, all the elements of the array are from 1 to n, i.e. all are positive elements. So the frequency can be stored as negative. This might lead to a problem. Let i-th element be a then the count should be stored at array[a-1], but when the frequency will be stored the element will be lost. To deal with this problem, first, replace the ith element by array[a-1] and then put -1 at array[a-1]. So our idea is to replace the element by frequency and store the element in the current index and if the element at array[a-1] is already negative, then it is already replaced by a frequency so decrement array[a-1].
Traverse the array from start to end.
For each element check if the element is less than or equal to zero or not. If negative or zero skip the element as it is frequency.
If an element (e = array[i] – 1 ) is positive, then check if array[e] is positive or not. If positive then that means it is the first occurrence of e in the array and replace array[i] with array[e], i.earray[i] = array[e] and assign array[e] = -1. If array[e] is negative, then it is not the first occurrence, the update array[e] as array[e]– and update array[i] as array[i] = 0.
Again, traverse the array and print i+1 as value and array[i] as frequency.
Implementation:
*/


// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            //testcases
            int t = Integer.parseInt(br.readLine().trim()); 
            while(t-->0){
                
                //size of array
                int N = Integer.parseInt(br.readLine().trim()); 
                int arr[] = new int[N];
                String inputLine[] = br.readLine().trim().split(" ");
    
                //adding elements to the array
                for(int i = 0 ; i < N; i++){
                    arr[i]=Integer.parseInt(inputLine[i]); 
                }
                int P= Integer.parseInt(br.readLine().trim());
                //calling frequncycount() function
                Solution ob = new Solution();
                ob.frequencyCount(arr, N, P); 
                
                //printing array elements
                for(int i = 0; i < N ; i++)
                    System.out.print(arr[i] + " " );
                System.out.println();
            }
        }
    }
    
    
    
    // } Driver Code Ends
    
    
    class Solution{
        //Function to count the frequency of all elements from 1 to N in the array.
        public static void frequencyCount(int arr[], int N, int P)
        {
             int expectedpos, pos=0;
           
           while(pos<N)
           {
               
               if(arr[pos]<=N)
               {
                   
               
               expectedpos=arr[pos]-1;
               
               if(arr[pos]>0  &&  arr[expectedpos]>0)
               {
                   arr[pos]=arr[expectedpos];
                   arr[expectedpos]=-1;
               }
               else if(arr[pos]>0)
               {
                   arr[expectedpos]--;
                   arr[pos++]=0;
                   
               }
               else
               {      
               pos++;      
               }         
              }
              else
              {
              // System.out.println(arr[pos]);
               arr[pos++]=0;      
              }
           }
            
            
            for(int j=0; j<arr.length; j++){
                arr[j]=Math.abs(arr[j]);
            }
            
            
        }
    }
    