import java.util.*;

public class max_String {
    public static int length(String s){
        Set<Object> set=new HashSet<Object>();
        int n=s.length();
        int i=0,j=0,max=0;
        while(i<n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                max=Math.max(max,i-j);
            }else{
                set.remove(s.charAt(j++));
            }
        }
        return max;
        /*错误思路*/
       /* Map<String,Integer> map=new HashMap<String,Integer>();
        List<Integer> list=new ArrayList<Integer>();
        char [] x=s.toCharArray();
        int m=0,n=0;
        for(int i=0;i<x.length;i++){
            if((map.get(x[i]+""))==null){
                map.put(x[i]+"",i);
            }else{
                list.add(i-n);
                n=i;
                if(m<i-map.get(x[i]+"")) {
                    m = i - map.get(x[i] + "");
                }
                map.put(x[i]+"",i);
            }
        }
        list.add(x.length-n);
        return Collections.max(list);*/
    }
    public static void main(String [] args){
        String st="pwwkew";
        int o=length(st);
        System.out.println(o);
    }
}
