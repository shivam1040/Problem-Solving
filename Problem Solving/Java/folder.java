import java.util.*;
class Folderx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputarr = input.split(" ");
        Set<Integer> output = new TreeSet<Integer>();
        int foldercount = 1;
        for (int i = 0; i < inputarr.length; i++) {
            int opcount = Integer.parseInt(inputarr[i].substring(2));
            if (inputarr[i].contains("IN") && foldercount <= opcount) {
                while (opcount-- != 0) {
                    if(!output.contains(foldercount)){
                    output.add(foldercount);
                    foldercount++;
                    }
                    else{
                        output.add((output.size()+1));
                    }
                }
                continue;
            }
            if (foldercount > opcount && inputarr[i].contains("IN")) {
                while (opcount-- != 0) {
                    output.add(foldercount);
                    foldercount++;
                }
            }
            if (inputarr[i].contains("DL") && opcount<foldercount){
                output.remove(opcount);
                foldercount=opcount;
            }
        }
        ArrayList<Integer> foutput = new ArrayList<Integer>(output);
        for (Integer x : foutput) {
            if(x==1){
                System.out.println("New Folder");
            }
            else{
            System.out.print("New Folder ("+x+")");
            System.out.println();
            }
        }
        sc.close();
    }
}