// find the first common element of 2 intersecting list

package cs5800.hw1;

public class LinkedListIntersection {

	public static void main(String[] args) {

		/* TEST 1 - 2 LIST with a common part */
		// Common part of the list
		SingleLinkedList cl = new SingleLinkedList();
		cl.insertAtStart(10);
		cl.insertAtStart(20);
		cl.insertAtStart(30);

		// create the first list
		SingleLinkedList l1 = new SingleLinkedList();
		// l1.insertAtStart(4);
		// l1.insertAtStart(3);
		l1.insertAtStart(2);
		l1.insertAtStart(1);

		// insert the common list at the tail
		l1.InsertListAtEnd(cl);

		// create the second list
		SingleLinkedList l2 = new SingleLinkedList();
		l2.insertAtStart(33);
		l2.insertAtStart(22);
		l2.insertAtStart(11);
		// insert the common list at the tail
		l2.InsertListAtEnd(cl);

		System.out.println("*********COMMMON LIST*****");
		cl.displayList();
		System.out.println("*********LIST 1***********");
		l1.displayList();
		System.out.println("*********LIST 2***********");
		l2.displayList();
		System.out.println("******COM ELEMENT**********");
		Node common_node = findIntersectionNode(l1, l2);
		if (common_node == null) {
			System.out.println("No such Node found");
		} else {
			System.out.println(common_node.data);
		}

		/* ************************************************** */
		/* TEST 1 - 2 LIST with no common part */
		// create the first list
		SingleLinkedList l11 = new SingleLinkedList();
		// l1.insertAtStart(4);
		// l1.insertAtStart(3);
		l11.insertAtStart(2);
		l11.insertAtStart(1);

		// create the second list
		SingleLinkedList l22 = new SingleLinkedList();
		l22.insertAtStart(33);
		l22.insertAtStart(22);
		l22.insertAtStart(11);

		System.out.println("*********LIST 1***********");
		l11.displayList();
		System.out.println("*********LIST 2***********");
		l22.displayList();
		System.out.println("******COM ELEMENT**********");
		Node common_node2 = findIntersectionNode(l11, l22);
		if (common_node2 == null) {
			System.out.println("No such Node found");
		} else {
			System.out.println(common_node2.data);
		}
	}

	public static Node findIntersectionNode(SingleLinkedList l1,
			SingleLinkedList l2) {

		int length_list1 = l1.length();
		int length_list2 = l2.length();

		int offset = 0;

		// check if 1st list is greater in length
		if (length_list1 > length_list2) {
			offset = length_list1 - length_list2;
			return findCommonNode(l1, l2, offset);

		}
		// check if second list is greater in length
		else if (length_list2 > length_list1) {
			offset = length_list2 - length_list1;
			return findCommonNode(l2, l1, offset);
		} else {
			// case when both the list are of same length
			return findCommonNode(l1, l2, 0);
		}

	}

	public static Node findCommonNode(SingleLinkedList l1, SingleLinkedList l2,
			int offset) {

		Node headA = l1.head;
		Node headB = l2.head;

		if (offset != 0) {
			// move l1 by offset times
			for (int i = 1; i <= offset; i++) {
				headA = headA.next;
			}
		}

		while (headA.next != null && headB.next != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}

		// the node is not present
		return null;
	}
}
