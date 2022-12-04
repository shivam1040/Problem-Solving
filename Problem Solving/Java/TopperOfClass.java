/*
There is a class of N students and the task is to find the top K marks scorers. You need to print the index of the toppers of the class which will be same as the index of the student in the input array (use 0-based indexing). First print the index of the students having highest marks then the students with second highest and so on. If there are more than one students having same marks then print their indices in ascending order.Suppose k = 2 and the students having highest marks have indices 0 and 5 and students having second highest marks have indices 6 and 7 then output will be 0 5 6 7.

Example 1:

Input:
N=5 K=3
arr[] = { 2, 2, 1, 3, 1 }
Output: 3 0 1 2 4
Explanation: Topper with 3 marks is present 
at 3rd index, 2 marks is present at 0th 
index and next at 1st index. 1 marks is present 
at 2 and 4.
Example 2:

Input:
N=4 K=1
arr[] = { 1, 2, 3, 4 } 
Output: 3
Explanation: The highest marks is at index 3.
Your Task:
Since this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function kTop() that takes array A and integer N as parameters and change the given array according to the given conditions. You do not have to return anything

 

Expected Time Complexity: O(NlogN).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106
1 ≤ M ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
        import java.util.*;

class node
{
    int marks;
    int index;
    public void setMarks(int a)
    {
        this.marks=a;
    }
    public void setIndex(int b)
    {
        this.index=b;
    }
}

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            node a[]=new node[n];
            for(int i=0;i<n;i++) {
                a[i] = new node();
                a[i].setMarks(Integer.parseInt(q[i]));
                a[i].setIndex(i);
            }

            int k = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ob.kTop(a,n);
            int i=0;
            for(int j=0;j<k;j++)
            {
                int x=a[i].marks;
                while(i<n && a[i].marks==x) {
                    System.out.print(a[i].index + " ");
                    i++;
                }
                if (i == n)
                    break;
            }
            System.out.println();

        }
    }
}



// } Driver Code Ends


//User function Template for Java


/* class node
{
    int marks;
    int index;
    public void setMarks(int a)
    {
        this.marks=a;
    }
    public void setIndex(int b)
    {
        this.index=b;
    }
}
*/

class GFG
{
    void kTop(node a[],int n)
    {
        // Your code goes here
        Arrays.sort(a, new Comparator<node>() {
    public int compare(node i1, node i2) {
        //return Integer.compare(a1.marks, a2.marks);
        if (i1.marks== i2.marks)
            return 0;
        else if (i1.marks < i2.marks)
            return 1;
        else
            return -1;
    }
});
    }
}



