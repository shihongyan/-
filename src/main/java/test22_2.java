import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class test22_2 {
    /*读入文本文件*/
    public static String textio(File file){
        StringBuilder result=new StringBuilder();
        try{
            BufferedReader br=new BufferedReader(new FileReader(file));
            String s=null;
            while((s=br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return result.toString();
    }
    public static void main(String [] args){
        File file=new File("/home/260198/文档/22/test.txt");
        String [] str=textio(file).trim().split("[ ,!?]+");
        Set<String> set=new TreeSet<String>();
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<str.length;i++){
            if(map.get(str[i])==null) map.put(str[i],1);
            else{
                int value=map.get(str[i]);
                value++;
                map.put(str[i],value);
            }
        }
        for(String x:map.keySet())
            if(map.get(x)==1) set.add(x);
        System.out.println(set);
    }
}
