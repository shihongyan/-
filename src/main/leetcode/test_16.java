import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test_16 {
    public static int threeSumClosest(int[] nums, int target) {
        /*与给定目标最近的三个数字的总和
        List<Integer> list = new ArrayList<Integer>();
        if(target>0){
            for (int i = 0; i < nums.length; i++) {
                if (list.size() < 3) {
                    list.add(target - nums[i]);
                } else {
                    if (target - nums[i] < Collections.max(list)) {
                        list.remove(Collections.max(list));
                        list.add(target - nums[i]);
                    }
                }
            }
            return 3 * target - list.get(0) - list.get(1) - list.get(2);
        }else{
            for (int i = 0; i < nums.length; i++) {
                if (list.size() < 3) {
                    list.add(nums[i] - target);
                } else {
                    if (nums[i] - target < Collections.max(list)) {
                        list.remove(Collections.max(list));
                        list.add(nums[i] - target);
                    }
                }
            }
            return list.get(0) + list.get(1) + list.get(2) - Math.abs(3 * target);*/
        return 0;
    }
    public static void main(String [] args){
        int [] a={-1,2,1,-4};
        System.out.println(threeSumClosest(a,1));
    }
}
