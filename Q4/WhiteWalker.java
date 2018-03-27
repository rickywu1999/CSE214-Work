import java.io.File;
import java.util.Scanner;

public class WhiteWalker {
	int N,M;
	QueueI power;
	
	public WhiteWalker(int a, int b, int[] c){
		power = new QueueI();
		N = a;
		M = b;
		for (int i: c) {power.enqueue(i);}
	}
	public QueueI pickem() {
		QueueI ans = new QueueI();
		QueueI ind = new QueueI();
		for (int x = 0; x < N; x++)
			ind.enqueue(x);
		
		for (int a = 0; a < M; a++) {// M loop
			int[] storage = new int[M];
			int[] index = new int[M];
			int count = 0;
			int limit = Math.min(M, power.getSize());
			for (int i = 0; i < limit; i++) {//usually N or less than N
				storage[count] = power.dequeue();
				index[count] = ind.dequeue();
				count++;
			}
			
			int maxInd = findMax(storage);
			ans.enqueue(index[maxInd]);
			int[][] pack = powerDown(storage, index, maxInd);
			storage = pack[0];
			index = pack[1];
			count--;
			
			String str = "";
			for (int b: storage) {//N or smaller
				str += (b+ " ");
			}
			str += "\n";
			for (int b: index) {//N or smaller
				str += (b+ " ");
			}
			for (int i = 0; i < count; i++) {//count is < N
				power.enqueue(storage[i]);
				ind.enqueue(index[i]);
			}
		}
		return ans;
	}
	
	public int findMax(int[] storage) {//used in pickem has a loop using storage length which is N or smaller
		int ans = 0;
		for (int i = 1; i < storage.length; i++) {
			if (storage[i] > storage[ans])
				ans = i;
		}
		return ans;
	}
	
	public int[][] powerDown(int[] storage, int[] index, int maxInd){//used in pickem, loop same as findMax
		
		int done = 0;
		int count = 0;
		int[] newSt = new int[storage.length-1];
		int[] newIn = new int[storage.length-1];
		int max = storage[maxInd];
		
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == max && done == 0) {
				done = 1;
			}
			else if (storage[i] >= 0){
				if (storage[i] == 0) {newSt[count] = 0;}
				else { newSt[count] = storage[i] - 1;}
				newIn[count] = index[i];
				count++;
			}
		}
		int[][] ans = new int[2][];
		
		ans[0] = newSt;
		ans[1] = newIn;
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length < 1) {filename = "in4.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		WhiteWalker ww;
		String print;
		for (int i = 0; i < inputs; i++) {
			print = "";
			String nm = sc.nextLine();
			String[] nml = nm.split(" ");
			int N = Integer.parseInt(nml[0]);
			int M = Integer.parseInt(nml[1]);
			
			String str = sc.nextLine();
			String[] strl = str.split(" ");
			int[] power = new int[strl.length];
			for (int a = 0; a < strl.length; a++) {
				power[a] = Integer.parseInt(strl[a]);
			}
			
			ww = new WhiteWalker(N,M,power);
			QueueI ans = ww.pickem();
			
			while(!ans.isEmpty()) {
				print += (ans.dequeue() + " ");
			}
			
			
			System.out.println("Input:");
			System.out.println(nm);
			System.out.println(str);
			System.out.println("");
			System.out.println("Output:");
			System.out.println(print);
			System.out.println("");
		}
	}

}
