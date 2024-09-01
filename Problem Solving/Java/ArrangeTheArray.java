/*
Given an array of n integers rearrange the values of the array so as to maximize the worth of the array.Worth of an array a is defined as a(n)^(a(n-1)^a(n-2)........(a(1))).You need to print the rearrangement. If multiple answers are possible print the lexicographically largest one.

Example 1:

Input:
N=2
a[]={2,3}
Output:
a[]={2,3}
Explanation:
Since in total 2 permutations are possible {2,3} and
{3,2} the former one has a value of 9 while the latter
one has 8 hence the answer is the former permutation.
 

Example 2:

Input:
N=3
a[]={1,1,1}
Output:
a[]={1,1,1}
Explanation:
All permutations will yield the same result.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the array arr[], its size N, and returns the rearranged array.

 

Expected Time Complexity: O(NLogN)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
Array may contain duplicate elements.
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.rearrange(n, arr);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> rearrange(int n, int[] a) {
        // code here
        Arrays.sort(a);
        int i=0;
        var res = Arrays.stream(a)
                .boxed()
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        
        while(i<n && a[i]==1)
            i++;
        if(n-i==2 && a[i]==2 && a[i+1]==3)
            return res;
        else if(i==n)
            return res;
        reverseArray(a, i);
        return Arrays.stream(a)
                .boxed()
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
    }
    
        private static void reverseArray(int[] array, int start) {
        int end = array.length - 1;
        while (start < end) {
            // Swap elements at start and end indices
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            // Move towards the center
            start++;
            end--;
        }
    }
}
        

