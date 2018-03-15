import java.util.ArrayList;
import java.util.List;
/*自分数*/
public class test_728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<Integer>();
        if(left>=1&&left<=right&&right<=10000){
            for(int i=left;i<=right;i++){
                int temp=i;
                int j=(int)Math.log10(i);
                while(j>=0&&i%(temp/(int)Math.pow(10,j))==0){
                    temp-=temp/(int)Math.pow(10,j)*(int)Math.pow(10,j);
                    j-=1;
                    if(temp<(int)Math.pow(10,j))
                        break;
                }
                if(j==-1)
                    list.add(i);
            }
            return list;
        }else{
            return null;
        }
    }
    public static void main(String [] args){
        System.out.println(selfDividingNumbers(1,22));
    }
}
