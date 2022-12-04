/*
Given a string str your task is to complete the function spaceString which takes only one argument the string str and  finds all possible strings that can be made by placing spaces (zero or one) in between them. 

For eg .  for the string abc all valid strings will be
                abc
                ab c
                a bc
                a b c

Example 1:

Input:
str = abc
Output: abc$ab c$a bc$a b c$
Example 2:

Input:
str = xy
Output: xy$x y$

Your Task:
Complete the function spaceString() which takes a character array as an input parameter and returns list of all possible answers in lexographically reverse order(largest String first then smaller). The driver code will print the all possible answer '$' separated.

Expected Time Complexity: O(N * 2N)
Expected Auxiliary Space: O(N)


Constraints:
1<= length of string str <=10

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
*/

//{ Driver Code Starts
import java.util.*;


class Find_All_Possible_Strings
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =  sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			GfG g = new GfG();
			ArrayList<String> arr = g.spaceString(str);
			for(String s : arr){
			    System.out.print(s+"$");
			}
            System.out.println();
			t--;
		}
	}
}
// } Driver Code Ends


/*You have to complete this function*/
class GfG
{
    ArrayList<String> spaceString(String str)
    {
        // Your code here
        ArrayList<String> res=new ArrayList<>();
        
        sp(""+str.charAt(0), str.substring(1), res);
        return res;
    }
    
    private void sp(String output, String input, ArrayList<String> res){
        if(input.length()==0){
            res.add(output);
            return;
        }
        //with space
        String output1=output+" "+input.charAt(0);
        //without space
        String output2=output+input.charAt(0);
        
        //taking from new character everytime
        input=input.substring(1);
        //recursing every possibility for new input
        sp(output2, input, res);
        sp(output1, input, res);
    }
}

