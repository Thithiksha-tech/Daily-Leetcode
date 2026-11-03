class Solution {
    public int maxScore(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int minval=Integer.MAX_VALUE;
        int min=0;
        int ans=nums.length-k;
        for(int i=0;i<ans;i++){
            min+=nums[i];

        }
        minval=Math.min(min,minval);
        for(int i=ans;i<nums.length;i++){
            min+=nums[i];
            min-=nums[i-ans];
            minval=Math.min(min,minval);
        }
        return sum-minval;
        
    }
}