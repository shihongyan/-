import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
     static Buffer buffer=new Buffer();
    public static void main(String [] args){
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.execute(new writeTesk());
        executorService.execute(new readTesk());
        executorService.shutdown();
    }
    /*设置线程---生产者*/
    public static class writeTesk implements Runnable{
        public void run() {
            try {
                while(true){
                    buffer.write((int)(Math.random()*10));
                    Thread.sleep(500);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /*设置线程---消费者*/
    public static class readTesk implements Runnable{
        @Override
        public void run() {
            try{
                while(true){
                    int value=buffer.read();
                    System.out.println("读出数据为："+value);
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    /*实体类*/
    private static class Buffer{
        /*设置长度*/
        private static final int CAPACITY=1;
        /*设置存储队列*/
        private static LinkedList<Integer>  queue=new LinkedList<Integer>();
        /*创建锁---锁与状态依赖*/
        private static Lock lock=new ReentrantLock();
        /*创建两个临界计数的状态*/
        private static Condition notEmpty=lock.newCondition();
        private static Condition notFull=lock.newCondition();
        /*生产者*/
        public static void write(int value){
            /*上锁*/
            lock.lock();
                try {
                    while(queue.size()==CAPACITY){
                        System.out.println("Wait for notfull condition");
                        notFull.await();
                    }
                    System.out.println("读入数据为："+value);
                    queue.offer(value++);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    /*解锁*/
                    lock.unlock();
                }
            }
        /*消费者*/
        public static int read(){
            int value=0;
            lock.lock();
            try {
                while (queue.isEmpty()){
                    System.out.println("wait for notEmpty!!!");
                    notEmpty.await();
                }
                    value=queue.remove();
                notFull.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                return value;
            }
        }
    }
}
