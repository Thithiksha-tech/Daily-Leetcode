class Solution {
    public String minWindow(String s, String t) {
        int count=t.length();
        int[] freq=new int[128];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'A']++;
        }
        int r=0;
        int l=0;
        int bestlength=Integer.MAX_VALUE;
        int beststart=0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']--;
            if(freq[s.charAt(r)-'A']>=0){
                count--;
            }
            while(count==0){
                if(r-l+1<bestlength){
                    bestlength=r-l+1;
                    beststart=l;
                }
                //shrink
                freq[s.charAt(l)-'A']++;
                if(freq[s.charAt(l)-'A']>0){
                    count++;
                }
                l++;
            }
            r++;
        }
        return bestlength==Integer.MAX_VALUE?"":s.substring(beststart,beststart+bestlength);

        
    }
}