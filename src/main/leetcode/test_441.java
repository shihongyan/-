public class test_441 {
    public static int arrangeCoins(int n) {
        /*错误理解*/
     /*   int start=0,end=n;
        while (start!=end-1){
            if(n==Math.pow((start+end)/2,2)){
                start=(start+end)/2;
                break;
            }
            if(n>Math.pow((start+end)/2,2))
                start=(start+end)/2;
            else
                end=(start+end)/2;
        }*/
       int x=(int)(Math.sqrt(n)*Math.sqrt(2));
       if(n==0||n==1)
            return n;
        if(Math.sqrt(n)*Math.sqrt(2)<Math.sqrt(x)*Math.sqrt(x+1))
            return x-1;
        else
            return x;
    }
    public static void main(String [] args){
        System.out.println(arrangeCoins(9));
    }
}
