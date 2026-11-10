class Solution {
    public int removeDuplicates(int[] arr) {
        int val=0;
        int ele=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=ele){
                val++;
                arr[val]=arr[i];
                ele=arr[i];
            }
        }
        return val+1;
        
    }
}