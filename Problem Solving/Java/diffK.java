public class diffK {
    public int diffCount(int[] data, int k){
        int count=0;
        for(int i=0; i<data.length; i++){
            for(int j=i+1; j<data.length; j++){
                if(j<data.length){
            if((Math.abs(data[i]-data[j]))==k){
                count++;
                continue;
            }
        }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={1, 4, 5, 3, 2};
        int k=2;
        diffK obj=new diffK();
        System.out.println(obj.diffCount(arr, k));
        //Long long a=123456789012345;
        int a=1101;
        int d=0;
    }
}

