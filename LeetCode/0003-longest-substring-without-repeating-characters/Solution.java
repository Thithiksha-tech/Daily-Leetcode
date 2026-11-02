
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int l=0;
        int r=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.get(s.charAt(r))>1){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
        
    }
}