class Solution {
    public int[] getpos(int sq,int n){
        int r=(sq-1)/n;
        int c=(sq-1)%n;
        if(r%2==1){
            c=n-1-c;

        }
        r=n-1-r;
        return new int[]{r,c};

    }
    public int snakesAndLadders(int[][] b) {
        int n=b.length;
        int target=b.length*b.length;
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[target+1];
        q.add(1);
        vis[1]=true;
        int moves=0;
          while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int cur=q.poll();
                if(cur==target){
                    return moves;
                }
                for(int dice=1;dice<=6;dice++){
                    int next=cur+dice;
                    if(next>target){
                        break;
                    }
                    int[] pos=getpos(next,n);
                    int r=pos[0];
                    int c=pos[1];
                    if(b[r][c]!=-1){
                        next=b[r][c];
                    }
                    if(!vis[next]){
                        vis[next]=true;
                        q.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}