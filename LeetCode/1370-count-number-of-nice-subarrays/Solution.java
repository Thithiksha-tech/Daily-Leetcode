class Solution {
    public static int atmost(int[]nums,int k){
        int oddcount=0;
        int l=0;
        int r=0;
        int ans=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                oddcount++;
            }
            while(oddcount>k){
                if(nums[l]%2!=0){
                    oddcount--;
                }
                l++;
            }

            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
        
    }
}