class Solution {
    public void sortColors(int[] nums) {
        //DUTCH NATIONAL FLAG ALOGIRTHM
        int n=nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                nums[mid]=nums[low];
                nums[low]=0;
                mid++;
                low++;

            }
            else if(nums[mid]==1){
                mid++;

            }
            else if(nums[mid]==2){
                nums[mid]=nums[high];
                nums[high]=2;
                high--;

            }
        }

        
    }
}