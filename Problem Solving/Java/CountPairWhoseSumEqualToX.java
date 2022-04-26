/*
Given two linked list of size N1 and N2 respectively of distinct elements, your task is to complete the function countPairs(), which returns the count of all pairs from both lists whose sum is equal to the given value X.
Note: The 2 numbers of a pair should be parts of different lists.

Example 1:

Input:
L1 = 1->2->3->4->5->6
L2 = 11->12->13
X = 15
Output: 3
Explanation: There are 3 pairs that
add up to 15 : (4,11) , (3,12) and (2,13)
Example 2:

Input:
L1 = 7->5->1->3
L2 = 3->5->2->8
X = 10
Output: 2
Explanation: There are 2 pairs that add up
to 10 : (7,3) and (5,5)
Your Task:
You only need to implement the given function countPairs() and return the count.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N+M)

Constraints:
1<=size of linked list<=10000
1<=X<=10000

Note : All elements in a linked list are unique.
*/

// { Driver Code Starts
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.Iterator;
    import java.util.LinkedList;
    import java.util.Scanner;
    import java.util.*;
    
    class Node {
        int data;
        Node next;
    
        Node(int key) {
            data = key;
            next = null;
        }
    }
    
    class count_pairs {
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
    
            while (t-- > 0) {
                int n1 = sc.nextInt();
                Integer arr1[] = new Integer[n1];
    
                for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();
    
                int n2 = sc.nextInt();
                Integer arr2[] = new Integer[n2];
    
                for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
    
                LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
                LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));
    
                int x = sc.nextInt();
                Solution gfg = new Solution();
                System.out.println(gfg.countPairs(head1, head2, x));
            }
        }
    }// } Driver Code Ends
    
    
    // your task is to complete this function
    
    /*
    class Node
    {
        int data;
        Node next;
    
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    */
    
    class Solution {
    
        public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                              int x) {
               
            int count=0;         
           
           Map<Integer, Integer> map=new HashMap<Integer, Integer>();
           
           String head=head1.size()>=head2.size() ? "2" : "1";
           
           if(head.equals("1")){
               for(int i=0; i<head1.size(); i++){
                   map.put(head1.get(i), 1);
               }
           }
           else{
               for(int i=0; i<head2.size(); i++){
                   map.put(head2.get(i), 1);
               }
           }
           
           if(head.equals("1")){
               for(int i:head2){
                   int temp=x-i;
                   if(map.containsKey(temp)){
                       count++;
                       map.remove(temp);
                   }
               }
           }
           else{
              for(int i:head1){
                   int temp=x-i;
                   if(map.containsKey(temp)){
                       count++;
                       map.remove(temp);
                   }
               } 
           }
           
            return count;
        }
        
    }
    