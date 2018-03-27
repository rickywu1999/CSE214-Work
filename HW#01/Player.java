
public class Player {
	int id;
	Card[] cards;
	
	public Player(int a) {
		id = a;
	}
	
	public void setCards(Card[] c) {
		cards = c;
	}
	
	public void printCards() {
		String ret = "";
		for (Card a : cards) {
			ret += a.pass + " ";
		}
		System.out.println(ret);
	}
	
	public Card bigger(Card a, Card b) {
		if (a.suit > b.suit) { return a; }
		if (a.suit < b.suit) { return b; }
		else {
			if (a.val > b.val) { return a; }
			return b;
		}
	}
	
	public void sortCards() {
		for (int i = 0; i < cards.length - 1; i++) {
			Card biggest = cards[i];
			int index = i;
			for (int j = i; j < cards.length; j++) {
				biggest = bigger(cards[j],biggest);
				if (biggest == cards[j]) { index = j; }
			}
			cards[index] = cards[i];
			cards[i] = biggest;
		}
	}
}
