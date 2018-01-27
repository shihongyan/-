import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    private static Account account=new Account();
    public static void main(String [] args){
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.execute(new depositTask());
        executorService.execute(new withdrawTask());
        executorService.shutdown();
    }
    /*设置线程---存钱*/
    private static class depositTask implements Runnable{
        public void run(){
            while(true){
                account.deposit((int)(Math.random()*10)+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*设置线程---取钱*/
    private static class withdrawTask implements Runnable{
        public void run(){
            while(true){
                account.wihtdraw((int)(Math.random()*10)+1);
            }
        }
    }
    /*设置实体类*/
    private static class Account{
        /*创建锁*/
        private static Lock lock=new ReentrantLock();
        /*可用来设置线程的状态*/
        private static Condition newDeposit=lock.newCondition();
        private int balance=0;
        public int getBalance(){
            return balance;
        }
        /*取钱*/
        public void wihtdraw(int amount){
            lock.lock();
            try{
                while(amount>balance)
                    newDeposit.await();
                balance-=amount;
                System.out.println("取钱金额："+amount+"------余额："+balance);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        /*存钱*/
        public void deposit(int amount){
            lock.lock();
            balance+=amount;
            System.out.println("存入金额："+amount+"------余额："+balance);
            newDeposit.signalAll();
            lock.unlock();
        }
    }
}
