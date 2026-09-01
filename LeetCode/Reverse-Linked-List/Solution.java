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
12    public ListNode reverseList(ListNode head) {
13        ListNode temp=head;
14        ListNode prev=null;
15
16        while(temp!=null){
17            ListNode nextnode=temp.next;
18            temp.next=prev;
19            prev=temp;
20            temp=nextnode;;
21        }
22        return prev;
23    }
24}