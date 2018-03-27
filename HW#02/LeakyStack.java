import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeakyStack extends Stack<String>{
	int limit;
	int size;
	
	public LeakyStack(int lim) throws Exception {
		super();
		if (lim < 1)
			throw new Exception("Invalid Stack Size");
		limit = lim;
		size = 0;
	}
	
	public void push(String a) {
		if (limit == 1) {
			top = new Node<String>(a,null);
			return;
		}
		else if (size >= limit) {
			Node<String> copy = top;
			for (int i = 1; i < limit-1; i++) {
				copy = copy.next;
			}
			copy.next = null;
			size--;
		}
		super.push(a);
		size++;
	}
	
	public String pop() throws Exception {
		size--;
		return super.pop();
	}
	
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length < 1) {filename = "in3.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		LeakyStack ls;
		int limit;
		String print;
		for (int i = 0; i < inputs; i++) {
			print = "";
			limit = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			String[] strl = str.split(" ");
			ls = new LeakyStack(limit);
			for (String a:strl)
				ls.push(a);
			while(!ls.isEmpty()) {
				print += ls.pop() + " ";
			}
			System.out.println("Input:");
			System.out.println(limit);
			System.out.println(str);
			System.out.println("");
			System.out.println("Output:");
			System.out.println(print);
			System.out.println("");
		}
	}
}
