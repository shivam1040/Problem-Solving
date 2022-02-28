/*
Source code for retrieving adjacent nodes connected to a node starting from node 0 to n
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l {
 public static void main(String[] args) {
	 List<String> result=new ArrayList<String>();
	 String name="";
	 int index=0;
	 int level=1;
	 int last=3;
	 int count=0;
	 List<String> obj2=new ArrayList<String>(Arrays.asList(get(name)));
	 String [] obj1=obj2.toArray(new String[0]);
	 while(level<last) {
		 while(index<obj2.size()) {
			result.addAll(Arrays.asList(obj1));
			obj1=get(obj2.get(index));
			index++;
			count++;
			if(index==obj2.size()) {
				for(String b: obj1)
					result.add(b);
			}
		 }
		 level++;
		 index=1;
		 String [] temp=result.subList(count, result.size()).toArray(new String[0]);
		 obj2=Arrays.asList(temp);
		 temp=new String[0];
		 obj1=get(obj2.get(0));
		 count++;
	}
	 System.out.println(result);
}

 static String[] get(String a) {
	 return new String[3];
 }
}
