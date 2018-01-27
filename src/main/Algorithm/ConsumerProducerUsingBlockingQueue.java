import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {
    /**/
    private static ArrayBlockingQueue<Integer> buffer=new ArrayBlockingQueue<Integer>(2);
    public static void main(String [] args){
        /*设置两个线程*/
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.execute(new ProducerTask());
        executorService.execute(new ConsumerTask());
    }
    private static class ProducerTask implements Runnable{
        public void run() {
            while(true){
                int i=(int) (Math.random()*100);
                System.out.println("Producer write "+i);
                buffer.offer(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    private static class ConsumerTask implements Runnable{
        public void run(){
            while (true){
                System.out.println("Consumer reads "+buffer.poll());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
