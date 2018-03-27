
public class Card {
	String pass;
	int suit;
	int val;
	
	public Card(String a) {
		pass = a;
		String suitstr = a.substring(0,1);
		String valstr = a.substring(1);
		
		if (suitstr.equals("S")) { suit = 4; }
		if (suitstr.equals("H")) { suit = 3; }
		if (suitstr.equals("D")) { suit = 2; }
		if (suitstr.equals("C")) { suit = 1; }
		
		if (valstr.equals("A")) { val = 14; }
		else if (valstr.equals("K")) { val = 13; }
		else if (valstr.equals("Q")) { val = 12; }
		else if (valstr.equals("J")) { val = 11; }
		else { val = Integer.parseInt(valstr); }
	}
}
