import java.util.*;

class Solution5 {
    static public int strongPasswordChecker(String password) {
        int countinc=0;
        int countdec=0;
        int alpha=3;
        int rep=0;
        int res=0;
        boolean contc=false;
        if(password.length()<6 || password.length()>20){
            contc=true;
            if(password.length()<6){
                countinc=6-password.length();
            }
            else{
                countdec=password.length()-20;
            }
        }
        int s=1;
        int b=1;
        int d=1;
        for(int i=0; i<password.length(); i++){
            if(password.charAt(i)>='a' && password.charAt(i)<='z' && s==1){
                alpha--;
                s=0;
            }
            else if(password.charAt(i)>='A' && password.charAt(i)<='Z' && b==1){
                alpha--;
                b=0;
            }
            else if(Character.isDigit(password.charAt(i)) && d==1){
                alpha--;
                d=0;
            }
            else if(alpha==0){
                break;
            }

        }
        
        int index=0;
        int c=1;
        
        for(int i=0; i<password.length(); i++){
            int temp2=0;
            if(index+3<=password.length()){
                temp2=1;
            if(password.charAt(index)==password.charAt(index+1)){ 
            String temp=Character.toString(password.charAt(index))+Character.toString(password.charAt(index+1));
            if(password.charAt(index+1)==password.charAt(index+2)){
                String temp1=Character.toString(password.charAt(index+2)); 
                rep++;
                index+=3;
                c=0;
                temp2=0;

            }
            else{
                c=1;
            }
        
            }
           if(c==1){
            index+=2;
            c=0;
           }
           else if(temp2==1){
               index++;
           }
          
        }
        } 
      




 

List<Integer> rep1=new ArrayList<Integer>();
int len=1;
int c1=0;
for(int i=0; i<password.length(); i++){
    if(i+1<password.length()){
    if(password.charAt(i)==password.charAt(i+1)){
        String a1=Character.toString(password.charAt(i))+Character.toString(password.charAt(i+1));
        len++;
        c1=1;
        continue;
    }
}
    if(c1==1 && len>=3){
        rep1.add(len);
        len=1;
        c1=0;
    }
    else{
        len=1;
        c1=0;
    }


}

    if(contc){
           
        if(countinc>0){
        if(countinc>alpha || countinc==alpha){
            res=countinc;
            
        }
        else{
            res=alpha;
        }
    }
    if(countdec>0){
            res=Math.abs(countdec)+alpha;
        }

           
       }
       else{
           res=alpha;
       }
        if(rep>0){
            if(countdec>0 && alpha>0 && rep>countdec){
                if(rep*3==password.length()){
                    res=rep;
                }
                else{
                res=((rep*3)-countdec-alpha)/2;
                }
            }
            else if(rep<countdec && alpha>0){
                if(rep*2>countdec){
                res=(rep*2)-alpha;
                }
                
            }
            else if(countdec==rep){
                if(alpha>0){
                    res=rep+alpha;
                }
                else{
                res=rep+1;
                }
            }
            else if(rep<countdec && alpha==0){
                if(rep*3-countdec<=2){
                    res=countdec;
                }
                else{
                res=countdec+rep;
                }
            }
            else if(rep>res){
            res=rep;
            

            }
           
            
        }
       
        
        int y=0;
     
       
        for(int i=0; i<rep1.size(); i++){
          y+=rep1.get(i)/3; //y is total replaac required
        }
        
 
     
        

 
            if(countdec>0){
                int oneSeq=0;
                int twoSeq=0;
                for(int i=0; i<rep1.size(); i++){
                    if(rep1.get(i)%3==0){
                        oneSeq++;
                    }
                    else if(rep1.get(i)%3==1){
                        twoSeq++;
                    }
                }
                //int deletes = n - 20;
        y -= Math.min(oneSeq, countdec); //matches mod 0.
        y -= Math.min(Math.max(countdec - oneSeq, 0), twoSeq * 2) / 2; //matches mod 1.
        y -= Math.max(countdec - oneSeq - twoSeq * 2, 0) / 3; //matches mod 2.
                    res=countdec + Math.max(y, alpha);
            }
        
        
       
        return res;
    }
    public static void main(String[] args) {
        System.out.println(strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
    }
   
}