class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;
        for (int i = 1; i < left; i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        ListNode leftNode = curr;   
        ListNode prev = null;
        for (int i = 0; i <= right - left; i++) {   
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        leftPrev.next = prev;     
        leftNode.next = curr;      
        return dummy.next;
    }
}