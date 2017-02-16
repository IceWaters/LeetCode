import Util.ListNode;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode pre, next, list1, list2;
		if(head != null && head.next != null){
			next = head.next.next;
			pre = head;
			head = head.next;
			head.next = pre;
			pre.next = next;
			while(next != null && next.next != null){
				list1 = next;
				list2 = next.next;
				next = list2.next;
				pre.next = list2;
				list2.next = list1;
				list1.next = next;
				pre = list1; 
			}
		}
		
		return head;
    }
}
