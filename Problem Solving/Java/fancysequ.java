import java.math.BigInteger;
import java.util.*;
class Fancy {
    List<Long> append;
    int add=0;
    int mult=1;
    public Fancy() {
        append=new ArrayList<Long>();   
    }
    
    public void append(int val) {
        append.add(Long.valueOf(val));
       
    }
    
    public void addAll(int inc) {
        add+=inc;
         if(append.size()==0){
                    //append.add(inc);
                    return;
                }
         for(int i=0; i<append.size(); i++){
            
                append.set(i, append.get(i)+inc);   
        }
    }
    
    public void multAll(int m) {
        mult*=m;
           for(int i=0; i<append.size(); i++){
                
                append.set(i, append.get(i)*m);   
        }
    }
    
    public Long getIndex(int idx) {
        if(append.size()==0 || idx>=append.size()){
            return Long.valueOf(-1);
        }
        if(append.get(idx)>999999999){
            long M = 1000000007;
            long n=append.get(idx)%M;
            append.set(idx, n);
        }
        return append.get(idx);
    }
    public static void main(String[] args) {
        String arr[]={"Fancy","append","append","getIndex","append","getIndex","addAll","append","getIndex","getIndex","append","append","getIndex","append","getIndex","append","getIndex","append","getIndex","multAll","addAll","getIndex","append","addAll","getIndex","multAll","getIndex","multAll","addAll","addAll","append","multAll","append","append","append","multAll","getIndex","multAll","multAll","multAll","getIndex","addAll","append","multAll","addAll","addAll","multAll","addAll","addAll","append","append","getIndex"};
        int arr1[]={0,12,8,1,12,0,12,8,2,2,4,13,4,12,6,11,1,10,2,3,1,6,14,5,6,12,3,12,15,6,7,8,13,15,15,10,9,12,12,9,9,9,9,4,8,11,15,9,1,4,10,9};
        Fancy obj=new Fancy();
        for(int i=0; i<arr1.length; i++){
            if(arr[i]=="append"){
                obj.append(arr1[i]);
                System.out.print("null ,"); 
            }
            else if(arr[i]=="getIndex"){
                
                System.out.print(obj.getIndex(arr1[i])+", "); 
            }
            else if(arr[i]=="addAll"){
                obj.addAll(arr1[i]);
                System.out.print("null, "); 
            }
            else if(arr[i]=="multAll"){
                obj.multAll(arr1[i]);
                System.out.print("null, "); 
            }
        }
    }
}