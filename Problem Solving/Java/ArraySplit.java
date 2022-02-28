/*
Divide an array into two parts so that sum of first part is greater than the second part and print the count of such possibilities
*/
import java.util.ArrayList;
import java.util.List;

public class ArraySplit {
 public static void main(String[] args) {
	List<Integer> original=List.of(10, 4, -8, 7);
	List<Integer> left=new ArrayList<Integer>();
	List<Integer> right=new ArrayList<Integer>();
	int count=0;
	
	for(int i=0; i<original.size()-1; i++) { 
		left=original.subList(0, i+1);
		right=original.subList(i+1, original.size());
		int leftSum=left.stream().mapToInt(Integer::intValue).sum();
		int RightSum=right.stream().mapToInt(Integer::intValue).sum();
		if(leftSum>RightSum)
			count++;
	}
	System.out.println(count);
}
}
