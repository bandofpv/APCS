
public class Tile{

	public static void main(String args[]){
		Tile tile = testTile();

		printTile(tile);

		System.out.println(tile.equals(testTile()) + " "+ tile.getLetter() + " " + tile.getValue());

		System.out.println(tile.toString());
	}

	private char letter;

	private int value;

	public Tile(char letter, int value){

		this.letter = letter;
		this.value = value;
	}

	public static void printTile(Tile a){

		System.out.println("Tile "+a.letter+" and "+a.value);

	}

	public static Tile testTile(){

		Tile a = new Tile('Z', 10);

		printTile(a);

		return a;
	}

	public String toString(){

		return "Tile "+this.letter+" and "+this.value;
	}

	public boolean equals(Tile a){

		return this.letter == a.letter && this.value == a.value;
	}

	public char getLetter(){

		return this.letter;
	}

	public void setLetter(char letter){

		this.letter = letter;

	}

	public int getValue(){

		return this.value;

	}

	public void setValue(int value){
		this.value = value;

	}
}
