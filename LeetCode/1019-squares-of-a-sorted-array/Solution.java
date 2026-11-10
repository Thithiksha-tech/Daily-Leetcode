class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ind=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        int l=0;
        int h=nums.length-1;
        int k=nums.length-1;
        while(l<=h){
            if(nums[l]>=nums[h]){
                ind[k--]=nums[l++];

            }
            else{
                ind[k--]=nums[h--];
            }
        }
        return ind;
        
    }
}