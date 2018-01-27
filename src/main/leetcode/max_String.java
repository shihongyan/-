import java.util.HashMap;
import java.util.Map;

public class max_String {
    public static int length(String s){
        Map<String,Integer> map=new HashMap<String,Integer>();
        char [] x=s.toCharArray();
        int m=0;
        for(int i=0;i<x.length;i++){
            if((map.get(x[i]+""))==null){
                map.put(x[i]+"",i);
            }else{
                m=i-map.get(x[i]+"");
                i+=x.length;
            }
        }
        return m;
    }
    public static void main(String [] args){
        String st="bbbbb";
        int o=length(st);
        System.out.println(o);
    }
}
