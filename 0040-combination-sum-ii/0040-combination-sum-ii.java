class Solution {
    static List<List<Integer>> ans=new ArrayList<>();
    public static void solve(int[] nums,int target,int ind,ArrayList<Integer> val,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(val));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            if(i>ind&&nums[i]==nums[i-1]){
                continue;
            }
            if(sum>target){
                return;
            }
            val.add(nums[i]);
            solve(nums,target,i+1,val,sum+nums[i]);
            val.remove(val.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans.clear();
        Arrays.sort(nums);
        solve(nums,target,0,new ArrayList<>(),0);
        return ans;
        
    }
}