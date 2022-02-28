class Solution7{
    static int findSingle(int N, int arr[]){
        // code here
        int ans=0;
        for(int i=0; i<N; i++){
            int temp=arr[i];
            ans^=arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 2, 1};
        System.out.println(findSingle(arr.length, arr));
    }
}