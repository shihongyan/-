import java.util.Stack;

public class test_20 {
    public static boolean isValid(String s) {
        char [] ch=s.toCharArray();
        Stack<String> st=new Stack<>();
        int l=0;
        while(l<ch.length){
            if(!st.empty()){
             String x=st.peek();
             if((x+ch[l]).equals("{}")||(x+ch[l]).equals("[]")||(x+ch[l]).equals("()")){
                 st.pop();
             }else{
                 st.push(ch[l]+"");
             }
            }else{
                st.push(ch[l]+"");
            }
            l++;
        }
        if(st.empty())
            return true;
        else return false;
    }
    public static void main(String [] args){
        String s="{{{}}";
        System.out.println(isValid(s));
    }
}
