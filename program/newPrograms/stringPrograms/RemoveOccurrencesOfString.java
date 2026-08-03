package programs.program.newPrograms.stringPrograms;

public class RemoveOccurrencesOfString {

    public static String removeOccOfSubpart(String s, String subpart) {
        while(s.contains(subpart)) {
            int index = s.indexOf(subpart);
            s = s.substring(0,index)  + s.substring(index+subpart.length());
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "pqxyxmypqxyx";
        String subpart = "pq";
        String ans = removeOccOfSubpart(s, subpart);
        System.out.println(ans);

    }


}
