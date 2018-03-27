import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class findSum {
	
	int[] nums;
	int target;
	int size;
	
	public findSum(int[] n, int t, int s) {
		nums = n;
		target = t;
		size = s;
	}
	
	public int[] twoSum() {
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		for (int i = 0; i< size;i++) {
			int partner = target - nums[i];
			if (hash.containsKey(partner)) {
				int[] ans = new int[2];
				ans[1] = i;
				ans[0] = hash.get(partner);
				return ans;
			}
			hash.put(nums[i], i);
		}
		int[] ans = new int[2];
		ans[0] = -1;
		ans[1] = -1;
		return ans;
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		String filename;
		if (args.length < 1) {filename = "in1.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		
		findSum sum;
		while(sc.hasNextLine()) {
			
			String numStr = sc.nextLine();
			String[] numSL = numStr.split(" ");
			String numStr2 = sc.nextLine();
			String[] numSL2 = numStr2.split(" ");
			int size = Integer.parseInt(numSL[0]);
			int target = Integer.parseInt(numSL[1]);
			
            if (size < 2) {
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
			
			sum = new findSum(nums,target,size);
			int[] ans = sum.twoSum();
			
			System.out.println("Input:");
			System.out.println(numStr);
			System.out.println(numStr2);
			System.out.println("");
			System.out.println("Output:");
			System.out.println(ans[0]+ " " + ans[1]);
			System.out.println("");
		}
		sc.close();
	}
}
