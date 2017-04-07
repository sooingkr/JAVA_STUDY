package _7_Class;

class Card {
	String kind;
	String number;

	Card() {
		this("", "");
	}

	Card(String kind, String number) {
		this.kind = kind;
		this.number = number;
	}

	void printCard() {
		System.out.println("카드 : " + this.kind + " " + this.number);
	}
}

class CardGame {
	Card[] card;

	CardGame() {
		card = new Card[52];
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++, k++) {
				if (i == 0) {
					card[k] = new Card("◆", Integer.toString(j));

				} else if (i == 1) {
					card[k] = new Card("♥", Integer.toString(j));
				} else if (i == 2) {
					card[k] = new Card("♠", Integer.toString(j));
				} else if (i == 3) {
					card[k] = new Card("♣", Integer.toString(j));
				}
			}
		}

	}

	void shuffle() {
		for (int i = 0; i < card.length * 2; i++) {
			int r = (int) (Math.random() * 52);
			Card temp = card[0];
			card[0] = card[r];
			card[r] = temp;
		}
	}

	void printCard() {
		for (int i = 0; i < 13; i++) {
			System.out.print(card[i].kind + " " + card[i].number);
		}
		System.out.println();
	}

	void printCard(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(card[i].kind + " " + card[i].number);

		}
		System.out.println();
	}
}

public class _7_Class_ex {

	public static void main(String[] args) {

		CardGame manage = new CardGame();
		manage.shuffle();
		manage.printCard();
		manage.printCard(5);

	}

}
