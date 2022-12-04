/*
Given a function that takes a binary string. The task is to return the longest size of contiguous substring containing only ‘1’.

Input:
The first line of input contains an integer T denoting the no of test cases.Then T test cases follow. Each test case contains a string S.

Output:
For each test case return the maximum length of required sub string.

Constraints: 
1<=T<=100
1<=|string length|<=104

Example:
Input:
2
110
11101110
Output:
2
3
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    String s=br.readLine();
		    GfG g=new GfG();
		    int len=g.count(s);
		    System.out.println(len);
		}
	}
}

// } Driver Code Ends


/*Complete the function below*/
class GfG{
    public int count(String S)
    {
        //add code here.
        String test="";
        int res=-1, temp=0;
        for(char c:S.toCharArray()){
            String current=String.valueOf(c);
            //just increment temp when 1 is contiguous as soon as character in string is not one change temp to zero
            if(current.equals("1"))
                temp++;
            if(temp>res)
                res=temp;
            if(current.equals("0"))
                temp=0;
        }
        return res;
    }
}
