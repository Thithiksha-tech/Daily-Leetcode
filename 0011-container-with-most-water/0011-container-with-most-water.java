class Solution {
    public int maxArea(int[] nums) {
         int l=0;
        int r=nums.length-1;
        int max=0;
        while(l<r){
            int w=r-l;
            int minheight=Math.min(nums[l],nums[r]);
            int cur=w*minheight;
            max=Math.max(max,cur);
            if(nums[l]<=nums[r]){
                l++;

            }
            else if(nums[r]<nums[l]){
                r--;
            }

        }
        return max;
      
        
    }
}