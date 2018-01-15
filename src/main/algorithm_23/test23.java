import java.util.Collection;
import java.util.Collections;

public class test23 {
    /*归并排序*/
    /*分*/
    public static void devide(int [] list){
        /*list 前半部分*/
        if(list.length==1) return;
        int [] size1=new int[list.length/2];
        System.arraycopy(list,0,size1,0,size1.length);
        devide(size1);

        /*list 后半部分*/
        int [] size2=new int[list.length/2];
        System.arraycopy(list,list.length/2,size2,0,size2.length);
        devide(size2);

        int [] result=merge(size1,size2);
        System.arraycopy(result,0,list,0,result.length);
    }
    /*合*/
    public static int[] merge(int [] list1,int [] list2){
        int [] temp=new int[list1.length+list2.length];
        int size1= 0;
        int size2= 0;
        int size3= 0;
        while(size1<list1.length&&size2<list2.length){
            if(list1[size1]<list2[size2]){
                temp[size3++]=list1[size1++];
            }else
                temp[size3++]=list1[size2++];
        }
        if(size1==list1.length)
            System.arraycopy(list2,size2,temp,size3,temp.length-size3);
        else
            System.arraycopy(list1,size1,temp,size3,temp.length-size3);
        return temp;
    }
    /*---->快速排序<----*/
   public static void quick(int[] list,int first,int low){
       /*递归出口*/
       if(low==0||first>low) return;
       int right=low;
       int left=first+1;
       int temp=list[first];
       while(left<right){
           while(list[right]>temp&&left<right) right--;
           while(list[left]<temp&&left<right) left++;
           if(left<right){
               int tempx=list[right];
               list[right]=list[left];
               list[left]=tempx;
           }
       }
       /*互换标志---注意判断条件*/
       if(list[right]<temp){
           list[first]=list[right];
           list[right]=temp;
       }
       quick(list,first,right-1);
       quick(list,right+1,low);
   }
    public static void main(String [] args){
        long time0=System.currentTimeMillis();
        /*初始数组元素*/
        int [] arr= {1,2,3,4,5,6,7};
        /*冒泡排序*/
        for(int j=0;j<arr.length;j++){
            for(int i=0;i<arr.length-j-1;i++){
                if(arr[i]>arr[i+1]){
                    int x=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=x;
                }
            }
        }
        /*加强for循环输出结果*/
        for (int y:arr) {
            System.out.print(y+" ");
        }
        long time1=System.currentTimeMillis();
        System.out.println("冒泡排序结束！"+(time1-time0));
        /*归并排序*/
        devide(arr);
        for (int x:arr
             ) {
            System.out.print(x+" ");
        }
        System.out.println((System.currentTimeMillis()-time1)+"消耗时间");
        /*快速排序*/
        quick(arr,0,arr.length-1);
        for (int x:arr
                ) {
            System.out.print(x+" ");
        }
    }
}
