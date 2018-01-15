import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ReadWord{
    /*读取文本文件*/
    public static String textio(File file){
        /*创建存放字符串的变量*/
        StringBuilder result=new StringBuilder();
        try{
            /*创建字符流*/
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
        File file=new File("/home/260198/桌面/BruceLee/dida.txt");
        String [] str=textio(file).trim().split("[ ,.?!]");
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<str.length;i++){
            if(map.get(str[i])==null) map.put(str[i].trim(),1);
            else{
                int value=map.get(str[i]);
                value++;
                map.put(str[i],value);
            }
        }
        Set<String> set=new TreeSet<String>();
        for(String temp:map.keySet()){
            set.add(temp);
        }
        for(String temp1:set){
            for(int j=0;j<map.get(temp1.trim());j++){
                System.out.print(temp1.trim()+" ");
            }
        }
    }
}
