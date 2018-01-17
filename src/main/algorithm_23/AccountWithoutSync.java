import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
    private static Account account=new Account();
    /*主方法*/
    public static void main(String [] args){
        /*线程池*/
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            executorService.execute(new AddAPennyTask());
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){
            System.out.println("what is balance?"+account.getBalance());
        }
    }
    /*计算添加后的数量*/
    private static class Account{
        private int balance=0;
        public int getBalance(){
            return balance;
        }
        /*每执行一次线程所作出的改变*/
        public void deposit(int amount){
            int newBalance=balance+amount;
            try{
                Thread.sleep(5);
            }catch (Exception e){
                System.out.println(e);
            }
            balance=newBalance;
        }
    }
    /*未知*/
    private static class AddAPennyTask implements Runnable{
        public void run(){
        account.deposit(1);
        }
    }
}
