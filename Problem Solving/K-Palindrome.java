/*
A string is k palindrome if it can be transformed into a palindrome on removing at most k characters from it. Your task is to complete the function is_k_palin which takes two arguments a string str and a number N . Your function should return true if the string is k palindrome else it should return false.

Input:
The first line of input is an integer T denoting the number of test cases . Then T test cases follow . Each test case  contains a string str and an integer N separated by space.  

Output:
The output will be 1 if the string is  k palindrome else 0 .

Constraints:
1<=T<=100
1<=length of str<=100
1<=N<=20

Example:
Input
2
abcdecba 1
acdcb  1
Output
1
0
*/

//{ Driver Code Starts
import java.util.*;


class Remove_Duplicate_From_String
{
	public static void main(String args[])
	{
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str1 = sc.nextLine();
			String arr[] = str1.split(" ");
			//String str1 = sc.nextLine();
			//sc.skip("\\s*");
			String str = arr[arr.length-2];
			int K = Integer.parseInt(arr[arr.length-1]);
			
			//int K = Integer.parseInt( sc )
			//sc.nextLine();
			//sc.nextInt();
			
			
			//GfG g = new GfG();
			//System.out.println(str);
			//System.out.println(K);
			//System.out.println(new GfG().is_k_palin(str, K));

                       boolean b = new GfG().is_k_palin(str, K);
			if(b == true)
				System.out.println(1);
			else
				System.out.println(0);
			
			
		T--;
		}
	}
}
// } Driver Code Ends


class GfG
{
    boolean is_k_palin(String str, int k)
    {
	// Your code here
	return str.length()-LongestSubsequence(str) <=k ? true : false;
    }
    
    //finding lps between reverse and original given condition character at check index should be equal, logically longest subs will have minimum number of deletion 
    public int LongestSubsequence(String str)
    {
        StringBuilder revStr = new StringBuilder(str);
        revStr = revStr.reverse();
        String rev=revStr.toString();
        int prev;
        int curr[]=new int[str.length()+1];
        for(int i=1; i<=str.length(); i++){
            prev=0;
            for(int j=1; j<=str.length(); j++){
                 int prev1=curr[j];
                if(str.charAt(i-1)==rev.charAt(j-1)){
                   curr[j]=1+prev;
                }
                else{
                    curr[j]=Math.max(curr[j], curr[j-1]);
                }
                prev=prev1;
            }
        }
         return curr[str.length()];   
    }
}

