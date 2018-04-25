import java.util.HashMap;
import java.util.Map;

public class test_167 {
    public static int[] twoSum(int[] numbers, int target) {
        /*第一种*/
       /* Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int [] re=new int[2];
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }
        for(int j=0;j<numbers.length;j++){
            if(map.get(target-numbers[j])!=null){
                re[0]=Math.min(j,map.get(target-numbers[j]))+1;
                re[1]=Math.max(j,map.get(target-numbers[j]))+1;
                break;
            }
        }
        return re;*/
        /*第二种*/
        int [] re=new int[2];
        int x=0,y=numbers.length-1;
        while(x<y){
            if(numbers[x]+numbers[y]==target)
            {
                re[0]=x+1;
                re[1]=y+1;
            }
            if(numbers[x]+numbers[y]<target)
                x++;
            else
                y--;
        }
        return re;
    }
    public static void main(String [] args){
      int [] x={1,2,3,4,5,6,7,8,9,90};
      int [] y=twoSum(x,5);
      System.out.println(y[0]+"-----"+y[1]);
    }
}
