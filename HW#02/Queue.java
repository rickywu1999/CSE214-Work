public class Queue {
	private class Node {
		String data;
		Node next;
		
		public Node() {
			data = null;
			next = null;
		}
		public Node(String d, Node l) {
			data = d;
			next = l;
		}
	}
	
	private Node front,back;
	private int size;
	
	public Queue() { 
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
	
	public void enqueue(String data) { 
		Node oldBack = back;
		back = new Node(data,null);
		if (isEmpty())
			front = back;
		else
			oldBack.next = back;
		size++;
	}
	
	public String dequeue() {
		String item = front.data;
		front = front.next;
		if (isEmpty()) back = null;
		size--;
		return item;
	}
}
