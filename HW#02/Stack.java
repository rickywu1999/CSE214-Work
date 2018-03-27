public class Stack<T> {
	public class Node<T> {
		private T data;
		Node<T> next;
		
		public Node() {
			data = null;
			next = null;
		}
		public Node(T d, Node<T> l) {
			data = d;
			next = l;
		}
	}
	
	protected Node<T> top;
	
	public Stack() { top = null; }
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(T data) { top = new Node<T>(data,top); }
	
	public T pop() throws Exception {
		if (isEmpty()) 
			throw new Exception("Stack is empty");
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public T peek() throws Exception {
		if (isEmpty()) 
			throw new Exception("Stack is empty");
		return top.data;
	}
}
