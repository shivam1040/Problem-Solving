/*
Given two strings s1 and s2. The task is to check if s2 is a rotated version of the string s1. The characters in the strings are in lowercase.

 

Example 1:

Input:
geeksforgeeks
forgeeksgeeks
Output: 
1
Explanation: s1 is geeksforgeeks, s2 is
forgeeksgeeks. Clearly, s2 is a rotated
version of s1 as s2 can be obtained by
left-rotating s1 by 5 units.
 

Example 2:

Input:
mightandmagic
andmagicmigth
Output: 
0
Explanation: Here with any amount of
rotation s2 can't be obtained by s1.
 

Your Task:
The task is to complete the function areRotations() which checks if the two strings are rotations of each other. The function returns true if string 1 can be obtained by rotating string 2, else it returns false.

 

Expected Time Complexity: O(N).
Expected Space Complexity: O(N).
Note: N = |s1|.

 

Constraints:
1 <= |s1|, |s2| <= 107
*/
/*
do s1=s1+s1;
then using kmp find if s2 exists in s1or not
*/
// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG {
        
        public static void main (String[] args)throws IOException{
            
            //taking input using BufferedReader class
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            //taking total count of testcases
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
            {
                //Reading the two Strings
                String s1 = br.readLine();
                String s2 = br.readLine();
                
                //Creating an object of class Rotate
                Solution obj = new Solution();
                
                //calling areRotations method 
                //of class Rotate and printing
                //"1" if it returns true
                //else "0"
                if(obj.areRotations(s1,s2))
                {
                    System.out.println("1");
                }
                else
                {
                    System.out.println("0");
                }
            }
        }
    }// } Driver Code Ends
    
    
    
    class Solution
    {
        //Function to check if two strings are rotations of each other or not.
        public static boolean areRotations(String s1, String s2 )
        {
            String pat=s2;
            String txt=s1+s1;
            
            int M = pat.length();
            int N = txt.length();
            
            if(s1.length()!=s2.length())
                return false;
            
      
            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int j = 0; // index for pat[]
      
            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat, M, lps);
      
            int i = 0; // index for txt[]
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                    
                    //System.out.println("Found pattern " + "at index " + (i - j));
                    j = lps[j - 1];
                    return true;
                }
      
                // mismatch after j matches
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
            return false;
        }
        
      
        static void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0
      
            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (len != 0) {
                        len = lps[len - 1];
      
                        // Also, note that we do not increment
                        // i here
                    }
                    else // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }
        
    }