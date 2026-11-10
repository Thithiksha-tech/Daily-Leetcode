class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=-1;
        int l=0;
        int r=0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.get(s.charAt(r))>1){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));

                }
                max=Math.max(max,r-l);
                l++;
            }
            r++;
        }
        
        
        
        return Math.max(max,r-l);
        
    }
}