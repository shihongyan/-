import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *问题：输入字符串，记录其中每个字母所在的位置，输出其索引
 */
public class test_practice_collection {
    public static void main(String [] args){
       /*起始时间*/
       long x=System.currentTimeMillis();
        Map<String,ArrayList<Integer>> map=new HashMap<String,ArrayList<Integer>>();
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        char[] arrays=str.toCharArray();

        for (int i=0;i<arrays.length;i++){
            if(map.get(arrays[i]+" ")==null){
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(i);
                map.put(arrays[i]+" ",list);
            }
            else {
                ArrayList<Integer> list1=new ArrayList<Integer>();
                list1 = map.get(arrays[i]+" ");
                list1.add(i);
                map.put(arrays[i] + " ", list1);
            }
        }
        for (String s:map.keySet()
             ) {
            ArrayList<Integer> ss=map.get(s);
            System.out.println(s+"= "+ss);
        }
        long y=System.currentTimeMillis();
        System.out.println("程序的运行时间"+(y-x)+"ms");
    }
}
