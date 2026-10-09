1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        
4        List<List<Integer>> ans=new ArrayList<>();
5        Arrays.sort(nums);
6        int n=nums.length;
7        for(int i=0;i<n;i++){
8            if(i>0&&nums[i]==nums[i-1]){
9                continue;
10            }
11            int j=i+1;
12            
13                if(j>i+1&&nums[j]==nums[j-1]){
14                    continue;
15                }
16                int k=n-1;
17                while(j<k){
18                    int sum=nums[i]+nums[j]+nums[k];
19                    if(sum>0){
20                        k--;
21                    }
22                    else if(sum<0){
23                        j++;
24                    }
25                    else{
26                        ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
27                        j++;
28                        k--;
29                        while(j<k&&nums[j]==nums[j-1]){
30                            j++;
31                        }
32                         while(j<k&&nums[k]==nums[k+1]){
33                            k--;
34                        }
35                    }
36                }
37            
38        }
39        return ans;
40    }
41}