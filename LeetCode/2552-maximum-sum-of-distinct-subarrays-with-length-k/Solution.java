class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int maxlen=0;
        long len=0;
        long max=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            maxlen=Math.max(maxlen,nums[i]);
        }
        int[] set=new int[maxlen+1];
    
        for(int r=0;r<nums.length;r++){
            while(set[nums[r]]>=1){
                len-=nums[l];
                set[nums[l]]--;
                l++;
            }
            len+=nums[r];
            set[nums[r]]++;
            if(k==r-l+1){
                max=Math.max(max,len);
                len-=nums[l];
                set[nums[l]]--;
                l++;
            }
        }
        return max;
        
    }
}