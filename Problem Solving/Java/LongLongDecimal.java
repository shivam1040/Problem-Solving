/*
You are simply given two numbers 355 and 113. You just have to find the value of 355/113 upto the decimal  k places . 
 

Example 1:

Input: k = 0
Output: 3
Explanation: 355/113 upto 0 decimal place is 3
Example 2:

Input: k = 1
Outptut: 3.1
Explanation: 355/113 upto 1 decimal place is 3.1
 

Your Task:
You don't need to read or print anything. Your task is to complete the function upto_K_places() which takes k as input parameter and returns 355/113 upto k decimal places in string format.

Expected Time Complexity: O(k)
Expected Space Complexity: O(1)
 

Constraints: 
1 <= k <= 10000
*/

/*
We start with two integers: numerator (355) and denominator (113), representing the numerator and denominator of the fraction, respectively.

We first calculate the integer part of the fraction by performing an integer division: int integerPart = numerator / denominator;. This gives us the whole number part of the result.

We then initialize a StringBuilder called fractionalPart to build the fractional part of the result.

To calculate the fractional part, we take the modulus (numerator %= denominator) to get the remainder after dividing the numerator by the denominator. This remainder represents the initial fractional part.

Next, we enter a loop that runs k times (specified by the k parameter). In each iteration of the loop:

a. We multiply the numerator by 10 to bring the next decimal place into consideration.

b. We calculate the current decimal digit by performing an integer division: int digit = numerator / denominator;. This digit is then added to the fractionalPart.

c. We update the numerator to be the remainder after division: numerator %= denominator. This keeps the process going for the next decimal place.

Finally, we return the result as a string by concatenating the integer part and the fractionalPart.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.upto_K_places(k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String upto_K_places(int k)
    {
        // code here
        int numerator = 355;
        int denominator = 113;

        // Calculate the integer part
        int integerPart = numerator / denominator;

        // Calculate the fractional part
        StringBuilder res=new StringBuilder(".");
        numerator%=denominator;
        
        for(int i=0; i<k; i++){
            numerator*=10;
            int dec=numerator/denominator;
            res.append(dec);
            numerator%=denominator;
        }
        if(k<=0)
            return integerPart+"";
        return integerPart+res.toString();
    }
}
