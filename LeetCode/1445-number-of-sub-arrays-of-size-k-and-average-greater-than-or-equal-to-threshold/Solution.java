class Solution {
    public int numOfSubarrays(int[] arr, int k, int thres) {
        int len=0;
        int max=0;
        int marr=0;
        for(int i=0;i<k;i++){
            len+=arr[i];
            
        }
        int avg=len/k;
        if(avg>=thres){
            marr+=1;

        }
        for(int i=k;i<arr.length;i++){
            len+=arr[i];
            len-=arr[i-k];
            int av=len/k;
            if(av>=thres){
                marr++;
            }
        }
        return marr;
    }
}