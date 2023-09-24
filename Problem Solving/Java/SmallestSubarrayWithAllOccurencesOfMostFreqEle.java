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

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Pair{
        int fre; //frqeuency
        int s; //start index
        int e; //end index
        Pair(int fre,int fi,int li){
            this.fre=fre;
            this.s=fi;
            this.e=li;
        }
     }
     
class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        Map<Integer, Pair> fMap=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        int maxF=0;
        int s=0;
        int e=0;
        int l=0;
        //youtube.com/watch?v=KMDQ1jDZ5i8
        //putting first element in
        fMap.put(a[0], new Pair(1, 0, 0));
        
        for(int i=1; i<n; i++){
            if(fMap.containsKey(a[i])){
                Pair temp=fMap.get(a[i]);
                temp.fre++;
                temp.e=i; //updating end index
                int lTemp=temp.e-temp.s+1; //temp length of subarray
                // freq from map is more than current max freq
                if(temp.fre>maxF){
                    maxF=temp.fre;
                    l=lTemp;
                    s=temp.s;
                    e=i;
                }
                // if freq equal and length from map is lower than current l
                else if(temp.fre==maxF && lTemp<l){
                    s=temp.s;
                    e=i;
                    l=lTemp;
                }
                // if everything is equal but map index is before current index (as per condition in question)
                else if(temp.fre==maxF && l==lTemp && temp.s<s){
                    maxF=temp.fre;
                    s=temp.s;
                    e=i;
                }
            }
            else
                fMap.put(a[i], new Pair(1, i, i));
        }
        for(int i=s; i<=e; i++)
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
