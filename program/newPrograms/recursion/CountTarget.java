package programs.program.newPrograms.recursion;

public class CountTarget {

    public static void targetCount(int[] arr,  int i, int target, int count) {
        if(i >= arr.length) {
            System.out.println(count);
            return;
        }

        if(arr[i] == target) {
            count++;
        }

        targetCount(arr, i + 1, target, count);

    }

    public static void main(String[] args) {
        int[] arr = {20,60,56,29,78,20,20};
        int i = 0;
        int target = 20;
        int count = 0;
        targetCount(arr, i, target, count);


    }
}
