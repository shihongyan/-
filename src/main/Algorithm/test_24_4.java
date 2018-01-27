import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test_24_4 {
    /*定义变量*/
    private static Sum sumx=new Sum();
    /*闭锁需要等待的线程数量*/
    private  static  CountDownLatch count = new CountDownLatch(20);
    public static void main(String [] args)throws Exception{
        /*创建100个线程*/
        //ExecutorService executorService= Executors.newFixedThreadPool(100);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<20;i++){
            executorService.execute(new Sumadd());
        }
        executorService.shutdown();
        /**
         * 或者仅添加以下代码
         * while(!executorService.isTerminated()){}
         */
        count.await();
        System.out.println("主线程打印消息："+sumx.getSum());
    }

    /*继承接口*/
    private static class Sumadd implements Runnable{
        public void run() {
            synchronized (sumx){
                sumx.add(1);
                System.out.println("子线程打印消息："+sumx.sum);
                /*每结束一个线程count中的数量就会减1*/
                count.countDown();
            }
        }
    }
    /*实体类*/
    private  static class Sum{
        private int sum=0;
        public int getSum(){
            return sum;
        }
        public void add(int i){
            int sum1=sum+i;
            try {
                Thread.sleep(5);
                sum=sum1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
