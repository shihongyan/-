/***
 * 堆排序
 */
public class Heap_order extends Heap{
    public static void main(String [] args){
        Heap heap=new Heap();
        heap.add(59);
        heap.add(42);
        heap.add(44);
        heap.add(32);
        heap.add(39);
        heap.add(30);
        heap.add(13);
        heap.add(22);
        heap.add(29);
        heap.add(14);
        heap.add(33);
        heap.add(17);
        heap.add(18);
        heap.out();
        System.out.println();
        while(heap.size()>0){
            System.out.println(heap.remove(heap.first()));
            //System.out.println(heap.size());
        }
        heap.out();
        /*List<Integer> list1=new ArrayList<Integer>();
        while(heap.size()>0)
           list1.add((Integer) heap.remove());
            System.out.print(list1);*/

    }
}
