import java.util.*;

public class test_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        /*第一种*/
        if(nums1.length==0)
            return nums1;
        if(nums2.length==0)
            return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set=new HashSet<Integer>();
        int l1=0,l2=0,l=0;
        while(l1!=nums1.length&&l2!=nums2.length){
            if(nums1[l1]==nums2[l2]){
                set.add(nums1[l1]);
                l1++;l2++;
            }else if(nums1[l1]<nums2[l2])
                l1++;
            else
                l2++;
        }
        int [] x=new int[set.size()];
        Object [] y= set.toArray();
        for(int i=0;i<set.size();i++){
            x[i]=(int)y[i];
        }
        return x;
    }
    public static void main(String [] args){
        int [] a={1};
        int [] b={1};
        for(int i=0;i<intersection(a,b).length;i++){
            System.out.println(intersection(a,b)[i]);
        }
    }
}
