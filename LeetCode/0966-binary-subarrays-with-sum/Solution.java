class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        //no two pointers
        
        int max=0;
        map.put(0,1);
        int sum=0;
       for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        int need=sum-goal;
        if(map.containsKey(need)){
            max+=map.get(need);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
       }
        return max;
        
    }
}