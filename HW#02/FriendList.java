import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FriendList{
	int N,K;
	String[] names; 
	int[] mutual;
	
	public FriendList(int a,int b, String[] c, int[] d) {
		N = a;
		K = b;
		names = c;
		mutual = d;
	}
	
    //Step 1: bucketizes the numbers and returns a array of all the ranges; runtime (O(n))
	public int[][] bucketize() {
		int[] copy = new int[mutual.length];
		for (int i = 0; i < mutual.length; i++) { copy[i] = mutual[i]; }
		Arrays.sort(copy);
		int min = copy[0];
		int max = copy[copy.length-1];
		int seclen = (max-min+1)/K;
		int[][] ranges = new int[K][2];
		int _K = 0;
		for (int i = min; (i < max)||(_K<K); i++) {
			ranges[_K][0]= i;
			i += (seclen-1);
			ranges[_K][1]= i;
			_K++;
		}
		ranges[K-1][1] = max;
		//System.out.println("pass1");
		return ranges;
	}
	
    //Step #2: sort the numbers into the respective arrays
	public Queue[] replace(int[][] ranges) {
		Queue[] nameQ = new Queue[K];
		for (int i = 0; i < K; i++) {
			nameQ[i] = new Queue();
		}
		for (int j = 0; j < K; j++){
			
			int[] range = ranges[j];
			int[] mutualIn = new int[N];
			String[] namesIn = new String[N];
			int count = 0;
			
			for (int i = 0; i < mutual.length; i++) {
				if (mutual[i] >= range[0] && mutual[i] <= range[1]) {
					mutualIn[count] = mutual[i];
					namesIn[count] = names[i];
					count++;
				}
			}
			
			String[] ordered = order(mutualIn,namesIn);
			for (String a: ordered) { 
				if(a != null)
					nameQ[j].enqueue(a); 
			}
		}
		//System.out.println("pass2");
		return nameQ;
	}
	
	//bubble sort 
	public String[] order(int[] mutualL, String[] namesL) {
		for (int i = 0; i < namesL.length-1; i++) {
			for (int j = 0; j < namesL.length-1-i;j++) {
				if (mutualL[j] > mutualL[j+1]) {
					int copyI = mutualL[j];
					String copyS = namesL[j];
					
					mutualL[j] = mutualL[j+1];
					mutualL[j+1] = copyI; 
					
					namesL[j] = namesL[j+1];
					namesL[j+1] = copyS;
				}
			}
		}
		for(String a: namesL) {
			if (a != null) {
				//System.out.println(a);
			}
		}
		return namesL;
	}
	
    //Step 3: Go through each queue and find the friend to keep
	public Queue parse(Queue[] nameQ) {
		Queue ans = new Queue();
		for (Queue q: nameQ) {
			if (q.getSize() >= 1) {
				while(q.getSize() > 1) {
					for(int i = 0; i < K-1; i++) {
						q.enqueue(q.dequeue());
					}
					q.dequeue();
				}
				ans.enqueue(q.dequeue());
			}
		}
		//System.out.println("pass3");
		return ans;
	}
	
    //Step 4: order the friends in terms of order of original appearence
	public String reorder(Queue q) {
		
		String[] order = new String[N];
		while (!q.isEmpty()) {
			String goal = q.dequeue();
			int i;
			for (i = 0; i < names.length; i++) {
				if (names[i] == goal) {
					break;
				}
			}
			order[i] = goal;
		}
		
		String ans = "";
		for (String a: order) {
			if (a != null)
				ans += a + " ";
		}
		//System.out.println("pass4");
		return ans;
	}
	
	public String clean() {
		return reorder(parse(replace(bucketize())));
	}
	
	public static void main(String[] args) throws Exception {
		String filename;
		if (args.length < 1) {filename = "in1.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		
		FriendList fl;
		for (int i = 0; i < inputs; i++) {
			
			String nk = sc.nextLine();
			String[] nkl = nk.split(" ");
			int N = Integer.parseInt(nkl[0]);
			int K = Integer.parseInt(nkl[1]);
			
			String names = sc.nextLine();
			String[] namesl = names.split(" ");
			
			String mutual = sc.nextLine();
			String[] mutual_sl = mutual.split(" ");
			int[] mutual_il = new int[mutual_sl.length];
			for (int j = 0; j < mutual_sl.length; j++) {
				mutual_il[j] = Integer.parseInt(mutual_sl[j]);
			}
			
			fl = new FriendList(N, K, namesl, mutual_il);
			
			System.out.println("Input:");
			System.out.println(nk);
			System.out.println(names);
			System.out.println(mutual);
			System.out.println("");
			System.out.println("Output:");
			System.out.println(fl.clean());
			System.out.println("");
		}
	}
}







