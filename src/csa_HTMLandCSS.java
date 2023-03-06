
public class csa_HTMLandCSS {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cru = head;
        while (cru != null){
            ListNode Next = cru.next;
            cru.next = pre;
            pre = cru;
            cru = Next;
        }
        return pre;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 利用递归，哪一个链表第一个值更小，添加到另一个链表的下一个节点，直到一个链表为空
         */
        if(l1 == null)
            return l2;
        else if(l2==null)
            return l1;
        else if(l1.val< l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    private ListNode frontPointer;
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    public boolean recursivelyCheck(ListNode curNode) {
        if (curNode != null) {
            if (!recursivelyCheck(curNode.next)) {
                return false;
            }
            if (curNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
