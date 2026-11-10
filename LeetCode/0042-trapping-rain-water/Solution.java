class Solution {
    public int trap(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int leftmax=0;
        int rightmax=0;
        int max=0;
        while(l<r){
            leftmax=Math.max(leftmax,nums[l]);
            rightmax=Math.max(rightmax,nums[r]);
            if(leftmax<=rightmax){
                max+=(leftmax-nums[l]);
                l++;
            }
            else{
                max+=(rightmax-nums[r]);
                r--;
            }
        }
        return max;
        
    }
}
