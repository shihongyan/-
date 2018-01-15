import java.util.*;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;
    private int size = 0;

    public BinaryTree(){}
    /*构造函数*/
    public BinaryTree(Object[] objects){
        for(int i = 0;i< objects.length; i++)
            insert(objects[i]);
    }
    /*构建二叉树*/
    public boolean insert(Object o){
        if(root == null){
            root = new TreeNode(o);
        }
        else {
            TreeNode parent = null;
            TreeNode current = root;
            while(current != null)
                if(((Comparable)o).compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }
                else if (((Comparable)o).compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }
                else
                    return false;

                if(((Comparable)o).compareTo(parent.element) < 0)
                    parent.left = new TreeNode(o);
                else
                    parent.right = new TreeNode(o);

        }
        size++;
        return true;
    }
    /*中序遍历*/
    public void inorder(){
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }
    /*后序遍历*/
    public void postorder(){
        postorder(root);
    }
    public void postorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.element + " ");
    }
    /*前序遍历*/
    public void preorder(){
        postorder(root);
    }
    public void preorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.element + " ");
    }
    /*获取树的长度*/
    public int getSize(){
        return size;
    }
    /*查找元素*/
    public Boolean search(Object o){
        TreeNode current=root;
        if(current==null) return false;
        while(current!=null){
            if((((Comparable)o).compareTo(current.element)==0)) return true;
            if(((Comparable)o).compareTo(current.element)>0){
                current=current.right;
            }
            else{
                current=current.left;
            }
        }
        return false;
    }
    /*定义树结点*/
    private static class TreeNode{
        Object element;
        TreeNode left;
        TreeNode right;
        public TreeNode (Object o){
           element=o;
        }
    }

    /*队列是一种特殊的线性表----->广度优先遍历*/
    public void breadthFirstTraversal(){
        if(root==null) return;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode n=queue.poll();
            System.out.print(n.element+",");
            if(n.left!=null){
                queue.offer(n.left);
            }if(n.right!=null){
                queue.offer(n.right);
            }
        }
    }
    /*求树的深度*/
    public int depth(){
        return depth(root);
    }
    public int depth(TreeNode tree){
        if(tree==null) return 0;
        int x=depth(tree.left)+1;
        int y=depth(tree.right)+1;
        return x>y?x:y;
    }
}
