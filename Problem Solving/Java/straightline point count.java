import java.util.*;

class Solutionx {
    public int maxPoints(int[][] points) {
        double slope=0;
        Map<String, String> a=new HashMap<String, String>();
        String b[];
        String s="";
        int count=1;
        int max=1;
        int ulti=0;
        if(points.length<2){
            if(points.length==2){
                return 2;
            }
            else{
                return 0;
            }
        }
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points.length; j++){
                if(i!=j){
                double num=points[j][1]-points[i][1];
                double den=points[j][0]-points[i][0];
                slope=num/den;
                s+=slope+",";
                //System.out.println(slope);
                
                }
               
            }
            s=s.substring(0, s.length()-1);
            b=s.split(",");
            a.put(points[i][0]+", "+points[i][1], s);
            Arrays.sort(b);
            for(int k=1; k<b.length; k++){
                if(b[k].equals(b[k-1])){
                    count++;
                }
                else{ 
                if(count>max){
                    max=count;
                }
                count=1;
            }
                if(count>max){
                    max=count;
                }
            
            }
            ulti=max;
            count=1;
            s="";
            /*Collections.sort(b);
            boolean c=true;
            for(int k=0; k<b.size(); k++){
                if(k+1<b.size()){
                if(Collections.frequency(b, b.get(k))>1 && c==true){
                    slope=Collections.frequency(b, b.get(k))+1;
                }
                if(b.get(k)==b.get(k+1)){
                    c=false;
                }
                else{
                    c=true;
                }
            }
            }*/
            
           
        }
     
        return ulti+1;
    }
    public static void main(String[] args) {
        //int arr[][]={{1,1},{3,2},{4,1},{2,3}};
        //int arr[][]={{1,1},{2,2},{3,3}};
        int arr[][]={{0,0},{94911151,94911150},{94911152,94911151}};
        Solutionx obj=new Solutionx();
        System.out.println(obj.maxPoints(arr));
    }
}