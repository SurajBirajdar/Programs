package programs.program.stringPrograms;

public class FrequencyEachCharacterWithoutHashMap {
    // Given a string calculate frequency of each character without HashMap

    public static void main(String[] args) {

        String s1 = "surajs";
        char[] arr = s1.toCharArray();
        int fr[] = new int[arr.length];

        int visited = -1;
        int count = 1;

        for (int i = 0; i < arr.length; ++i) {
            count = 1;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] == arr[j]) {
                    ++count;
                    fr[j] = visited;
                }
            }
            if (fr[i] != visited) {
                fr[i] = count;
            }
        }

        for (int i = 0; i < fr.length; ++i) {
            if (fr[i] != visited) {
                System.out.println(arr[i] + "-->" + fr[i]);
            }
        }

    }
}
