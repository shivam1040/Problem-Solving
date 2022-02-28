import java.io.*;
import java.util.*;
class Companyr {
    public static void main(String[] args) throws FileNotFoundException{
        File obj = new File("comp.txt");
        Scanner sc=new Scanner(obj);
        ArrayList<String> output=new ArrayList<String>();
        int good=0;
        int bad=0;
        int index=0;
        String[] plus={"good", "positive"};
        String[] negative={"bad", "negative"};
        while(sc.hasNext()){
            String line=sc.nextLine();
            output.add(line.substring(0, line.indexOf(",")));
            for(String x:plus){
            while(line.contains(x)){
                line=line.replaceFirst(x, "");
                if(x=="good"){
                    good=good+2;
                }
                else{
                    good=good+1;
                }
            }
        }
        for(String x:negative){
            while(line.contains(x)){
                line=line.replaceFirst(x, "");
                if(x=="bad"){
                    bad=bad+1;
                }
                else{
                    bad=bad+1;
                }
            }
        }
        System.out.println("P: "+good);
        System.out.println("N: "+bad);
        System.out.println(output.get(index)+": "+(good-bad));
        good=0; 
        bad=0;
        index++;
    }    
    sc.close();
}
}