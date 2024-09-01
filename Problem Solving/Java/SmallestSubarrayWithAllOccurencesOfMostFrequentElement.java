/*
Given an array A. Let X be an element in the array which has the maximum frequency. The task is to find the smallest sub segment of the array which also has X as the maximum frequency element.

Note: if two or more elements have the same frequency (i.e., maximum frequency) and the same sub segment size then print the sub segment which occurs first in the array.

 

Example 1:
 

Input : A[] = {1, 2, 2, 3, 1}
Output : 2 2
Explanation:
Note that there are two elements that appear two times,
1 and 2.The smallest window for 1 is whole array and
smallest window for 2 is {2, 2}.
Since window for 2 is smaller, this is our output.
Example 2:

Input : A[] = {1, 4, 3, 3, 5, 5} 
Output : 3 3 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function smallestSubsegment() that takes an array (arr), sizeOfArray (n), and return the required sub-segment of the array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 

 

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer, int[]> aux=new HashMap<>();
        int max=0;
        
        //getting max freq ele and saving their starting ending pos with freq
        for(int i=0; i<n; i++){
            if(!aux.containsKey(a[i])){
                int temp[]=new int[]{1, i, i};
                aux.put(a[i], temp);
            }
            else{
                int temp[]=aux.get(a[i]);
                temp[0]++;
                temp[2]=i;
                
                aux.put(a[i], temp);
            }
            max=Math.max(max, aux.get(a[i])[0]);
        }
        
        int minSubLength=Integer.MAX_VALUE, maxFreq=0, pos=0;
        
        //finding smallest range has for max number of frq for a given ele
        for(Map.Entry<Integer, int[]> i:aux.entrySet()){
            int temp[]=i.getValue();
            
            if(temp[0]==max){
                    int temp1=temp[2]-temp[1];
                    
                    if(temp1<minSubLength){
                        minSubLength=temp1;
                        maxFreq=i.getKey();
                        pos=temp[1];
                    }
                    else if(temp1==minSubLength && temp[1]<pos){
                        maxFreq=i.getKey();
                        pos=temp[1];
                    }
                }
        }
        for(int i=aux.get(maxFreq)[1]; i<=aux.get(maxFreq)[2]; i++)
            res.add(a[i]);
        return res;
    }
  
    
}

//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		    
		    
		}
	}
}


            


// } Driver Code Ends
