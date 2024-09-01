/*
Given a date in dd mm yyyy format. Find the nearest date greater than the given date such that all the digits in both the dates should be equal provided order of digits may be change.
Note: Assume that every month of the year has 30 days.


Example 1:

Input: 
12 02 2014
Output:
21 02 2014
Explanation:
If we change the positions of 
date 12 to 21 then it will be 
a valid date.
Example 2:

Input:
09 05 1998
Output:
05 09 1998
Exaplanation:
Switch day with the month and we 
will get the nearest valid date.

Your Task:
You don't need to read or print anything. Your task is to complete the function closest_date() which takes date as the first parameter, month as the second parameter, year as the third parameter(All in string form) and returns the nearest date in dd mm yyyy format in string form. If not possible return "-1"(Without quotes).

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)
 

Constraints:
1 ≤ date ≤ 30
1 ≤ month ≤ 12
1000 ≤ year ≤ 9999
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
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T-->0)
        {
            String S = sc.nextLine();
            String[] s = S.split(" ");
            String dd = s[0];
            String mm = s[1];
            String yy = s[2];
            Solution ob = new Solution();
            String res  = ob.closest_date(dd, mm, yy);
            System.out.println(res);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  closest_date(String date, String month, String year)
    {
        // Code here
                String date2=date;
        String month2=month;
        String year2=year;
        do{
            Integer d=Integer.valueOf(date2);
            int m=Integer.valueOf(month2);
            int y=Integer.valueOf(year2);
            if(d<30) {
                date2=(d<9)?"0"+(d+1):(d+1)+"";
            }
            else {
                if(m<12) {
                    month2=m<9?"0"+(m+1):(m+1)+"";
                    date2="01";
                }
                else {
                    year2=(++y)+"";
                    month2="01";
                    date2="01";
                    if(y==10000)
                      return "-1";
                }
            }
        }
        //finding if freq of both dates same by increasing the dates and time one by one
        while(!isSame(date,month,year,date2,month2,year2));
            
        
        return date2+" "+month2+" "+year2;
    }
    
        public static boolean isSame(String d1,String m1,String y1,String d2,String m2,String y2){
        
        HashMap<Character,Integer> x=new HashMap<>(); 
        HashMap<Character,Integer> y=new HashMap<>(); 
        
        add(d1,x);add(m1,x);add(y1,x);add(d2,y);add(m2,y);add(y2,y);
        
        for(Map.Entry<Character,Integer> e:x.entrySet()){
            char key=e.getKey();
            if(!y.containsKey(key) || e.getValue()!=(int)y.get(key))
              return false;
        }
        return true;
        
    }
    
    public static void add(String s,HashMap<Character,Integer> m){
        for(int i=0;i<s.length();i++)
          m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
    }
}
