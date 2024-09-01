/*
Given two numbers as strings s1 and s2. Calculate their Product.

Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.

Example 1:

Input:
s1 = "0033"
s2 = "2"
Output:
66
Example 2:

Input:
s1 = "11"
s2 = "23"
Output:
253
Your Task: You don't need to read input or print anything. Your task is to complete the function multiplyStrings() which takes two strings s1 and s2 as input and returns their product as a string.

Expected Time Complexity: O(n1* n2)
Expected Auxiliary Space: O(n1 + n2); where n1 and n2 are sizes of strings s1 and s2 respectively.

Constraints:
1 ≤ length of s1 and s2 ≤ 103
*/

/*
Intuition
The overall intuition is to simulate the manual multiplication process using string manipulation and integer arithmetic, while considering the signs of the input numbers and properly handling carries. This approach allows for multiplication of large integers that might not fit within the limits of built-in numeric data types.

Implementation
 Handling Zeroes:
 return 0 if a=0 or b=0.
Handling Negative Numbers: 
it checks if the first character of each string is '-'. If either a or b is negative, it toggles the negative flag and removes the negative sign from the respective string.
The product list is initialized with zeros, where the length of the list is set to accommodate the potential maximum length of the product string.
The code uses two nested loops. 
The outer loop iterates through the characters of string b from right to left, treating them as digits.
The inner loop iterates through the characters of string a from right to left, treating them as digits.
Multiplying and Carrying:
 Within the inner loop, it calculates the product of the current digits from a and b, adds any carry from previous calculations, and updates the corresponding position in the product list. It also calculates a new carry for the next iteration.
 After the inner loop completes, it handles any remaining carry by propagating it to the previous positions in the product list.
It then constructs a result string res by joining the elements of the product list.
It removes any leading zeros from the res string.
If the negative flag is set, it adds a negative sign to the res string.
Finally, it returns the res string, which represents the product of the two input numbers.
*/

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
          int nn=1,mm=1;  
          if(num1.charAt(0)=='-')
              nn=-1; 
          if(num2.charAt(0)=='-')
              mm=-1; 
          
            int mul= nn*mm;
            int n1 = num1.length();
            int n2 = num2.length();
            if (n1 == 0 || n2 == 0)     return "0";
 
            // will keep the result number in ArrayList in reverse order
           
            int result[] = new int[n1 + n2];
            for(int ii = 0 ;ii<n1 + n2;ii++)
                result[ii] = 0;
            //this takes care of position of digits in result array
            int i_n1 = 0; // index by num1
            int i_n2 = 0; // index by num2
 
            // go from right to left by num1
            for (int i = n1 - 1; i >= 0; i--)
            {
                if(num1.charAt(i)=='-')
                  continue;
                int carrier = 0;
                int no1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                i_n2 = 0;
                
                // go from right to left by num2
               
                for (int j = n2 - 1; j >= 0; j--)
                {
                    //System.out.println(j);
                    if(num2.charAt(j)=='-')
                      continue;
                  int no2 = Integer.parseInt(String.valueOf(num2.charAt(j))); 
                    
 
                    int sum = no1 * no2 + result[i_n1 + i_n2] + carrier;
                    
                    carrier = sum / 10;
                    result[i_n1 + i_n2] = sum % 10;
                    
                    i_n2++;
                }
 
                // store carrier in next cell
                if (carrier > 0)
                {
                     result[i_n1 + i_n2] += carrier;
                }
 
                i_n1++;
            }
        
        
            
            int i = n1 + n2 - 1;
            while (i>=0 && result[i] == 0) i--;
 
            // if all were '0's - means either both or one of num1 or num2 were '0'
            if(i == -1) return "0";
 
            // generate the result string
            StringBuffer s = new StringBuffer("");
            StringBuffer p = new StringBuffer("");
            
            while (i >= 0)
                {
                    s.append( Integer.toString(result[i] ) );
                    i--;
                }
            if(mul==-1)
            { 
                p.append("-"); 
                p.append(s); 
                
            }
            else
              p.append(s);
            
            return p.toString();
    }
}
