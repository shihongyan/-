public class test_392 {
    public static boolean isSubsequence(String s, String t) {
        char [] a=s.toCharArray();
        char [] b=t.toCharArray();
        int x=0,y=0;
        while(x<a.length&&y<b.length){
            if(a[x]==b[y]){
                x+=1;
            }
            y+=1;
        }
        if(x==a.length)
            return true;
        else
        return false;
    }
    public static void main(String [] args){
        String a="wto";
        String b="qwertyuiop";
        System.out.println(isSubsequence(a,b));
    }
}
