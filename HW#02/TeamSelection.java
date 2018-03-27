import java.io.File;
import java.util.Scanner;

public class TeamSelection {
	QueueI names;
	QueueI heights;
	
	public TeamSelection(int[] n, int[] h) {
		names = new QueueI();
		heights = new QueueI();
		for (int i: n) { names.enqueue(i); }
		for (int j: h) { heights.enqueue(j); }
	}
	
	public QueueI eliminate() {
		if (names.getSize() < 2) {
			return names;
		}
		int size = names.getSize();
		for (int i = 0; i < size-1; i++) {
			int h1 = heights.dequeue();
			int h2 = heights.peek();
			if (h2 > h1) {
				names.dequeue();
			}
			else {
				names.enqueue(names.dequeue());
				heights.enqueue(h1);
			}
		}
		names.enqueue(names.dequeue());
		return names;
	}
	
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length < 1) {filename = "in2.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		TeamSelection ts;
		String print;
		for (int i = 0; i < inputs; i++) {
			print = "";
			
			String nameStr = sc.nextLine();
			String heightStr = sc.nextLine();
			String[] namesSL = nameStr.split(" ");
			String[] heightSL = heightStr.split(" ");
			int[] names = new int[namesSL.length];
			int[] heights = new int[heightSL.length];
			
			for (int j = 0; j < namesSL.length; j++) {
				names[j] = Integer.parseInt(namesSL[j]);
				heights[j] = Integer.parseInt(heightSL[j]);
			}
			
			ts = new TeamSelection(names,heights);
			
			QueueI ans = ts.eliminate();
			
			while(!ans.isEmpty()) {
				print += ans.dequeue() + " ";
			}
			System.out.println("Input:");
			System.out.println(nameStr);
			System.out.println(heightStr);
			System.out.println("");
			System.out.println("Output:");
			System.out.println(print);
			System.out.println("");
		}
	}

}
