/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode dummy = new ListNode();   // placeholder, not part of final answer
        ListNode ans = dummy;              // moving pointer that builds the list

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ans.next = head1;
                head1 = head1.next;
            } else {
                ans.next = head2;
                head2 = head2.next;
            }
            ans = ans.next;   // move the writer pointer forward
        }

        // attach whichever list still has leftover nodes
        while (head1 != null) {
            ans.next = head1;
            head1 = head1.next;
            ans = ans.next;
        }

        while (head2 != null) {
            ans.next = head2;
            head2 = head2.next;
            ans = ans.next;
        }

        return dummy.next;   // skip the dummy, return the real head
    }
}