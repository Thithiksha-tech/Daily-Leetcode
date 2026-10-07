1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> ans=new ArrayList<>();
19        if(root==null){
20            return ans;
21        }
22        Queue<TreeNode> q=new LinkedList<>();
23        int size=0;
24        q.add(root);
25        while(!q.isEmpty()){
26            size=q.size();
27            ArrayList<Integer> level=new ArrayList<>();
28            for(int i=0;i<size;i++){
29                TreeNode cur=q.poll();
30                level.add(cur.val);
31                if(cur.left!=null){
32                    q.add(cur.left);
33                }
34                if(cur.right!=null){
35                    q.add(cur.right);
36                }
37            }
38            ans.add(level);
39        }
40        return ans;
41       
42    }
43}