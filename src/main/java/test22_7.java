import java.util.*;

public class test22_7 {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int m=scan.nextInt();
        while(m!=0){
            if(map.get(m)==null) map.put(m,1);
            else{
                int value=map.get(m);
                value++;
                map.put(m,value);
            }
            m=scan.nextInt();
        }
        for(Integer i:map.keySet()){
            if(map.get(i)==Collections.max(map.values()))
            System.out.println(i);
        }
    }
}
