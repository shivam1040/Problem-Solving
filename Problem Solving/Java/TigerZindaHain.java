/*
Rohan is downloading the movie Tiger Zinda Hai using a torrent website, but he is new to torrent, so he doesn't know the difference between a fake download button and a real download button; therefore, he keeps pressing every button in excitement.
Now he has clicked N  buttons, and many tabs are opened, if an opened tab is clicked again then it closes it. 
Your task is to tell how many tabs are open at the end.

Example 1:

Input : Arr[] = {"1", "2", "1", "END", "2"}
Output : 1
Explanation:
In the above test case, firstly tab 
1st is opened then 2nd is opened then 
1st is closed then all are closed
then again 2nd is opened.

Example 2:

Input : Arr[] = {"1", "2", "END"}
Output : 0

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function count_tabs() that takes an array of String (arr), sizeOfArray (n), and return how many tabs are open at the end. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 

Constraints:

1 ≤ N ≤ 105
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
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
		    
		    String arr [] = new String[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = elements[i];
		    }
		    
		    
		    Solution obj = new Solution();
		    int res = obj.count_tabs(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


//User function Template for Java


class Solution{
   
    // Function for finding maximum and value pair
    public static int count_tabs (String arr[], int n) {
        //Complete the function
        
        Map<String, Integer> aux=new HashMap<>();
        
        for(String i:arr){
            if(i.equals("END")){
                aux.clear();
            }
            else if(aux.containsKey(i)){
                aux.remove(i);
            }
            else
                aux.put(i, 0);
        }
        
        return aux.size();
    }
    
    
}



