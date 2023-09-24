/*
Given two given numbers a and b where 1<= a <= b, find the perfect cubes between a and b (a and b inclusive).

Example 1:

Input: a = 1, b = 100
Output: 1 8 27 64
Explaination: These are the proper cubes between 
1 and 100.
Example 2:

Input: a = 24, b = 576
Output: 27 64 125 216 343 512
Explaination: These are the proper cubes between 
24 and 576.
Your Task:
You do not need to read input or print anything. Your task is to complete the function properCubes() which takes a and b as input parameters and returns the proper cubes between a and b. The function returns -1 if there is no proper cube between the given values.

Expected Time Complexity: O(cuberoot(b))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ a ≤ b ≤ 104 
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.properCubes(a, b);
            if(ans.get(0) == -1)
                System.out.println("No");
            else{
                StringBuilder out = new StringBuilder();
                for(int i = 0;i < ans.size();i++)
                    out.append(ans.get(i)+" ");
                System.out.println(out);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> properCubes(int a, int b)
    {
        // code here
        int aa=(int)Math.cbrt(a);
        int bb=(int)Math.cbrt(b);
        List<Integer> res=new ArrayList<>();
        
        //basic idea is to find the cube root and then find all the cubes between them
        for(int i=aa; i<=bb; i++){
            int temp=i*i*i;
            
            if(temp>=a && temp<=b)
                res.add(temp);
        }
        
        return res;
    }
}
