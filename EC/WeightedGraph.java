import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeightedGraph {
	int[][] graph;
	int size;
	
	public WeightedGraph(int[][] g, int si) {
		graph = g;
		size = si;
	}
	
	public int shortestPath(int start, int dest) {
		if (size <= 1) {return 0;}
		if (start == dest) {return 0;}
		
		int[] distance = new int[size];
		for (int i = 0; i < size; i++) {distance[i] = Integer.MAX_VALUE;}
		distance[start] = 0;
		
		int[] S = new int[size];
		int[] parent = new int[size];
		for (int i = 0; i < size; i++) {
			S[i] = -1;
			parent[i] = -1;
		}
		
		int filled = 0;
		
		while (filled < size) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < size; i++) {
				if (S[i] == -1 && distance[i] < min) {
					min = distance[i];
					index = i;
				}
			}	
			S[index] = 1;
			filled ++;
			for (int i = 0; i < size; i++) {
				if (graph[index][i] > 0) {
					int sum = distance[index] + graph[index][i];
					if (sum < distance[i]) { 
						distance[i] = sum;
						parent[i] = index;
					}
				}
			}
		}
		String path = dest + "";
		for (int i = parent[dest]; i != start; i = parent[i]) {
			path = i + "->" + path;
		}
		path = start + "->" + path;
		System.out.println(path);
		return distance[dest];
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		String filename;
		if (args.length < 1) {filename = "in1.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		WeightedGraph wg;
		for (int i = 0; i < inputs; i++) {
			
			int size = Integer.parseInt(sc.nextLine());
			String stuff = sc.nextLine();
			String[] stuffS = stuff.split(" ");
			int start = Integer.parseInt(stuffS[0]);
			int dest = Integer.parseInt(stuffS[1]);
			
			int[][] prison = new int[size][size];
			
			String print = "";
			if (size <= 1) {
				System.out.println("Input:");
				System.out.println(size);
				System.out.println("");
				System.out.println("Output:");
				System.out.println("0");
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
			
			wg = new WeightedGraph(prison,size);
			
			System.out.println("Input:");
			System.out.println(size);
			System.out.println(print);
			System.out.println("Output:");
			System.out.println(wg.shortestPath(start,dest));
			System.out.println("");
		}
		sc.close();

	}

}
