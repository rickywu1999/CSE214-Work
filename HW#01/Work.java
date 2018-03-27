import java.util.Arrays;

public class Work {

	public static void main(String[] args) {
		int a[] = {11, 15, 6, 8, 9, 10};
		
		System.out.println("1a.");
		System.out.println("searchpair(" + Arrays.toString(a) + ", " + "16)");
		System.out.println(searchpair(a,16));
		System.out.println("searchpair(" + Arrays.toString(a) + ", " + "27)");
		System.out.println(searchpair(a,27));
		System.out.println("");
		
		System.out.println("1b.");
		System.out.println("searchtriple(" + Arrays.toString(a) + ", " + "25)");
		System.out.println(searchtriple(a,25));
		System.out.println("searchtriple(" + Arrays.toString(a) + ", " + "39)");
		System.out.println(searchtriple(a,39));
		System.out.println("");
		
		CreditCard card = new CreditCard("123456789012", "Ricky Wu", "TDBank", 400, 1000);
		System.out.println(card);
		System.out.println("-Buys a $500 TV");
		card.chargeIt(500);
		System.out.println(card);
		System.out.println("-Buys a $300 TV");
		card.chargeIt(300);
		System.out.println(card);
		System.out.println("-Payment of $100");
		card.payment(100);
		System.out.println(card);
		System.out.println("");
	}
	/*
	1. Complexity Analysis:
		a. Write a short Java program that takes an array of int values as input and find if there is a pair
		of numbers with a given sum. What is the total number of operations that occur in terms of
		input size n in closed form for worst case scenario. What is the time complexity in Big
		O-notation?
	*/
	public static boolean searchpair(int[] a,int b){
		for (int i = 0; i < a.length; i++) {					
			for(int j = 0; j < a.length && j != i; j++) {
				if (a[i] + a[j] == b)
					return true;
			}
		}
		return false;
	}
	//Time complexity: O(n^2)
	
	/*
	 	b. Write a short Java program that takes an array of int values as input and find if there is a
		triplet of numbers with a given sum. What is the total number of operations that occur in
		terms of input size n in closed form for worst case scenario. What is the time complexity in
		Big O-notation?
	 */
	public static boolean searchtriple(int[] a,int b){
		for (int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length && j != i; j++) {
				for (int k = 0; k < a.length && k != i && k!= j; k++) {
					if (a[i] + a[j] + a[k] == b)
						return true;
				}
			}
		}
		return false;
	}
	//Time complexity: O(n^3)
	
	
	
}
