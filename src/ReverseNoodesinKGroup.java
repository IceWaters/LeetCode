import Util.ListNode;

public class ReverseNoodesinKGroup {
	
	/**
	 * 将需要调换顺序的k个listnode依次存放在数组中，然后调换顺序
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] kNodes = new ListNode[k];
        ListNode node = head;
		int count = 0;
		
		while(count < k && node != null){
			kNodes[count++] = node;
			node = node.next;
		}
		if(count == k){
			//对头指针单独操作
			head = kNodes[--count];
			node = kNodes[0];
			node.next = head.next;
			while(count > 0){
				//调换顺序
				kNodes[count].next = kNodes[--count];
			}
			
			while(count == 0 && node.next != null){
				ListNode next = node.next;
				while(count < k && next != null){
					kNodes[count++] = next;
					next = next.next;
				}
				if(count == k){
					node.next = kNodes[--count];
					node = kNodes[0];
					node.next = kNodes[count].next;
					while(count > 0){
						kNodes[count].next = kNodes[--count];
					}
				}
			}
		}
		return head;
    }
}
