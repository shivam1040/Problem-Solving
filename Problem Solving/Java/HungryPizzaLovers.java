/*
Dominos Pizza has hungry customers waiting in the queue. Each unique order is placed by a customer at time x[i], and the order takes y[i] units of time to complete.
You have information on all n orders, Find the order in which all customers will receive their pizza and return it. If two or more orders are completed at the same time then sort them by non-decreasing order number.

Example 1:

Input : arr[ ] = {{4,1}, {6,2}, {7,6}, 
                       {8,1}, {1,3}}
Output : 5 1 2 4 3
Explanation:
Here an array can be transform to 
{5, 8, 13, 9, 4}. Here 5th index order 
received first then 1st order, 2nd order...
return {5, 1, 2, 4, 3}

Example 2:

Input : arr[ ] = {{1,1}, {1,1}, {1,1}} 
Output :  1 2 3 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function permute() that takes 2-d array (arr), sizeOfArray (n), and return the array of order in which customers will receive their pizza. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i][0], arr[i][1] ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [][] = new int[sizeOfArray][2];
		    
		    for(int i = 0;i<sizeOfArray;i++){
    		    line = br.readLine();
    		    String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.permute(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.println(i);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Pair{
    int index;
    int sum;
    
    Pair(int index, int sum){
        this.index=index;
        this.sum=sum;
    }
    
    @Override
    public String toString() {
        return this.index+" "+this.sum;
    }
}

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> permute (int arr[][], int n) {
        //Complete the function
        
        ArrayList<Pair> aux=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i=0; i<n; i++)
            aux.add(new Pair(i+1, arr[i][0]+arr[i][1]));
        
        Collections.sort(aux, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        
        for(Pair i:aux)
            res.add(i.index);
        
        return res;
    }
    
    
}



