import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

public class test_475 {
    public static int findRadius(int[] houses, int[] heaters) {
       Arrays.sort(heaters);
       int result=Integer.MIN_VALUE;
       for (int hx:houses){
           int index=Arrays.binarySearch(heaters,hx);
           if(index<0)
               index=-(index+1);
           int dist1=index-1>=0?(hx-heaters[index-1]):Integer.MAX_VALUE;
           int dist2=index<heaters.length?(heaters[index]-hx):Integer.MAX_VALUE;
           result=Math.max(result,Math.min(dist1,dist2));
       }
        return result;
    }
    public static void main(String [] args){
        int [] a={282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int [] b={823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius(a,b));
    }
}
