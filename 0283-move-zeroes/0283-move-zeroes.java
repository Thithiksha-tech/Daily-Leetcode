class Solution {
    public void moveZeroes(int[] nums) {
        int l=0;
        int r=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]!=0){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r++;
            }
            else{
                r++;
            }

        }
        
    }
}