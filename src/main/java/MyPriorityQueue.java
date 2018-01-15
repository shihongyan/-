public class MyPriorityQueue {
    private Heap heap=new Heap();
    public void enqueue(Object newObject){
        heap.add(newObject);
    }
    public void dequeue(Object o){
       heap.remove(o);
    }
    public int getSize(){
        return heap.size();
    }

    public void print(){
        heap.out();
    }
}
