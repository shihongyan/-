public class test1 {
    public static void main(String [] args){
        /**test1
         * int sum=0;
        for(int i=0;i<1000;i++){
            if(i%3==0||i%5==0)
                sum+=i;
        }
        System.out.println(sum);*/
        /**
         * test2
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
         * test3
         */
        boolean bool=true;
        double flag=0,x=600851475143l;
        for(double i=x;i>Math.sqrt(x);i--){
            System.out.println("这是i"+i);
            if(i/2==0){
                for(double j=3;j<Math.sqrt(i);j+=2){
                    System.out.println("这是J"+j);
                    if(i/j==0){
                        bool=false;
                        j=Math.sqrt(i)+1;
                    }
                }
            }else if(i/3==0){
                for(double j=2 ;j<Math.sqrt(i);j+=3){
                    System.out.println("这是J"+j);
                    if(i/j==0){
                        bool=false;
                        j=Math.sqrt(i)+1;
                    }
                }
            }
            if(bool==true){
                flag=i;
                i=Math.sqrt(x)-1;
            }
        }
            System.out.println(flag);
    }
}
