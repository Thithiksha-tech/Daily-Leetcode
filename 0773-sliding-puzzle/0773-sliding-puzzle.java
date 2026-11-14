class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static String getString(int[][] b){
        char[] ch=new char[6];
        int k=0;
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                ch[k]=(char)(b[i][j]+'0');
                k++;
            }
        }
        return new String(ch);
    }
    public int slidingPuzzle(int[][] bd) {
        int n=2;
        int m=3;

        String target=new String("123450");
        String start=getString(bd);
        if(start.equals(target)){
            return 0;
        }
        int steps=0;
        HashSet<String> set=new HashSet<>();
        Queue<int[][]> q=new LinkedList<>();
        q.add(bd);
        set.add(start);
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[][] cur=q.poll();
                String curString=getString(cur);
                if(curString.equals(target)){
                    return steps;
                }
                int zx=0;
                int zy=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(cur[i][j]==0){
                            zx=i;
                            zy=j;
                        }
                    }

                }
                for(int i=0;i<4;i++){
                    int nx=dx[i]+zx;
                    int ny=dy[i]+zy;
                    if(nx>=0&&nx<n&&ny>=0&&ny<m){
                        int[][] next = new int[n][m];
                        for (int r = 0; r < n; r++) {
                            next[r] = cur[r].clone();
                        }
                        int temp = next[nx][ny];
                        next[nx][ny] = next[zx][zy];
                        next[zx][zy] = temp;
                        String CString=getString(next);
                        if(!set.contains(CString)){
                            set.add(CString);
                            q.add(next);
                        }
                    }
                    
                    
                    
                }
            }
            steps++;

        }
        return -1;

        
    }
}