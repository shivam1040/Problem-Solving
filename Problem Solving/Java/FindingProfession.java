/*
Consider a special family of Engineers and Doctors with following rules :

Everybody has two children.
First child of an Engineer is an Engineer and second child is a Doctor.
First child of an Doctor is Doctor and second child is an Engineer.
All generations of Doctors and Engineers start with Engineer.
We can represent the situation using below diagram:

                E
           /        \
          E          D
        /   \       /  \
       E     D     D    E
      / \   / \   / \   / \
     E   D D   E  D  E  E  D
Given level and position(pos) of a person in above ancestor tree, find profession of the person.

Example 1:

Input: level = 4, pos = 2
Output: Doctor
Explaination: It is shown in the tree given 
in question.
Example 2:

Input: level = 3, pos = 4
Output: Engineer
Explaination: Already given in the tree in 
question.
Your Task:
You do not need to read input or print anything. Your task is to complete the function profession() which takes level and pos as input parameters and returns 'd' if it is a doctor. Otherwise return 'e'. The driver code will output Doctor for 'd' and Engineer for 'e' itself.

Expected Time Complexity: O(log(pos))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ level ≤ 109
1 ≤ pos ≤ min(109, 2level-1)
*/

/*
If we start counting the position from 0, then we can observe that if number of set bits for a position is odd then the profession is Doctor else the profession is Engineer [no matter what level we are in]. 

Explanation of approach with help of example:
Let input is level = 4 , pos = 4.
As we have to start counting the position from 0 and given position is 1 based so 0 base pos =4-1 = 3.
Now the number of bits set in 3 is 2 [binary of 3 is 11]. 2 is even, so the answer is Engineer.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int level = Integer.parseInt(a[0]);
            int pos = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            if(ob.profession(level, pos) == 'd')
                System.out.println("Doctor");
            else
                System.out.println("Engineer");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char profession(int level, int pos){
        // code here
        int count=0;
        pos=pos-1;
        
        while(pos!=0){
            pos&=(pos-1);
            count++;
        }
        
        return count%2!=0 ? 'd' : 'e';
    }
}
