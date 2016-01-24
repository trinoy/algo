package cs5800.hw1;

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}


public class SingleLinkedList {

	Node head;

	public SingleLinkedList() {
		this.head = null;
	}

	// insert the element at the start of the list
	public void insertAtStart(int data) {
		Node new_node = new Node(data);
		// new_node.next = null;

		if (head == null) {
			head = new_node;
		} else {

			new_node.next = head;
			head = new_node;
		}
	}

	// append a given list at the end of the current list
	public void InsertListAtEnd(SingleLinkedList list) {

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = list.head;
	}

	// display all the nodes of the list
	public void displayList() {
		Node current = head;
		int count = 1;
		while (current != null) {
			System.out.print("Node" + count);
			System.out.println(" " + current.data);
			current = current.next;
			count++;
		}
	}

	// get the length of the list
	public int length() {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

}
