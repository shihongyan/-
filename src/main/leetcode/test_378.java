import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test_378 {
    /*方法一：调用已经存在的方法*/
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
    /*方法二：放到list中（超时）*/
    public static int kthSmallest1(int[][] matrix, int k) {
        List<Integer> list=new ArrayList<>();
        Arrays.asList(matrix[0]);
        /*复制第一行*/
        for(int i=0;i<matrix.length;i++){
            list.add(matrix[0][i]);
        }
        for(int i=1;i<matrix.length;i++){
            int num=0;
            while(num<matrix.length)
                if(list.get(list.size()-1)<matrix[i][num]){
                    for(int j=num;j<matrix.length;j++){
                        list.add(matrix[i][j]);
                    }
                    num=matrix.length;
                }else{
                    int temp=list.size();
                    list.add(matrix[i][num]);
                    while(list.get(temp-1)>matrix[i][num]){
                        list.set(temp,list.get(temp-1));
                        list.set(temp-1,matrix[i][num]);
                        temp--;
                    }
                    num++;
                }
        }
        System.out.println(list);
        return list.get(k-1);
    }
    public static void main(String [] args){
        //int [][] a={{1,5,9},{10,11,13},{12,13,15}};
        int [][] a={{1,2},{1,3}};
        System.out.println(kthSmallest1(a,4));
        System.out.println(Arrays.asList(a[0]).get(0));
    }
}
