import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation_update {
   private static save savex=new save();
    public static void main(String [] args){
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.execute(new outtesk());
        executorService.execute(new intesk());

        executorService.shutdown();
    }
    /*创建线程*/
    private static class intesk implements Runnable{
        @Override
        public void run() {
            while(true){
                savex.within((int)(Math.random()*10));
            }
        }
    }
    private static class outtesk implements Runnable{
        @Override
        public void run() {
            while(true){
                int m=(int)(Math.random()*10);
            savex.without(m);
                System.out.println("取得金额："+m+"    余额："+savex.getSum());
            }
        }
    }
    /*实体类*/
    private static class save{
        private static int sum=0;
        private static Lock lock=new ReentrantLock();
        private static Condition noempty=lock.newCondition();

        public static int getSum() {
            return sum;
        }

        /*存钱方法*/
        private static void within(int i){
            lock.lock();
            try {
                sum+=i;
                noempty.notify();
                System.out.println("存入金额："+i+"    余额："+getSum());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        /*取钱*/
        private static void without(int y) {
            lock.lock();
                try {
                    while(y>=sum){
                        noempty.wait();
                    }
                    sum-=y;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
        }

    }
}
