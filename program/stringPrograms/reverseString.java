package programs.program.stringPrograms;

public class reverseString {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter a string which you have to reverse:");
//		String input=sc.nextLine();
//		String output="";
//		for(int i=input.length()-1;i>=0;i--) {
//			output=output+input.charAt(i);
//
//		}
		String str = new String("hello");
		char[] ch = str.toCharArray();
		int i = 0;
		int j = str.length()-1;
		while(i<j) {
			swap(ch[i],ch[j]);
			i++;
			j--;
		}

		System.out.println(ch);
	}

	private static void swap(char ch, char ch1) {
		char temp = 0; // ch = 5, ch1 = 10
		temp = ch; //temp = 5
		ch = ch1; //ch = 10
		ch1 = temp; //ch1 = 5
	}

}
