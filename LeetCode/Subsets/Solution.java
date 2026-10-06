1class Solution {
2    static List<List<Integer>> ans=new ArrayList<>();
3    public static void solve(int ind,int[] nums,ArrayList<Integer> val){
4        
5        ans.add(new ArrayList<>(val));
6        for(int i=ind;i<nums.length;i++){
7            
8            val.add(nums[i]);
9            solve(i+1,nums,val);
10            val.remove(val.size()-1);
11           
12        }
13    }
14    public List<List<Integer>> subsets(int[] nums) {
15
16        ans.clear();
17        Arrays.sort(nums);
18        solve(0,nums,new ArrayList<>());
19        return ans;
20
21        
22    }
23}