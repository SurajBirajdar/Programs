package programs.program;

public class Count_Occurrence_Of_Specific_Word_In_Sentence {
	public static void main(String[] args) {
		//program to count occurrences of specific word in a sentence
		String sentence = "My name is Suraj is is";
		String [] words = sentence.split(" ");
		String specificWord = "is";
		int count=0;
		for ( int i=0; i<words.length; i++) {
		    if(words[i].equals(specificWord)){
		        count++;
		    }
		}
		System.out.println("Count of number of occurrences of word in a sentence is: " + count);
	}
}





