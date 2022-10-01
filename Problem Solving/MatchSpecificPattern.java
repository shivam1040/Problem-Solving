/*
Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. Find all such words in the dictionary that match the given pattern. 

Example 1:

Input:
N = 4
dict[] = {abb,abc,xyz,xyy}
pattern  = foo
Output: abb xyy
Explanation: xyy and abb have the same
character at index 1 and 2 like the
pattern.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMatchedWords() which takes an array of strings dict[] consisting of the words in the dictionary and a string, Pattern and returns an array of strings consisting of all the words in the dict[] that match the given Pattern in lexicographical order.

Expected Time Complexity: O(N*K) (where K is the length of the pattern).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10
*/

/*
Create a character array in which we can map the characters of patterns with a corresponding character of a word.
Firstly check whether the length of word and pattern is equal or not, if no then check the next word.
If the length is equal, traverse the pattern and if the current character of the pattern has not been mapped yet, map it to the corresponding character of the word.
If the current character is mapped, then check whether the character with which it has been mapped is equal to the current character of the word.
If no then the word does not follow the given pattern.
If the word follows the pattern until the last character then print the word.
*/

//{ Driver Code Starts
import java.util.*;
public class MSP
{	
    public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-- != 0)
		{
			int n=sc.nextInt();
			ArrayList<String> s = new ArrayList<String>(n);
			for (int i=0;i<n;i++)
			    s.add(sc.next());
			String tt;
			tt=sc.next();
			GfG g=new GfG();
			ArrayList<String> res =g.findMatchedWords(s, tt);
			Collections.sort(res);
			for (int i = 0;i < res.size();i++)
			    System.out.print(res.get(i)+" ");
			System.out.println();

		}
	}
}
// } Driver Code Ends


/*Complete the provided function*/

class GfG
{
/* The function returns an array of strings 
present in the dictionary which matches
the string pattern.
You are required to complete this method */
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    //add code here.
	    ArrayList<String> res=new ArrayList<>();
	    
	    for(String i: dict){
	        Map<Character, Character> aux=process(i, pattern);
	        if(aux.size()>0)
	            res.add(i);        
	    }
	    return res;
	}

public static Map<Character, Character> process(String dic, String patt){
    Map<Character, Character> aux=new HashMap<>();
    if(dic.length()!=patt.length())
        return aux;
    for(int i=0; i<dic.length(); i++){
        char d=dic.charAt(i);
        char p=patt.charAt(i);
        if(aux.containsKey(p) && aux.get(p)!=d){
            aux=new HashMap<>();
            return aux;
        }
        aux.put(p, d);
    }
    return aux;
}

}
