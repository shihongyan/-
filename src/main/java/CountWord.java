import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountWord {
    public static void main(String [] args){
        String text="Have a good day.Have a good class.Have a good visit.Have fun!";
        Map<String,Integer> map=new HashMap<String, Integer>();
        String [] words=text.split("[ ,!?]");
        for(int i=0;i<words.length;i++){
            if(map.get(words[i])!=null){
                int value=map.get(words[i]).intValue();
                value++;
                map.put(words[i],value);
            }else{
                map.put(words[i],1);
            }
        }
        Map<String,Integer> map1=new TreeMap<String, Integer>(map);
        for(String str:map1.keySet()){
            int i=map1.get(str);
            System.out.print(str+"--"+i+"     ");
        }
        map.hashCode();
    }
}
