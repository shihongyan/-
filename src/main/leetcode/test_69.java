public class test_69 {
    public static int mySqrt(int x) {
        //return (int)Math.sqrt(x);
        int start=0,end=x;
        int mi=(x+start)/2;
        if(x==1)
            return 1;
        if(mi*mi==x)
            return mi;
        System.out.println(mi);
        while(end-start!=1){
            System.out.println(start+"==========="+mi+"               "+end);
            if(mi>x/mi){
                end=mi;
                mi=(start+end)/2;
            }
            else{
                start=mi;
                mi=(start+end)/2;
            }
        }
        return mi;
    }
    public static void main(String [] args){
        System.out.println(mySqrt(2147395599));
    }
}

