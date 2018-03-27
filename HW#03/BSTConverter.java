import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

public class BSTConverter {
	
	int[] BT;
	int[] goal;
	int[] inorder;
	int inorderS;
	int size;
	int ans;

	public BSTConverter(int[] BinTree, int s) {
		BT = BinTree;
		Arrays.sort(BinTree);
		goal = BinTree;
		size = s;
		inorder = new int[size];
		inorderS = 0;
	}
	
	//a recursive method that saves inorder print of BT in another array
	public void makeInorder(int index) {
		if (index>=size) {
			return;
		}
		makeInorder(index*2+1);
		inorder[inorderS] = BT[index];
		inorderS++;
		makeInorder(index*2+2);
	}
	public int countSwaps() {
		makeInorder(0);
		int ans = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				if (inorder[j] == goal[i]) {
					int save = inorder[i];
					inorder[i] = goal[i];
					inorder[j] = save;
					ans++;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
		String filename;
		if (args.length < 1) {filename = "in2.txt";}
		else {filename = args[0];}
		
		Scanner sc = new Scanner(new File(filename));
		int inputs = Integer.parseInt(sc.nextLine());
		for (int a = 0; a < inputs; a++) {
			int size = Integer.parseInt(sc.nextLine());
			String nameStr = sc.nextLine();
			String[] namesSL = nameStr.split(" ");
			int[] nums = new int[namesSL.length];
			for(int i = 0; i <namesSL.length;i++) {
				nums[i] = Integer.parseInt(namesSL[i]);
			}
		
			BSTConverter BT= new BSTConverter(nums,size);
			System.out.println("Inputs:");
			System.out.println(size);
			System.out.println(nameStr);
			System.out.println("Outputs:");
			System.out.println(BT.countSwaps());
		}
		sc.close();
	}

}
