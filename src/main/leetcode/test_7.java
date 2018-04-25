public class test_7 {
    public static int reverse(int x) {
        if(x<=-2147483648||x>2147483647){
            return 0;
        }
        int y=Math.abs(x);
        int t=(int)Math.log10(y),temp=0;
        System.out.println(t);
        for(int i=0;i<t;i++){
            temp=temp+x/(int)Math.pow(10,t-i)*(int)Math.pow(10,i);
            x=x-x/(int)Math.pow(10,t-i)*(int)Math.pow(10,t-i);
            System.out.println(x+"------"+temp);
            if((temp>147483648&&y%10>=2)||(temp<(-147483648)&&y%10>=2)){
                return 0;
            }
        }
        temp=temp+x*(int)Math.pow(10,t);
        return temp;
    }
    public static void main(String [] args){
        //System.out.println(143847412>147483648);
        System.out.println(reverse(-1563847412));

    }
}