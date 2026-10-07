1class Solution {
2    public int[][] merge(int[][] arr) {
3        Arrays.sort(arr,(a,b)->a[0]-b[0]);
4        int st=arr[0][0];
5        int ed=arr[0][1];
6        List<int[]> ans=new ArrayList<>();
7        for(int i=1;i<arr.length;i++){
8            if(arr[i][0]<=ed){
9                ed=Math.max(arr[i][1],ed);
10
11            }
12            else{
13                ans.add(new int[]{st,ed});
14                st=arr[i][0];
15                ed=arr[i][1];
16            }
17
18
19        }
20        ans.add(new int[]{st,ed});
21        return ans.toArray(new int[ans.size()][]);
22        
23    }
24}