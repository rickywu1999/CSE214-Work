import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrisonBreak {
	int[][] prison;
	int size;
	
	public PrisonBreak(int[][] p, int s) {
		prison = p;
		size = s;
	}
	
	public int countPaths() {
		if (size < 2)
			return 0;
		if (prison[0][0] == 1) 
			return 0;
		if (prison[size-1][size-1] == 1) 
			return 0;
		return path(0, 0);
	}
	
	public int path(int x, int y) {
		if (x < 0 || y < 0 || x >= size || y >= size)
			return 0;
		if (prison[x][y] == 1)
			return 0;
		if (x == size-1 && y == size-1)
			return 1;
		int ans = 0;
		prison[x][y] = 1;
		ans += path(x+1,y);
		ans += path(x-1,y);
		ans += path(x,y+1);
		ans += path(x,y-1);
		prison[x][y] = 0;
		return ans;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename;
		if (args.length < 1) {filename = "in1.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		PrisonBreak pb;
		for (int i = 0; i < inputs; i++) {
			
			int size = Integer.parseInt(sc.nextLine());
			int[][] prison = new int[size][size];
			
			String print = "";
			if (size < 1) {
				System.out.println("Input:");
				System.out.println(size);
				System.out.println("");
				System.out.println("Output:");
				System.out.println("0");
				System.out.println("");
				continue;
			}
			for (int j = 0; j < size; j++) {
				String numStr = sc.nextLine();
				print += numStr + "\n";
				String[] numSL = numStr.split(" ");
				for (int k = 0; k < numSL.length; k++)
					prison[j][k] = Integer.parseInt(numSL[k]);
			}
			
			pb = new PrisonBreak(prison,size);
			
			System.out.println("Input:");
			System.out.println(size);
			System.out.println(print);
			System.out.println("Output:");
			System.out.println(pb.countPaths());
			System.out.println("");
		}
		sc.close();
	}
}
