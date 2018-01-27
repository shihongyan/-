import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test001 {
        /*定义变量*/
        private static Sum sumx=new Sum();
        public static void main(String [] args)throws Exception{
            /*创建100个线程*/
            //ExecutorService executorService= Executors.newFixedThreadPool(100);
            ExecutorService executorService= Executors.newCachedThreadPool();
            for(int i=0;i<100;i++){
                executorService.execute(new Sumadd());
            }
            executorService.shutdown();
            while(!executorService.isTerminated()){
            }
            System.out.println("主线程打印消息："+sumx.getSum());
        }

        /*继承接口*/
        private static class Sumadd implements Runnable{
            public void run() {
                sumx.add(1);
               /* synchronized (sumx){
                    sumx.add(1);
                }*/
            }
        }
        /*实体类*/
        private  static class Sum{
            private static Lock lock=new ReentrantLock();
            private int sum=0;
            public int getSum(){
                return sum;
            }
            public void add(int i){
                lock.lock();
                int sum1=sum+i;
                try {
                    Thread.sleep(5);
                    sum=sum1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                   lock.unlock();
                }
            }
        }
    }
