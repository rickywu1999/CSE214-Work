public class QueueI {
	private class Node {
		int data;
		Node next;
		
		public Node() {
			next = null;
		}
		public Node(int d, Node l) {
			data = d;
			next = l;
		}
	}
	
	private Node front,back;
	private int size;
	
	public QueueI() { 
		front = null; 
		back = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void enqueue(int data) { 
		Node oldBack = back;
		back = new Node(data,null);
		if (isEmpty())
			front = back;
		else
			oldBack.next = back;
		size++;
	}
	
	public int peek() {
		return front.data;
	}
	
	public int dequeue() {
		int item = front.data;
		front = front.next;
		if (isEmpty()) back = null;
		size--;
		return item;
	}
}