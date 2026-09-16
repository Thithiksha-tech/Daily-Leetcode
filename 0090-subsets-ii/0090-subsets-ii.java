class Solution {
    static List<List<Integer>> ans=new ArrayList<>();
    public static void  solve(int[] nums,int ind,ArrayList<Integer> val){
        ans.add(new ArrayList<>(val));
        for(int i=ind;i<nums.length;i++){
            if(i>ind&&nums[i]==nums[i-1]){
                continue;
            }
            val.add(nums[i]);
            solve(nums,i+1,val);
            val.remove(val.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.clear();
        Arrays.sort(nums);
        solve(nums,0,new ArrayList<>());
        return ans;
        
    }
}