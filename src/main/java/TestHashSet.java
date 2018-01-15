import java.lang.reflect.Array;
import java.util.*;

public class TestHashSet {
    public static void main(String [] args){
        /*LinkedeHashSet有顺序，HashSet没有顺序，但是效率高*/
        Set<String> set=new LinkedHashSet<String>();
        set.add("China");
        set.add("America");
        set.add("Canada");
        set.add("Australia");
        set.add("Japan");
        set.add("Russian");
        //System.out.println(set);
        /*设置迭代器*/
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*按照字母顺序排序每次添加元素treeset就会重新排序*/
        TreeSet<String> treeSet=new TreeSet<String>(set);
        System.out.println(treeSet);
        /*list部分函数使用*/
        List<String> list= Arrays.asList("hello","world","time","is","so","beautiful");
        List<String> list2= Arrays.asList("hello","world","time","is","so","beautiful");
        List<String> list3=Arrays.asList("shi","hong","yan");
        Collections.sort(list);
        System.out.println(list);
        /*降序排列*/
        Collections.sort(list,Collections.<String>reverseOrder());
        System.out.println(list);

        List<Integer> list1= Arrays.asList(2,4,5,9,12,16,48,56,97);
        /*获取查找元素的索引--->前提:list中的元素以升序排列*/
        System.out.println("(1) Index: "+Collections.binarySearch(list1,9));
        /*倒序排列*/
        Collections.reverse(list1);
        System.out.println(list1);
        /*随机重新排序*/
        Collections.shuffle(list1);
        System.out.println(list1);

        Collections.shuffle(list,new Random(20));
        Collections.shuffle(list2,new Random(20));
        System.out.println(list);
        System.out.println(list2);
        /*copy是浅复制，只是复制元素引用*/
        Collections.copy(list,list3);
        System.out.println(list);
        /*将指定元素复制n次，构成不可变的线性表(不可添加，删除，更新元素)*/
        List<String> listn=Collections.nCopies(2,new String("aha"));
        System.out.println("listn的输出："+listn);

        Collections.fill(list,"ehei");
        System.out.println(list);

        /*max(),min()函数使用*/
        System.out.println(Collections.max(list2));
        System.out.println(Collections.min(list2));
        /*判断两个集合中是否有相同元素 有-->false 无--->true*/
        System.out.println(Collections.disjoint(list,listn));
        /*判断元素在集合中出现的次数*/
        System.out.println(Collections.frequency(listn,"aha"));

        /*------------------------------------队列的使用-------------------------------*/
        Queue<String> queue=new LinkedList<String>();
        queue.offer("ahaha");
        queue.offer("eheng");
        queue.offer("huhu");
        queue.offer("lala");
        queue.offer("didi");
        while(queue.size()>0){
            System.out.print(queue.remove()+" ");
        }
        /*优先队列--->默认升序排列*/
        PriorityQueue<String> queue1=new PriorityQueue<String>();
        queue1.offer("hhhh");
        queue1.offer("llll");
        queue1.offer("dddd");
        while(queue1.size()>0){
            System.out.print(queue1.remove()+" ");
        }
        System.out.println();
        /*优先队列--->倒序---->指定初始容量*/
        PriorityQueue<String> queue2=new PriorityQueue<String>(5,Collections.<String>reverseOrder());
        queue2.offer("this");
        queue2.offer("is");
        queue2.offer("a");
        queue2.offer("beatiful");
        queue2.offer("day");
        while(queue2.size()>0){
            System.out.print(queue2.remove()+" ");
        }
    }
}
