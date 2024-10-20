package programs.program.arrayPrograms;

public class GreatestElementInArray {
    public static void main(String[] args) {
        int [] arr = {23, 67, 25, 12, 89};
        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
