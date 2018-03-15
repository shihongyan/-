public class test_1 {
    public static int[] twoSum(int[] nums, int target) {
        //int [] x=new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    /*x[0]=i;
                    x[1]=j;*/
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String [] args){
        int [] y={3,2,4};
        System.out.println(twoSum(y,6)[0]+"-------"+twoSum(y,6)[1]);
    }
}
