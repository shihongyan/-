import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithoutSync {
    private static Account account=new Account();
    /*主方法*/
    public static void main(String [] args){
        /*线程池*/
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            executorService.execute(new AddAPennyTask());
        }
        executorService.shutdown();
        /*while循环保证子线程在主线程之前全部完成*/
        while(!executorService.isTerminated()){
        }
        System.out.println("what is balance?"+account.getBalance());
    }
    /*计算添加后的数量---实体类*/
    private static class Account{
        /*创建锁*/
        private static Lock lock=new ReentrantLock();
        private int balance=0;
        public int getBalance(){
            return balance;
        }
        /*每执行一次线程所作出的改变---》加synchronized设置临界区*/
        public  void deposit(int amount){
            /*锁定*/
            lock.lock();
            int newBalance=balance+amount;
            try{
                Thread.sleep(1);
                balance=newBalance;
            }catch (Exception e){
                System.out.println(e);
            }finally {
                /*释放锁*/
                lock.unlock();
            }
        }
    }
    /*创建线程个体*/
    private static class AddAPennyTask implements Runnable{
        public void run(){
            /*线程非安全*/
            /*account.deposit(1);*/
            /*线程安全--->加同步，*/
            synchronized (account){
                account.deposit(1);
            }
        }
    }
}
