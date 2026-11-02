class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int zero=0;
        int l=0;
       
        //dynamic sliding window;
        //trick LENGTH OF A SUBARRAY =r-l+1
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                zero++;

            }
            if(zero<=k){
                int len=r-l+1;
                max=Math.max(max,len);
            }
            while(zero>k){
                
                if(nums[l]==0){
                    zero--;
                }
                l++;
   

            }
  
        }
        return max;
        
    }
}