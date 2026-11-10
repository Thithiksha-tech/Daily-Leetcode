class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int max=0;
        int maxfreq=0;
        int[] freq=new int[26];
        int windowsize=0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
            windowsize=r-l+1;
            if(windowsize-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}