
public class Heap {
	private int[] data; 
	private int size; 
	private int max;
	
	public Heap(int s) { 
		if (s < 1) max = 100;
		else max = s;
		data = new int[max];
		size = 0;
	}
	public boolean isEmpty(){
		if(size == 0)return true;
		else return false;
	}
	public boolean isFull(){
		if(size == max) return true;
		else return false;
	}
	public void insert(int item) throws Exception {
		int position;
		if (isFull()) throw new Exception();
		data[size] = item;
		size++;
		position = size - 1;
		while (position > 0 && data[position] > data[(position-1)/2]){
			swap(position, (position-1)/2);
			position = (position-1) / 2;
		}
	}
	public int delete() throws Exception{
		int answer;
		if (isEmpty()) throw new Exception();
		answer = data[0];
		data[0] = data[size-1];
		size--;
		heapify();
		return answer;
	}
	
	private void heapify() {
		int position = 0; int childPos;
		while (position*2 + 1 < size) {
			childPos = position*2 + 1;
			if (childPos < size-1 && data[childPos+1] > data[childPos])
				childPos++;
			if (data[position]>= data[childPos])
				return;
			swap(position, childPos);
			position = childPos;
		}
	}
	
	private void swap(int pos1,int pos2) {
		int save = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = save;
	}
}