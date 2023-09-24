/*
You will be given a positive integer N. Your task is to find the smallest number greater than or equal to N that is a prime and a palindrome.
 

Example 1:

Input: N = 12
Output: 101
Example 2:

Input: N = 4
Output: 5
 

Your Task:
You don't need to read or print anything. Your task is to complete the function PrimePalindrome() which takes N as input parameter and returns the smallest number greater than equal to N that is prime and palindrome.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.PrimePalindrome(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int PrimePalindrome(int N)
    {
        //https://www.youtube.com/watch?v=hRy6OQ6JKQ4
        // code here
        while(true){
            int n=Integer.parseInt(nextPalindrome(String.valueOf(2)));
            if(prime(n))
                return n;
            else
                N=n;
        }
    }
    
    private String nextPalindrome(String s){
        int length=s.length();
        int odd=length%2;
        String center="";
        
        if(odd!=0)
            center=s.substring(length/2, (length/2)+1);
        String left=s.substring(0, length/2);
        String right = new StringBuilder(left).reverse().toString();
        String palindrome = left+center+right;
        
        if(Integer.parseInt(palindrome)>Integer.parseInt(s)){
            return palindrome;
        }
        else{
            if(!center.equals("")){
                if(Integer.parseInt(center)<Integer.parseInt("9")){
                    center=String.valueOf(Integer.parseInt(center)+1);
                    return left+center+right;
                }
                else{
                    center="0";
                }
            }
            if(allNine(left)){
                return "1"+zeroes(length-1)+"1";
            }
            else{
                left=increment(left);
                return left+center+new StringBuilder(left).reverse().toString();
            }
        }
    }
    
    private boolean allNine(String s){
        for(char i:s.toCharArray())
            if(i!='9')
                return false;
        return true;
    }
    
    private String zeroes(int len){
        StringBuilder res=new StringBuilder();
        
        while(len>0){
            res.append("0");
            len--;
        }
        return res.toString();
    }
    
    private String increment(String s){
        char ch[]=s.toCharArray();
        int last=ch.length-1;
        
        while(ch[last]=='9'){
            ch[last]='0';
            last--;
        }
        ch[last]=++ch[last];
        return new String(ch);
    }
    
    private boolean prime(int n){
        if(n == 2){
            return true;
        }else if(n == 1){
            return false;
        }else{
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
