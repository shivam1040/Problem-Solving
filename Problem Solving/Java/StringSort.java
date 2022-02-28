import java.util.Scanner;
/*
Zimbabwe", "South-Africa", "India", "America", "Yugoslavia", " Australia", "Denmark", "France", "Netherlands", "Italy", "Germany
*/
public class StringSort {
    public static void main(String[] args) {
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter number of inputs: ");
        String inputs[]=new String[scannerObj.nextInt()];
        Scanner scannerObj1=new Scanner(System.in);
        for(int i=0; i<inputs.length; i++){
            System.out.println("Enter "+(i+1)+" element:");
            inputs[i]=scannerObj1.nextLine();
        }
        for(int i=0; i<inputs.length; i++){
            for(int j=0; j<inputs.length; j++){
                if(i!=j){
                    if(inputs[i].compareTo(inputs[j])<0){
                        String temp=inputs[j];
                        inputs[j]=inputs[i];
                        inputs[i]=temp;
                    }
                }
            }
        }
        for(String s:inputs)
            System.out.print(s+", ");
    }
}
