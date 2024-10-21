package programs.program.stringPrograms;

public class reverseSentenceWords {
    public static void main(String[] args) {
        String str = "we are learning java"; //4 index = 3
        //reverse sentence = java learning are we
        String[] arr = str.split(" ");
        String reverseString = "";
        for(int i=arr.length-1; i>=0; i--){
            reverseString = reverseString + arr[i] + " ";
        }
        System.out.println(reverseString);
    }
}
