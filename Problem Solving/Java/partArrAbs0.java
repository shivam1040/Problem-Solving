import java.util.*;
import java.util.stream.Collectors;

class Solution3 {
    static List<String> op1=new ArrayList<String>();
    public int minimumDifference(int[] nums) {
        List<Integer> op=Arrays.stream(nums).boxed().collect(Collectors.toList());
        Arrays.sort(nums);
        Collections.sort(op);
        int r=nums.length/2;
        double sum=0;
        for(int a:nums){
            sum+=a;
        }
        double ssum=sum/2;
        double temp1=Integer.MAX_VALUE;
        String  l="";
        printCombination(nums, nums.length, r);
        Collections.sort(op1);
        for(int i=0; i<op1.size(); i++){
            int csum=Integer.parseInt(op1.get(i).substring(0, op1.get(i).indexOf(",")));
            double temp=Math.abs(csum-ssum);
            if(temp<=temp1){
                temp1=temp;
                l=op1.get(i);
            }
        }
        long comcount=l.chars().filter(ch -> ch == ',').count();
        for(long i=comcount; i>0; i--){
            //int a=Integer.parseInt(l.substring(l.lastIndexOf(",")+1, l.length()));
            op.set(op.indexOf(Integer.parseInt(l.substring(l.lastIndexOf(",")+1, l.length()))), null);
            l=l.substring(0, l.lastIndexOf(","));
        }
        Double rs=0.0;
        for(Integer a:op){
            if(a!=null){
                rs+=a;
            }
        }
        return (int) Math.abs(rs-Double.parseDouble(l));

    }
    
	static void combinationUtil(int arr[], int n, int r, int index,
								int data[], int i){
		if (index == r)
		{
            int b=0;
            String str="";
			for (int j=0; j<r; j++){
				//System.out.print(data[j]+" ");
                b+=data[j]; 
                str+=Integer.valueOf(data[j])+",";
            }
            str=str.substring(0, str.length()-1);
			//System.out.println(b+","+str);
            op1.add(b+","+str);

		return;
		}

	
		if (i >= n)
		return;

		data[index] = arr[i];
		combinationUtil(arr, n, r, index+1, data, i+1);
        
		combinationUtil(arr, n, r, index, data, i+1);
	}

	static void printCombination(int arr[], int n, int r)
	{
		int data[]=new int[r];
        Arrays.sort(arr);
		combinationUtil(arr, n, r, 0, data, 0);
	}

    public static void main(String[] args) {
        //int arr[]={34,23,30,77,85,47,96,94};
        int arr[]={7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694};
        Solution3 obj=new Solution3();
        System.out.println(obj.minimumDifference(arr));
    }
}