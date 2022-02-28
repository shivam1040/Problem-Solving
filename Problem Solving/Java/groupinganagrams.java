import java.util.*;
class Agram {
    public static void main(String[] args){
        Agram obj=new Agram();
        String[] str={"dog", "god", "cat", "tac"};
        System.out.println(obj.anagram(str));
    }
    List<List<String>> anagram(String[] str){ //this makes sure a list is returned inside list
        Map<String, List<String>> ma=new HashMap<String, List<String>>();// key of type string and value of type list
        for(String s:str){
            char car[]=s.toCharArray(); //store s[i] in char array, char by char
            Arrays.sort(car);//sorts car array
            String sorted=new String(car);//converts car to single string
            if(!ma.containsKey(sorted)){
                ma.put(sorted, new LinkedList<String>());//stores a key and creates a linked list
            }
            ma.get(sorted).add(s); //get the sorted key and store the s string in list, add method is of list
        }
        return new LinkedList<>(ma.values()); //converts values of hashmap to list
    }
    
}
