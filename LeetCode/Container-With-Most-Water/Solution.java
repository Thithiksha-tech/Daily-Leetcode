1class Solution {
2    public int maxArea(int[] nums) {
3         int l=0;
4        int r=nums.length-1;
5        int max=0;
6        while(l<r){
7            int w=r-l;
8            int minheight=Math.min(nums[l],nums[r]);
9            int cur=w*minheight;
10            max=Math.max(max,cur);
11            if(nums[l]<=nums[r]){
12                l++;
13
14            }
15            else if(nums[r]<nums[l]){
16                r--;
17            }
18
19        }
20        return max;
21      
22        
23    }
24}