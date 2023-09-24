/*
Given a string with repeated characters, the task is to complete the function rearrangeString which rearrange characters in a string so that no two adjacent characters are same.
Note : It may be assumed that the string has only lowercase English alphabets and such transformation is always always possible.

Example 1:

Input:
S = aaabc
Output: 1
Explanation: We can transform the string
to abaca.
Example 2:

Input:
S = aaabb
Output: 1
Explanation: We can transform the string
to ababa.
 

Your Task:
Complete the function rearrangeString() which takes a string as an input parameter and returns the rearranged string. (The output will be 1 if the returned string has no adjacent character same, otherwise 0. Printing is done by the driver's code.)

Expected Time Complexity: O(N * log N), N = length of the string.
Expected Auxiliary Space: O(constant)

Constraints:
1< N < 105
*/

/*
Fill all the even positions of the result string first, with the highest frequency character. If there are still some even positions remaining, fill them first. Once even positions are done, then fill the odd positions. This way, it can be ensured that no two adjacent characters are the same. 

Follow the given steps to solve the problem:

Calculate the frequencies of every character in the input string
If a character with a maximum frequency has a frequency greater than (n + 1) / 2, then return an empty string, as it is not possible to construct a string
Now fill the even index positions with the maximum frequency character, if some even positions are remaining then first fill them with remaining characters
Then fill odd index positions with the remaining characters
Return the constructed string
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Rearrange
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            
            int old = str.length();
            int chs[] = new int[26];
            Arrays.fill(chs, 0);
            
            for(int i=0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                if(idx>=0&&idx<26)
                chs[idx]++;
            }
            Solution gfg = new Solution();     
            str = gfg.rearrangeString(str);
            int flag=1,ff=0;
            int chs2[] = new int[26];
            Arrays.fill(chs2, 0);
	        
	        for(int i=0;i<str.length();i++){
	            int idx = str.charAt(i)-'a';
                if(idx>=0&&idx<26)
	            chs2[idx]++;
	        }
	             
	        if(str.length() != old)
	         System.out.println(0);
	        else
	        {
	            
    	        for(int i=0;i<26;i++)
                    if(chs[i] != chs2[i])
                        ff=1;
                
                if(ff==1){
                        System.out.println(0);
                }
                else{
        	        if(str != "-1"){
                    	for(int i=1;i<str.length();i++)
                    	{
                    		if(str.charAt(i-1) == str.charAt(i))
                    			flag=0;
                    	}
                    	if(flag == 1)
                    		System.out.println(1);
                    	else
                    	System.out.println(0 );
                    }
    	            else
    	            	System.out.println(0);
                }
            }
        }
    }
}
// } Driver Code Ends


/* The below function should return 
the transformed string */
class Solution
{
    
    static char getMaxCountChar(int[] count)
    {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)((int)'a' + i);
            }
        }
        return ch;
    }
   
   public static String rearrangeString(String S)
   {
              int N = S.length();
 
        int[] count = new int[26];
    
        for (char ch : S.toCharArray()) {
            count[(int)ch - (int)'a']++;
        }
 
        char ch_max = getMaxCountChar(count);
        int maxCount = count[(int)ch_max - (int)'a'];
 
 
        //String res = "";
           StringBuffer res = new StringBuffer();
        for (int i = 0; i < N; i++) {
            res.append(" ");
        }
 
        int ind = 0;
        // filling the most frequently occurring char in the
        // even indices
        while (maxCount > 0) {
            // res = res.substring(0, ind) + ch_max
            //       + res.substring(ind + 1);
            res=res.replace(ind, ind+1, ""+ch_max);
            ind = ind + 2;
            maxCount--;
        }
        count[(int)ch_max - (int)'a'] = 0;
 
        // now filling the other Chars, first filling the
        // even positions and then the odd positions
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                //this takes care of filling odd positions, changes to 1 when ind overflows and increments are always odd for odd number with even number
                ind = (ind >= N) ? 1 : ind;
                // res = res.substring(0, ind)
                //       + (char)((int)'a' + i)
                //       + res.substring(ind + 1);
                res=res.replace(ind, ind+1, ""+(char)((int)'a' + i));
                ind += 2;
                count[i]--;
            }
            
        }
        //System.out.println(res.toString());
        return res.toString();
   }
}

