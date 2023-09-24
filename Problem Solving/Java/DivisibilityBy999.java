/*
You are given a large number N in the form of a string, you have to check whether it is divisible by 999 without dividing or finding modulo of number by 999.

 

Example 1-

Input:
N = 1998
Output:
Divisible
 

Example 2 -

Input:
N = 99999999
Output:
Not divisible
 

Your Task :
Complete the function isDivisible999() that receives a string N denoting number and returns true if the n is divisible by 999 and flse otherwise. The driver code itself prints "Divisible" if the returned value is true and returns "Non Divisible" if returned value is false.

 

Expected Time Complexity : O(len(N))
Expected Space Complexity : O(1)

 

Constraints:
1<=|N|<=103
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String N = sc.next();
                    Solution obj = new Solution();
                    
                    if(obj.isDivisible999(N))
                        System.out.println("Divisible");
                    
                    else
                        System.out.println("Not divisible");
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    boolean isDivisible999(String n)
    {
        //code here
        int l=n.length();
        
        if(l==0)
            return true;
        if(l%3==1)
            n="00"+n;
        else if(l%3==2)
            n="0"+n;
        
        int sum=0;
        
 //the basic idea is to group sum of 3 char each       for(int i=0; i<l; i++){
            int temp=0;
            temp+=(n.charAt(i++)-'0')*100;
            temp+=(n.charAt(i++)-'0')*10;
            temp+=n.charAt(i)-'0';
            sum+=temp;
        }
        
        return sum==999;
    }
}
