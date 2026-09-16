1class Solution {
2    static List<List<Integer>> ans=new ArrayList<>();
3    public static void  solve(int[] nums,int ind,ArrayList<Integer> val){
4        ans.add(new ArrayList<>(val));
5        for(int i=ind;i<nums.length;i++){
6            if(i>ind&&nums[i]==nums[i-1]){
7                continue;
8            }
9            val.add(nums[i]);
10            solve(nums,i+1,val);
11            val.remove(val.size()-1);
12        }
13    }
14    public List<List<Integer>> subsetsWithDup(int[] nums) {
15        ans.clear();
16        Arrays.sort(nums);
17        solve(nums,0,new ArrayList<>());
18        return ans;
19        
20    }
21}