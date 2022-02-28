import java.util.*;
import java.lang.*;
import java.io.*;
class topKelements{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); //test case
        while(t--!=0){
            int n=sc.nextInt(); //number of elements
            int k=sc.nextInt(); //top nos. of elements
            int a[]=new int[n];
            for(int i=0; i<n; i++){
                a[i]=sc.nextInt();
            }
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
            for(int i=0; i<n; i++){
                if(i<k){ //insert k elements in PQ
                    pq.add(a[i]);
                }
                else{
                    if(pq.peek()<a[i]){ //checks if element after k elements insertion are small then add
                        pq.poll();
                        pq.add(a[i]);
                    }
                }                    
                }
            ArrayList<Integer> ob2=new ArrayList<Integer>(pq);
            Collections.sort(ob2, Collections.reverseOrder()); //comparator reverseorder
            for(int x:ob2){
                System.out.print(x+" ");
            }
            System.out.println();
            }
        }
    }
    