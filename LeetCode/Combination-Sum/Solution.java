1class Solution {
2    static List<List<Integer>> ans=new ArrayList<>();
3    public static void solve(int ind,int[] nums,int target,ArrayList<Integer> val){
4        if(target==0){
5            ans.add(new ArrayList<>(val));
6            return;
7        }
8        for(int i=ind;i<nums.length;i++ ){
9            if(target>0){
10                val.add(nums[i]);
11                solve(i,nums,target-nums[i],val);
12                val.remove(val.size()-1);
13            }
14        }
15    }
16    public List<List<Integer>> combinationSum(int[] nums, int target) {
17        ans.clear();
18        solve(0,nums,target,new ArrayList<>());
19        return ans;
20        
21    }
22}