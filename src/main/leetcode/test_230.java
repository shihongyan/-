import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test_230 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static List<Integer> list=new ArrayList<>();
     public static List<Integer> search(TreeNode tree){
         if(tree==null)
             return null;
         else{
             search(tree.left);
             list.add(tree.val);
             search(tree.right);
         }
         System.out.println(list);
         return list;
     }
   public static int kthSmallest(TreeNode root, int k) {
         /*判断树是否为空*/
      List<Integer> list=new ArrayList<>();
        if(root==null)
            return 0;
        else{
            list=search(root);
        }
      //Collections.sort(list);
        return list.get(k-1);
    }
    public static void main(String [] args){
        TreeNode tree=new TreeNode(12);
        tree.left=new TreeNode(5);
        tree.right=new TreeNode(18);
        tree.left.left=new TreeNode(4);
        tree.left.right=new TreeNode(8);
        System.out.println(kthSmallest(tree,2));
    }
}
