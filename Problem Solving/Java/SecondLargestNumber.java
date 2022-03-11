class SecondLargest{
    public static void main(String[] args) {
        int arr[]={5, 2, 4, 6, 9, 7, 10, 20};
        int i, first, second;
        if(arr.length<2){
            System.out.println("Data more than 2 numbers");
        }
        first=second=Integer.MIN_VALUE;
        for(i=0; i<arr.length; i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }

            else if(arr[i]>second && arr[i]!=first){
                second=arr[i];
            }
        }
            {
            if(second==Integer.MIN_VALUE){
                System.out.println("no second largest");
            }
            else{
                System.out.println(second);
            }

        }
}
}