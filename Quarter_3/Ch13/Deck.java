package Ch13;

import java.util.Arrays;
import java.util.Random;

/**
 * A deck of playing cards (of fixed size).
 */
public class Deck {

	private Card[] cards;
	private Random random = new Random();

	/**
	 * Constructs a standard deck of 52 cards.
	 */
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}

	/**
	 * Constructs a deck of n cards (null).
	 */
	public Deck(int n) {
		this.cards = new Card[n];
	}

	/**
	 * Gets the internal cards array.
	 */
	public Card[] getCards() {
		return this.cards;
	}

	/**
	 * Displays each of the cards in the deck.
	 */
	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}

	/**
	 * Returns a string representation of the deck.
	 */
	public String toString() {
		return Arrays.toString(this.cards);
	}

	/**
	 * Chooses a random number between low and high, including both.
	 */
	public int randomInt(int low, int high) {
		return random.nextInt((high - low) + 1) + low;
	}

	/**
	 * Swaps the cards at indexes i and j.
	 */
	public void swapCards(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp; 
	}

	/**
	 * Randomly permutes the array of cards.
	 */
	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			swapCards(i, randomInt(i, cards.length-1));
		}
	}

	/**
	 * Finds the index of the lowest card
	 * between low and high inclusive.
	 */
	public int indexLowest(int low, int high) {
		for (int i = low + 1; i < high + 1; i++) {
			if (cards[low].compareTo(cards[i]) > 0){
				low = i;
			}
		}
		return low;
	}

	/**
	 * Sorts the cards (in place) using selection sort.
	 */
	public void selectionSort() {
		for (int i = 0; i < cards.length -1; i++) {
			swapCards(i, indexLowest(i, cards.length -1));
		}
	}

	/**
	 * Returns a subset of the cards in the deck.
	 */
	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}

	/**
	 * Combines two previously sorted subdecks.
	 */
	public static Deck merge(Deck d1, Deck d2) {
		Card[] c1 = d1.getCards();
		Card[] c2 = d2.getCards();

		int length1 = c1.length;
		int length2 = c2.length;
		int a = 0;
		int b = 0;

		Card[] sort = new Card[length1 + length2];

		if (length1 == 0){
			sort = c2;
		} 

		else if (length2 == 0){
			sort = c1;
		}

		else {
			for (int k = 0; k < sort.length; k++){
				if (b >= c2.length || a < c1.length && c1[a].compareTo(c2[b]) <= 0){
					sort[k] = c1[a];
					a++;
				} 
				else {
					sort[k] = c2[b];
					b++;
				}

			}

		}

		Deck ret = new Deck(length1 + length2);
		ret.cards = sort;

		return ret;
	}

	/**
	 * Returns a sorted copy of the deck using merge sort.
	 */
	public Deck mergeSort() {
		int length = cards.length;

		if (length == 0 || length == 1){
			return this;
		} 

		else {
			int split = length / 2;

			Deck d1 = subdeck(0, split - 1);
			Deck d2 = subdeck(split, length -1);

			d1.selectionSort();
			d2.selectionSort();

			return merge(d1, d2);
		}
	}

	/**
	 * Reorders the cards (in place) using insertion sort.
	 */
	public void insertionSort() {
		for (int i=1;i<cards.length;i++){
	         for (int j=i; j>0;j--){
	            if (cards[j-1].compareTo(cards[j]) == 1){
	               swapCards(j-1,j);
	            } 
	            else {
	               break;
	            }
	         }
	      }
//		for i = 2:n,
//			    for (k = i; k > 1 and a[k] < a[k-1]; k--)
//			        swap a[k,k-1]
//			    → invariant: a[1..i] is sorted
//			end
	}

}
