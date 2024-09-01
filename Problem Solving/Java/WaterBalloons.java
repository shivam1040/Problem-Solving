/*
Geek is celebrating holi by aiming coloured water balloons at his friends. He wants to avoid throwing balloons of the same colours more than twice in a row. Given a string st, where each alphabet denotes a different colour, modify the sequenuence to represent the correct order of throwing balloons by eliminating some of them.


Example 1:

Input: 
st = ABBBCCDEAB
Output: ABBCCDEAB
Explaination: Remove the third 'B'.

Example 2:

Input: 
st = AAAAAA
Output: AA
Explaination: We can keep only two A's.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function sequence() which takes string st as input parameter and returns a string containing the modified sequence.

 

Expected Time Complexity: O(N), where n is the length of the string st.
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ |st| ≤ 10000


*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(st));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static String sequence(String st){
        // code here
        // List<Character> aux=new ArrayList<>();

        // for(char i:st.toCharArray())
        //     aux.add(i);
        // int temp=0;
        // for(int i=1; i<aux.size(); i++){
        //     while (i<aux.size() && aux.get(i)==aux.get(i-1)) {
        //         temp++;
                
        //         if (temp >=2) {
        //             aux.remove(i);
        //             temp--;
        //             i--;
        //         }
        //         i++;
        //     }
        //     temp=0;
        // }
        // StringBuilder res=new StringBuilder();
        // for(char i:aux)
        //     res.append(i);
        // return res.toString();
        String res=""; 
        char prev='-';
        int count=1;
        
        for(char i:st.toCharArray())
            if(prev!=i){
                res+=i;
                prev=i; 
                count=1;
            }
            else{
                count++;
                if(count==2)
                    res+=i;
            }
        return res;
    }
}


