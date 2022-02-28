import java.util.*;
class Rrayzero {
    public static void main(String[] args){
        int[] a={1, 2, 3, 4, -1, 1};
        boolean found=false;
        Set<Integer> set=new HashSet<Integer>();
        int sum=0;
        for(int ele:a){
            set.add(sum);
            sum+=ele;
            if(set.contains(sum)){ //keeps storing sum and chcks for repeat in set to break the loop
                System.out.println("yes");
                found=true;
                break;
            }
        }
    }
}
