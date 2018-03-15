/*手动计算1-10的最小次数--->找规律
* 规律如if--else判断
* */
public class test_754 {
    public static int reachNumber(int target) {
        int sum=0,i;
        target=Math.abs(target);
        for(i=1;sum<target;i++)
            sum+=i;
        System.out.println(sum+"-------------------"+i);
        if(sum==target||(sum-target)%2==0)
            return i-1;
        else if((sum-target)%2!=0&&i%2!=0)
            return i;
        else
            return i+1;
    }
    public static void main(String [] args){
        System.out.println(reachNumber(5));
    }
}
