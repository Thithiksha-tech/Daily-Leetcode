1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
13        
14        int n1=0;
15        int n2=0;
16        ListNode temp1=l1;
17
18        while(temp1!=null){
19            temp1=temp1.next;
20            n1++;
21        }
22        ListNode temp2=l2;
23
24        while(temp2!=null){
25            temp2=temp2.next;
26            n2++;
27
28        }
29        ListNode dummy =new ListNode(-1);
30        ListNode res=dummy;
31        
32        
33        while(l1!=null&&l2!=null){
34            if(l1.val<=l2.val){
35                res.next=l1;
36                l1=l1.next;
37                res=res.next;
38            
39            }
40            else{
41                res.next=l2;
42                l2=l2.next;
43                res=res.next;
44          
45            }
46        }
47        if(l1!=null){
48            res.next=l1;
49            res=res.next;
50
51        }
52        if(l2!=null){
53            res.next=l2;
54            res=res.next;
55        }
56        return dummy.next;
57        
58    }
59}