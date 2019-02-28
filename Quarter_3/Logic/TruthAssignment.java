package Logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TruthAssignment{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TruthAssignment truthAs = new TruthAssignment();
		System.out.println(truthAs + "\n");
		System.out.println(truthAs.getTruthProp("a") + "\n");
		
		LogicalSentence[] arr;  
		arr = new LogicalSentence[2]; 
		arr[0]= new LogicalSentence("a||b");  
		arr[1]= new LogicalSentence("a&&b");
		
		TruthAssignment truthLogic = new TruthAssignment(arr);
		System.out.println(truthLogic + "\n");
		truthLogic.print();
		System.out.println(truthLogic.getTruthLogic(arr[0]) + "\n");
		
		PropositionConstant[] pr;  
		pr = new PropositionConstant[1]; 
		pr[0]= new PropositionConstant("c"); 
		
		TruthAssignment truthPR = new TruthAssignment(pr);
		System.out.println(truthPR + "\n");
		System.out.println(truthPR.getPC(pr[0]) + "\n");
	}

	//A default constructor that produces a truth assignment that maps any proposition constant to false.

	public Map<String,Boolean> ta = new HashMap<String,Boolean>(); 
	
	public TruthAssignment(){

		this.ta.put("a", false); 
	}
	
	//A constructor that takes an array of Strings representing proposition constants and maps them all to false
	public TruthAssignment(String[] str) {
		for(int i = 0; i < str.length; i++) {
			this.ta.put(str[i], false);
		}
	}
	
	//A constructor that takes an array of LogicalSentences which are assumed to be of type "simple" and maps them all to false.
	public TruthAssignment(LogicalSentence[] str) {
		for(int i = 0; i < str.length; i++) {
			this.ta.put(str[i].toString(), false);
		}
	}
	
	//A constructor that takes an array of YOUR CHOICE (of items that represent proposition constants) and an array of booleans and maps the proposition constants to the corresponding truth value.
	public TruthAssignment(String[] str, boolean[] bool) {
		for(int i = 0; i < str.length; i++) {
			this.ta.put(str[i], bool[i]);
		}
	}
	
	//A constructor that takes an array of PropositionConstants and maps them all to false
	public TruthAssignment(PropositionConstant[] pr) {
		for(int i = 0; i < pr.length; i++) {
			this.ta.put(pr[i].toString(), false);
		}
	}
	
	//A method that takes a string representing a proposition constant and returns the truth value for the TruthAssignment.
	public boolean getTruthProp(String str) {
		return this.ta.get(str);
	}

	//A method that takes a LogicalSentence representing a proposition constant and returns the truth value for the TruthAssignment.
	public boolean getTruthLogic(LogicalSentence ls) {
		return this.ta.get(ls.toString());
	}

	//A method that takes an object of type PropositionConstant (which you must create the class for) representing a proposition constant and returns the truth value for the TruthAssignment.
	public boolean getPC(PropositionConstant pr) {
		return this.ta.get(pr.toString());
	}
	
	public String toString() {
		Set<Map.Entry<String,Boolean>> st = ta.entrySet();
        for(Map.Entry<String,Boolean> me:st) {

            return "Key="+me.getKey()+", Value="+me.getValue();
        }
        return "";
	}
	
	public void print() {
		Set<Map.Entry<String,Boolean>> st = ta.entrySet();
		for(Map.Entry<String,Boolean> me:st) {

            System.out.println("Key="+me.getKey()+", Value="+me.getValue());
        }
	}

}

