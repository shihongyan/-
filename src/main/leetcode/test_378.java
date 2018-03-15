import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test_378 {
    /*方法一：*/
    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> list=new ArrayList<Integer>();
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix.length;j++){
               list.add(matrix[i][j]);
           }
       }
        Collections.sort(list);
       if(k<=Math.pow(matrix.length,2))
        return list.get(k-1);
       else
           return 0;
    }
    public static void main(String [] args){
        int [][] a={{1,5,9},{10,11,13},{12,13,15}};
        //int [][] a={{-5}};
        System.out.println(kthSmallest(a,8));
    }
}
