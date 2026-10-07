1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        //negative numbers are possible
4        HashMap<Integer,Integer> map=new HashMap<>();
5        int sum=0;
6        map.put(0,1);
7        int count=0;
8        for(int i=0;i<nums.length;i++){
9            sum+=nums[i];
10            if(map.containsKey(sum-k)){
11                count+=map.get(sum-k);
12            }
13            map.put(sum,map.getOrDefault(sum,0)+1);
14        }
15        return count;
16        
17    }
18}