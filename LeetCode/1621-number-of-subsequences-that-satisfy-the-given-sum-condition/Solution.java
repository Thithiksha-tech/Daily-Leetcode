class Solution {
    public int numSubseq(int[] nums, int target) {
        //take or not take
        int mod=1000000007;
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        int[] pow=new int[nums.length];
        pow[0]=1;
        for(int i=1;i<nums.length;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        int max=0;
        while(l<=r){
            int sum=nums[l]+nums[r];
            if(sum<=target){
                max=(max+pow[r-l])%mod;
                l++;
            }
            else{
                r--;
            }
        }
        return max;

    }
}