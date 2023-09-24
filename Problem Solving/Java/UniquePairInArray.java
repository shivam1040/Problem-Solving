/*
Given an array where every element appears twice except a pair (two elements). return the elements of this unique pair in sorted order.

 

Example 1:

Input : Arr[] = {2, 2, 5, 5, 6, 7}
Output : 6 7
Explanation:
We can see we have [2, 2, 5, 5, 6, 7]. 
Here 2 and 5 are coming two times. 
So, the answer will be 6 7.

Example 2:

Input : Arr[] = {1, 3, 4, 1}
Output : 3 4


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function findUniquePair() that takes an array (arr), sizeOfArray (n) and return the unique pair's element in increasing order. The driver code takes care of the printing.

 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 107


*/

/*
 XOR each element of the array and you will left with the XOR of two different elements which are going to be our result. Let this XOR be “XOR” 
Now find a set bit in XOR. 
Now divide array elements in two groups. One group that has the bit found in step 2 as set and other group that has the bit as 0. 
XOR of elements present in first group would be our first element. And XOR of elements present in second group would be our second element. 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n+1];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> v;
            v = obj.findUniquePair(a,n) ;
            System.out.println(v.get(0) + " " + v.get(1));
        }
        
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    public ArrayList<Integer> findUniquePair(int arr[],int n){
        
        // Complete the function
        // Map<Integer, Integer> aux=new LinkedHashMap<>();
        // ArrayList<Integer> res=new ArrayList<>();
        // int a=0, b=0;
        
        // for(int i:arr)
        //     aux.put(i, aux.getOrDefault(i, 0)+1);
        // for(Map.Entry<Integer, Integer> i:aux.entrySet()){
        //     if(i.getValue()==1)
        //         res.add(i.getKey());
        // }
        // if(res.get(0)>res.get(1)){
        //     int temp=res.get(1);
            
        //     res.set(1, res.get(0));
        //     res.set(0, temp);
        // }
        // return res;
        
        int xor=0, a=0, b=0;
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i:arr)
            xor^=i;
            
        int rightMostSet=xor&~(xor-1);
        
        for(int i:arr)
            if((rightMostSet & i)>0)
                a=a^i;
            else
                b^=i;
        if(a>b){
            res.add(b);
            res.add(a);
        }
        else{
            res.add(a);
            res.add(b);
        }
        return res;
    }
    }    


