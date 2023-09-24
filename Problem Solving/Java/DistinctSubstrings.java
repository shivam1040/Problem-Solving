/*
//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.fun(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int fun(String s) 
    {
        // code here
        int count=0;
        Set<String> aux=new HashSet<>();
        
        for(int i=0; i<s.length()-1; i++){
            aux.add(s.substring(i, i+2));
            }
        
        return aux.size();
    }
} 
*/

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.fun(s);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int fun(String s) 
    {
        // code here
        int count=0;
        Set<String> aux=new HashSet<>();
        
        for(int i=0; i<s.length()-1; i++){
            aux.add(s.substring(i, i+2));
            }
        
        return aux.size();
    }
} 
