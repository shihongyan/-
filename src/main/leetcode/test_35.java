public class test_35 {
    public static int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        if(nums[end]==target)
            return end;
        if(nums[0]>target)
            return 0;
        if(nums[end]>target){
            int temp=(end+start)/2;
            while(temp!=start){
                if(nums[temp]==target)
                    return temp;
                if(nums[temp]>target)
                    end=temp;
                else
                    start=temp;
                temp=(end+start)/2;
            }
            return end;
        }else

        return end+1;
    }
    public static void main(String [] args){
        int [] x={1,2,4,6,9,10};
        System.out.println(searchInsert(x,10));
    }
}
