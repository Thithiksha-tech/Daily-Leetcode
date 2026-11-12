class Solution {
    public static void dfs(int[][] image,int x,int y,int r,int c,int color,int ori){
        if(x<0||x>=r||y<0||y>=c||image[x][y]!=ori){
            return;
        }
        image[x][y]=color;
        dfs(image,x+1,y,r,c,color,ori);
        dfs(image,x,y+1,r,c,color,ori);
        dfs(image,x-1,y,r,c,color,ori);
        dfs(image,x,y-1,r,c,color,ori);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ori=image[sr][sc];
        if(ori==color){
            return image;
        }
        dfs(image,sr,sc,image.length,image[0].length,color,ori);
        return image;
        
    }
}