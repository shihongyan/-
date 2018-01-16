import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/***
 * Euler练习题
 */
public class test1 {
    /*判断是否是素数*/
    public static Boolean prime(long x){
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }
    /*判断是否是回文数字*/
    public static Boolean palindromic(int x){
        int [] map=new int[(int)(Math.log10(x)+1)];
        for(int i=100000;i>0;i/=10){
            int a=x/i;
            map[(map.length-1)-(int)Math.log10(i)]=a;
            x=x-a*i;
        }
        Boolean bool=true;
        for(int i=0;i<map.length;i++){
            if(map[i]!=map[map.length-1-i])
                bool=false;
        }
        return bool;
    }
    public static void main(String [] args){
        /**test1
         * int sum=0;
        for(int i=0;i<1000;i++){
            if(i%3==0||i%5==0)
                sum+=i;
        }
        System.out.println(sum);*/
        /**
         * test2 4000000以内斐波那契之和
         *
        int sum=0,a=1,b=2,sumx=2;
        while (sum < 4000000) {
            sum = a + b;
            a = b;
            b = sum;
            if (sum % 2 == 0)
                sumx += sum;
        }
        System.out.println(sumx);
         */
        /**
         * test3 查找最大素数因子
         <-boolean bool=prime(num/i);boolean bool1=prime(i);->
        long flag=0;
        long num=600851475143l;
        for(long i=2;i<=Math.sqrt(num);){
            //System.out.println(i);
            if(num%i==0){
                System.out.println(i);
                if(prime(num/i)==true)
                {
                    flag=num/i;
                    System.out.println("flag"+num/i);
                    i+=Math.sqrt(num);
                }else{
                    if(prime(i)==true){
                        flag=i;
                        i+=2;
                    }
                    else
                        i+=2;
                }
            }else
                i+=1;
        }
        if(flag==0)
            System.out.println("最大素数因子为："+num);
        else
            System.out.println("最大素数因子是："+flag);*/
        /**
         * test4  3位数字组成最大回文数字
        int flag=0;
        for(int i=999;i>100;i--){
          for(int j=i;j>100;j--){
             Boolean bool=palindromic(i*j);
              if(bool==true&&(i*j>flag)){
                flag=i*j;
            }
        }
    }
    System.out.println("最大的回文数字："+flag);*/
    }
}
