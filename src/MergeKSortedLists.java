import Util.ListNode;

public class MergeKSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
        return mergeRec(lists, 0, lists.length - 1);
    }
	
	/**
	 * 按照归并排序的方法
	 * @param lists
	 * @param start
	 * @param end
	 * @return
	 */
	private ListNode mergeRec(ListNode[] lists, int start, int end){
		if(start < end){
			int middle = (start + end) / 2;
			return mergeTwoLists(mergeRec(lists, start, middle), mergeRec(lists, middle + 1, end));
		}else {
			return lists[start];
		}
	}
	
	/**
	 * 将两个已排序的序列排列在一起
	 * @param list1
	 * @param list2
	 * @return
	 */
	private ListNode mergeTwoLists(ListNode list1, ListNode list2){
		ListNode head = new ListNode(0);
		ListNode current = head;
		while(list1 != null && list2 != null){
			if(list1.val > list2.val){
				current.next = list2;
				list2 = list2.next;
			}else{
				current.next = list1;
				list1 = list1.next;
			}
			current = current.next;
		}
		
		if(list1 != null)
			current.next = list1;
		else
			current.next = list2;

		return head.next;
	}
}
