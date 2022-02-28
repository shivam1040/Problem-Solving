package com.capgemini.assignment5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class IdentifyPatterns {
	
	  static int KMPSearch(String pat, String txt)
	    {
	        int M = pat.length();
	        int N = txt.length();
	 
	        // create lps[] that will hold the longest
	        // prefix suffix values for pattern
	        int lps[] = new int[M];
	        int j = 0; // index for pat[]
	 
	        // Preprocess the pattern (calculate lps[]
	        // array)
	        computeLPSArray(pat,M,lps);
	 
	        int i = 0; // index for txt[]
	        int res = 0;
	        int next_i = 0;
	         
	        while (i < N)
	        {
	            if (pat.charAt(j) == txt.charAt(i))
	            {
	                j++;
	                i++;
	            }
	            if (j == M)
	            {
	                // When we find pattern first time,
	                // we iterate again to check if there
	                // exists more pattern
	                j = lps[j-1];
	                res++;
	 
	                // We start i to check for more than once
	                // appearance of pattern, we will reset i
	                // to previous start+1
	                if (lps[j]!=0)
	                    i = ++next_i;
	                j = 0;
	            }
	 
	            // mismatch after j matches
	            else if (i < N && pat.charAt(j) != txt.charAt(i))
	            {
	                // Do not match lps[0..lps[j-1]] characters,
	                // they will match anyway
	                if (j != 0)
	                    j = lps[j-1];
	                else
	                    i = i+1;
	            }
	        }
	        return res;
	    }
	 
	    static void computeLPSArray(String pat, int M, int lps[])
	    {
	        // length of the previous longest prefix suffix
	        int len = 0;
	        int i = 1;
	        lps[0] = 0; // lps[0] is always 0
	 
	        // the loop calculates lps[i] for i = 1 to M-1
	        while (i < M)
	        {
	            if (pat.charAt(i) == pat.charAt(len))
	            {
	                len++;
	                lps[i] = len;
	                i++;
	            }
	            else // (pat[i] != pat[len])
	            {
	                // This is tricky. Consider the example.
	                // AAACAAAA and i = 7. The idea is similar
	                // to search step.
	                if (len != 0)
	                {
	                    len = lps[len-1];
	 
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
	    
	public static void main(String args[]) {
		File fileObj = new File(".\\src\\main\\java\\com\\capgemini\\assignment5\\IdentifyPatterns.txt");
		try {
			BufferedReader brObj= new BufferedReader(new FileReader(fileObj));
			String temp="";
			String temp1;
			while((temp1=brObj.readLine())!=null)
				temp+=temp1;
			brObj=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter number of words");
			String searchString[]=new String[Integer.parseInt(brObj.readLine())];
			for(int i=0; i<searchString.length; i++) {
				if(i==0)
					System.out.println("Enter the strings to be searched");
				searchString[i]=brObj.readLine();
			}
			System.out.println();
			System.out.println("Given string is "+temp);
			for(String i:searchString)
				System.out.println("Word:"+i+" Count:"+KMPSearch(i, temp));
			brObj.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
}
