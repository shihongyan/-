import java.util.Arrays;

public class test_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        if(target>=letters[letters.length-1])
            return letters[0];
        else{
            int start=0;
            while(start<letters.length){
                if(target>=letters[start]){
                   start++;
                }else{
                   break;
                }
            }
            return letters[start];
        }
    }
    public static void main(String [] args){
        char [] x={'c','f','j'};
        System.out.println(nextGreatestLetter(x,'c'));
    }
}
