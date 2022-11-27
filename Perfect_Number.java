package programs;


public class Perfect_Number
{
	public static void main(String[] args) {
		// perfect number e.g 28 = 1+2+4+7+14
		
		int number =28;
		int sum=0;
		for(int i=1; i<28; i++) {
		    if(number%i==0) {
		        System.out.println(i);
		        sum= sum + i;
		    }
		}
		if(sum==number) {
		    System.out.println("perfect number");
		}
		else {
		    System.out.println("not a perfect number");
		}
	}
}


