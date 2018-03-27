import java.io.File;
import java.util.Scanner;

public class ConcertSeats {
	
	Heap seating;
	int rows,people;
	
	public ConcertSeats(int M, int N, int[] seats) throws Exception {
		rows = M;
		people = N;
		seating = new Heap(M);
		for(int i: seats) seating.insert(i);
	}
 
	public int sell() throws Exception {
		int ans = 0;
		for (int i = 0; i< people; i++) {
			int max = seating.delete();
			if (max <= 0) break;
			ans += max;
			seating.insert(max-1);
		}
		return ans;
	}
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length < 1) {filename = "in3.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		for (int a = 0; a< inputs; a++) {
			String MNStr = sc.nextLine();
			String[] MNSL = MNStr.split(" ");
			int M = Integer.parseInt(MNSL[0]);
			int N = Integer.parseInt(MNSL[1]);
		
			String numStr = sc.nextLine();
			String[] numSL = numStr.split(" ");
			int[] nums = new int[numSL.length];
			for(int i = 0; i <numSL.length;i++) {
				nums[i] = Integer.parseInt(numSL[i]);
			}
		
			ConcertSeats concert = new ConcertSeats(M,N,nums);
		
			System.out.println("Inputs:");
			System.out.println(MNStr);
			System.out.println(numStr);
			System.out.println("Outputs:");
			System.out.println(concert.sell());
		}
		sc.close();
	}

}
