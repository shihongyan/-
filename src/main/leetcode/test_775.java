public class test_775 {
    public static boolean isIdealPermutation(int[] A) {
        int n = A.length ,tmax= 0;
        for(int i = 0;i<n-2;i++)
        {
            tmax =Math.max(tmax,A[i]);
            if(tmax > A[i+2]) return false;
        }
        return true;

    }
    public static void main(String [] args){
        int [] aa={1,0,2};
        System.out.println(isIdealPermutation(aa));
    }
}
