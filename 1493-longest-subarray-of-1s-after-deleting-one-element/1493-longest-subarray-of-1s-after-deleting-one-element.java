class Solution {
    public int longestSubarray(int[] nums) {
        int r=0;
        int l=0;
        int d=0;
       
        int max=0;
        while(r<nums.length){
            if(nums[r]==0){
                d++;
             
            }
            while(d>1){
                if(nums[l]==0){
                    d--;

                }
                l++;
            }
            max=Math.max(max,r-l);
            r++;
        }
        return max;
        
        
    }
}