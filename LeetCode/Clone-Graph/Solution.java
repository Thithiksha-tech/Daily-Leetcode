1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22    static HashMap<Node,Node> map=new HashMap<>();
23    public Node cloneGraph(Node node) {
24        if(node==null){
25            return null;
26        }
27        if(map.containsKey(node)){
28            return map.get(node);
29
30        }
31        Node clone=new Node(node.val);
32        map.put(node,clone);
33        for(Node nei:node.neighbors){
34            clone.neighbors.add(cloneGraph(nei));
35        }
36        return clone;
37        
38    }
39}