package Ch12;
/**
 * A standard playing card.
 */
public class Card {

	public static final String[] RANKS = {
			null, "Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};

	public static final String[] SUITS = {
			"Clubs", "Diamonds", "Hearts", "Spades"};

	private final int rank;

	private final int suit;

	/**
	 * Constructs a card of the given rank and suit.
	 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * @return a full 52 card deck
	 */
	
	public static Card[] makeDeck() {
		Card[] cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
		return cards;
	}

	/**
	 * Returns a negative integer if this card comes before
	 * the given card, zero if the two cards are equal, or
	 * a positive integer if this card comes after the card.
	 * Also takes Ace as higher than king
	 */
	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}
		if (this.rank < that.rank) {
			if (this.rank == 1) {
				return 1;
			} 

			else {
				return -1;
			}

		}

		if (this.rank > that.rank) {
			if (that.rank == 1) {
				return -1;
			} 

			else {
				return 1;
			}

		}

		return 0;

	}

	/**
	 * @param myCards 
	 * @return a histogram of the number of cards are in each suit
	 */
	public static int[] suitHist(Card[] myCards){
		int[] ret = new int[4];

		for (Card card : myCards){
			ret[card.getSuit()] += 1;
		}

		return ret;
	}

	/**
	 * @param myCards
	 * @return true if there is 5 or more cards in the same suit
	 * @return false if there is not 5 or more cards in the same suit
	 */
	public static boolean hasFlush(Card[] myCards) {
		
		for (int i : suitHist(myCards)) {
			
			if (i >= 5) return true;
			
		}
		
		return false;
	}

	/**
	 * Returns true if the given card has the same
	 * rank AND same suit; otherwise returns false.
	 */
	public boolean equals(Card that) {
		return this.rank == that.rank
				&& this.suit == that.suit;
	}

	/**
	 * Gets the card's rank.
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Gets the card's suit.
	 */
	public int getSuit() {
		return this.suit;
	}

	/**
	 * Returns the card's index in a sorted deck of 52 cards.
	 */
	public int position() {
		return this.suit * 13 + this.rank - 1;
	}

	/**
	 * Returns a string representation of the card.
	 */
	public String toString() {
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}

}
