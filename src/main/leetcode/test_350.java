import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0)
            return nums1;
        if(nums2.length==0)
            return nums2;
        List<Integer> list=new ArrayList<Integer>();
        int l1=0,l2=0,l=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(l1!=nums1.length&&l2!=nums2.length){
            if(nums1[l1]==nums2[l2]){
                list.add(nums1[l1]);
                l1++;l2++;
            }else if(nums1[l1]<nums2[l2])
                l1++;
            else
                l2++;
        }
        int [] x=new int[list.size()];
        for(int i=0;i<list.size();i++){
            x[i]=list.get(i);
        }
        return x;
    }
    public static void main(String [] args){
        int [] x={1,2,2,1};
        int [] y={2,2};
        for(int i=0;i<intersect(x,y).length;i++){
            System.out.println(intersect(x,y)[i]);
        }
    }
}
