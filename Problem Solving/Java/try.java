/*
Manipulating a list of strings
*/
import java.util.*;
class Ry {
    
    public static void main(String[] args) {
        
    
    Scanner obj=new Scanner(System.in);
    int n=obj.nextInt();
    int q=obj.nextInt();
    int arr[]=new int[q];
    char c='c';
   
    for(int i=0; i<q; i++){
        arr[i]=obj.nextInt();
    }
    Scanner obj1=new Scanner(System.in);
    String arrt=obj1.nextLine();
    ArrayList<String> obj3=new ArrayList<String>();
    String temp="";
    arrt=arrt.replaceAll(" ", "");
    System.out.println(arrt);
    int k=0;
    for(int i=1; i<n; i++){
        for(int j=k; j<=arrt.length() ; j++){
            if(arrt.charAt(j)!='c'){
            temp=temp+arrt.charAt(j);
            continue;
            }
            
            }
            obj3.add("c"+temp+",");
            if(k+1==arrt.length()){
                break;
        }
        k=k+3;
        
    }
}
}