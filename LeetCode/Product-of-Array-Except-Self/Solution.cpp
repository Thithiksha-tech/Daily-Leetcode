1class Solution {
2    public int[] productExceptSelf(int[] arr) {
3        int j=0;
4        int[] result=new int[arr.length];
5        int[] prefix=new int[arr.length];
6        int[] suffix=new int[arr.length];
7        prefix[0]=1;
8        for(int i=1;i<arr.length;i++){
9            prefix[i]=prefix[i-1]*arr[i-1];
10
11        }
12        suffix[arr.length-1]=1;
13        for(int i=arr.length-2;i>=0;i--){
14            suffix[i]=suffix[i+1]*arr[i+1];
15        }
16        for(int i=0;i<arr.length;i++){
17            result[i]=prefix[i]*suffix[i];
18        }
19        return result;
20    }
21}