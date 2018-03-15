public class test_2 {
    private ListNode first,last;
    /*链表结构*/
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val=x;}
    }
    /*添加元素*/
    public void add(int x){
        if(last==null){
            first=last=new ListNode(x);
        }else{
            last.next=new ListNode(x);
            last=last.next;
        }
    }
    /*删除第一个数据元素*/
    public int remove1(int val){
        return val;
    }
    public int remove(){
        if(first!=null)
            remove1(first.val);
         return 0;
    }
    /*两个链表中数据各自相加*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*创建存储列表*/
        ListNode list=new ListNode(0);
        /*记录头部结点*/
        ListNode p1=l1,q1=l2,temp=list;
        int sum=0;
        /*计算--->3种情况*/
        while(p1!=null||q1!=null)
        {
            if(p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }else{
                sum+=0;
            }
            if (q1!=null){
                sum+=q1.val;
                q1=q1.next;
            }else
                sum+=0;
            temp.val=sum%10;
            if(p1!=null||q1!=null)
                temp.next=new ListNode(sum/10);
            temp=temp.next;
            sum/=10;
        }
        if(sum!=0)
            temp.next=new ListNode(sum);
        return list;
    }
}