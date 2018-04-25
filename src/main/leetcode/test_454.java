import java.util.Arrays;

public class test_454 {
    public static int findnum(int x,int [] y){
        if(y.length==0)
            return -1;
        if(y.length==1&&y[0]==x)
            return 1;
        int num=0;
        int start=0,end=y.length-1,mid=(start+end)/2;
        while(end!=start+1&&end!=start){
            if(y[mid]==x)
                num+=1;
            if(y[mid]>x)
                end=mid;
            else
                start=mid;
            mid=(start+end)/2;
        }
        if(y[end]==x)
            num+=1;
        return num;
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int flag=0,s=0,t=0;
        if (A.length == 0)
            return 0;
        int [] x=new int[A.length*A.length];
        int [] y=new int[A.length*A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                x[s++]=A[i]+B[j];
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                y[t++]=C[i]+D[j];
            }
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for(int m:x){
            if(findnum(-m,y)!=(-1))
                flag+=findnum(-m,y);
            System.out.println(m+"----");
        }
        return flag;
        /*可行方案一
        int flag = 0;
        if (A.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int x = A[i] + B[j];
                if (map.get(x) == null)
                    map.put(x, 1);
                else {
                    int value = map.get(x);
                    map.put(x, value + 1);
                }
            }
        }
        for (int k = 0; k < A.length; k++) {
            for (int l = 0; l < A.length; l++) {
                int y = C[k] + D[l];
                if (map1.get(y) == null)
                    map1.put(y, 1);
                else {
                    int value = map1.get(y);
                    map1.put(y, value + 1);
                }
            }
        }
        for (int n : map.keySet()) {
            if (map1.get(-n) != null)
                flag += map.get(n) * map1.get(-n);
        }
        return flag;*/
    }
    public static void main(String [] args){
        int [] A={-1,-1};
        int [] B={-1,1};
        int [] C={-1,1};
        int [] D={1,-1};
        System.out.println(fourSumCount(A,B,C,D));
        System.out.println(findnum(-1,A));
    }
}
