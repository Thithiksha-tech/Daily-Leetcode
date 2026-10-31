class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int max=0;
        int n=nums.length;
        for(int r=0;r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>2){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;

            }
            max=Math.max(max,r-l+1);

        }
        return max;
        
    }
}