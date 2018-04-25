import java.util.*;

public class test_16 {
    public static int threeSumClosest(Integer[] nums, int target) {
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
        /*Arrays.sort(nums);
        int i=0,si=nums.length-1,j=si,k=(i+j)/2;
        int re=nums[i]+nums[(i+j)/2]+nums[j]-target;
        int flag=nums[i]+nums[(i+j)/2]+nums[j];
        while(j-i>=2){
            if(Math.abs(re)>Math.abs(nums[i]+nums[j]+nums[k]-target)){
                flag=nums[i]+nums[k]+nums[j];
                re=nums[i]+nums[j]+nums[k]-target;
            }
            int m=nums[i]+nums[j]-target;
            if(re==0||(-m)==nums[k])
                return target;
            while(m>=nums[k]&&Math.abs(nums[i]+nums[j]+nums[k]-target)>Math.abs(nums[i]+nums[j]+nums[k-1]-target)&&k>i+1){
                System.out.println("第一个循环！！！！");
                k--;
                flag=nums[i]+nums[k]+nums[j];
                re=nums[i]+nums[j]+nums[k]-target;
            }
            while(m<=nums[k]&&Math.abs(nums[i]+nums[j]+nums[k]-target)>Math.abs(nums[i]+nums[j]+nums[k+1]-target)&&k<j-1){
                System.out.println("第二个循环！！！！");
                k++;
                flag=nums[i]+nums[k]+nums[j];
                re=nums[i]+nums[j]+nums[k]-target;
            }
            System.out.println("re***************************："+re+"   flag*********************************:"+flag);
            System.out.println("下标："+i+"----"+k+"-----"+j);
            System.out.println("数字："+nums[i]+"----"+nums[k]+"-----"+nums[j]);
            if(re>0&&Math.abs(nums[i+1]+nums[j]+nums[k]-target)>Math.abs(nums[i]+nums[j-1]+nums[k]-target))
                j--;
            else
                i++;
            k=(i+j)/2;
        }*/
        Arrays.sort(nums);
        int close=0;
        int dis=(int)Math.pow(2,31);
        for(int i=0;i<nums.length-1;i++){
            int start=i,middle=i+1;
            while(middle<nums.length-1){
                int end=nums.length-1;
                while(end>middle){
                    System.out.println(start+"--------------"+middle+"-------------"+end);
                    if(Math.abs(nums[start]+nums[middle]+nums[end]-target)<Math.abs(dis))
                    {
                        close=nums[start]+nums[middle]+nums[end];
                        dis=close-target;
                    }
                    end-=1;
                }
                middle++;
            }
        }
        return close;
    }
    public static void main(String [] args){
        Integer [] a={0,2,1,-3};
        System.out.println(threeSumClosest(a,1));
    }
}
