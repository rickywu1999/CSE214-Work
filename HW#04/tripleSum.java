import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class tripleSum {
	int size,special;
	int[] nums;
	HashMap<Integer,Integer> hash,copy;
	
	public tripleSum(int[] n, int si, int sp) {
		nums = n;
		size = si;
		special = sp;
		hash = new HashMap<Integer,Integer>();
		copy = new HashMap<Integer,Integer>();
		for (int i = 0; i< special; i++) {
			hash.put(i, 0);
			copy.put(i, 0);
		}
		for (int i = 0; i < size; i++) {
			int x = nums[i]%special;
			hash.put(x, hash.get(x) + 1);
			copy.put(x, hash.get(x));
		}
	}
	
	public int tripleNum() {
		int ans = 0;
		for (int i = 0; i < size; i++) {//O(n)
			
			for (int x = 0; x < special; x++) {copy.put(x,hash.get(x));}
			int one = nums[i]%special;
			
			for (int j = i+1; j < size; j++) {//O(n)
				int two = nums[j]%special;
				int goal = special - ((one + two) % special);
				if (goal == special) { goal = 0; }
				ans += copy.get(goal);
				if (one == goal) {ans--;}
				if (two == goal) {ans--;}
				copy.put(two,copy.get(two) - 1);
			}
			
			hash.put(one,hash.get(one) - 1);
		}
		return ans;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename;
		if (args.length < 1) {filename = "in2.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		tripleSum sum;
		
		while(sc.hasNextLine()) {
			
			String numStr = sc.nextLine();
			String[] numSL = numStr.split(" ");
			String numStr2 = sc.nextLine();
			String[] numSL2 = numStr2.split(" ");
			int size = Integer.parseInt(numSL[0]);
			int target = Integer.parseInt(numSL[1]);
			
			if (size < 3) {
				System.out.println("Input:");
				System.out.println(numStr);
				System.out.println(numStr2);
				System.out.println("");
				System.out.println("Output:");
				System.out.println("0");
				continue;
			}
			int[] nums = new int[numSL2.length];
			
			for (int j = 0; j < numSL2.length; j++) {
				nums[j] = Integer.parseInt(numSL2[j]);
			}
			
			sum = new tripleSum(nums,size,target);
			int ans = sum.tripleNum();
			
			System.out.println("Input:");
			System.out.println(numStr);
			System.out.println(numStr2);
			System.out.println("");
			System.out.println("Output:");
			System.out.println(ans);
			System.out.println("");
		}
		sc.close();
	}
}










