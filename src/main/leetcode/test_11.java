public class test_11 {
    public static int maxArea(int[] height) {
        /*int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                max=Math.max(max,(j-i)*Math.min(height[i],height[j]));
            }
        }
       return max;*/
        int i=0,j=height.length-1,max=0;
        while(i!=j){
            if(height[i]>height[j]){
                max=Math.max(max,(j-i)* height[j]);
                j-=1;
            }else{
                max=Math.max(max,(j-i)* height[i]);
                i+=1;
            }
        }
        //max=Math.max(max,height[i]);
        return max;
    }
    public static void main(String [] args){
        int [] a={9,8};
        System.out.println(maxArea(a));
    }
}
