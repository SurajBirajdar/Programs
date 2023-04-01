import java.util.Scanner;

public class reverseString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string which you have to reverse:");
		String input=sc.nextLine();
		String output="";
		for(int i=input.length()-1;i>=0;i--) {
			output=output+input.charAt(i);
			
		}
		System.out.println(output);
	}

}
