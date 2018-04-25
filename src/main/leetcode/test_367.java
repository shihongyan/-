public class test_367 {
    public static boolean  isPerfectSquare(int num) {
        int start=0,end=num;
        int mi=(num+start)/2;
        if(num==1)
            return true;
        if(mi*mi==num)
            return true;
        while(end-start!=1){
            if(mi>num/mi){
                end=mi;
                mi=(start+end)/2;
            }
            else{
                start=mi;
                mi=(start+end)/2;
            }
        }
        if(mi*mi==num)
        return true;
        else
            return false;
    }
    public static void main(String [] args){
        System.out.println(isPerfectSquare(59));
    }
}
