/*
Given a list of word lists of size  M * N. The task is to return all sentences possible taking one word from a list at a time via recursion. 

Example 1:
Input:

L = {{"you", "we"},
     {"have", "are"},
Output: 
{{you have}
{you are}
{we have}
{we are}}
Explanation:
Consider every every word from the list and form
sentences with every other words, taking one word from a list .

Note: You need to maintain the order of the sentences.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function sentences() which takes a matrix of strings as input and returns a matrix of string containing all possible sentences.

Expected Time Complexity: O(MN)
Expected Auxiliary Space: O(MN)

 

Constraints:
1 <= M, N <= 6
'a' <= sentence[i][j] <= 'z'
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


class StringMatrix
{
    public static String[][] input(BufferedReader br, int n, int m) throws IOException
    {
        String[][] mat = new String[n][];
        for(int i = 0; i < n; i++)
            mat[i] = br.readLine().trim().split(" ");
        return mat;
    }
    
    public static void print(String[][] m)
    {
        for(var a : m)
        {
            for(String e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<String>> m)
    {
        for(var a : m)
        {
            for(String e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] a = IntArray.input(br, 2);
        
        
        String[][] list = StringMatrix.input(br, a[0], a[1]);
        
        Solution obj = new Solution();
        ArrayList<ArrayList<String>> res = obj.sentences(list);
        
        StringMatrix.print(res);
        
    }
}

// } Driver Code Ends


class Solution {
    static int R=0;
    static int C=0;
    
    //DFS
    public static ArrayList<ArrayList<String>> sentences(String[][] list) {
        // code here
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        R=list.length;
        C=list[0].length;
        
        //taking first ele to start depth traversal from and make it as first word of sentence
        for(int i=0; i<C; i++)
            sentence(list, 0, i, new String[R], res);
        return res;
    }
    
    private static void sentence(String[][] input, int m, int n, String[] aux, ArrayList<ArrayList<String>> res){
        //add ele to res whenever end row is reached
        if(m==input.length-1){
            aux[m]=input[m][n];
            ArrayList<String> temp = new ArrayList<>();

            temp.add(String.join("", aux));
            res.add(temp);
            return;
        }
//keep storing words in array row wise
        aux[m]=input[m][n]+" ";
        for(int i=0; i<C; i++)
        //go down to the deepest row
            if(m+1<R)
                sentence(input, m+1, i, aux, res);
    }
}

