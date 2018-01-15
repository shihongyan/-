import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String [] args){
        /*在线程池中设置创建最多3个线程*/
        ExecutorService executor= Executors.newFixedThreadPool(3);
        /*分配线程任务*/
        executor.execute(new PrintChar('a',10));
        executor.execute(new PrintChar('b',10));
        executor.execute(new PrintNum(100));
        /*结束线程*/
        executor.shutdown();
    }
    static class PrintChar implements Runnable{
        private  char charToPrint;
        private int times;

        public  PrintChar(char c,int t){
            charToPrint=c;
            times=t;
        }
        public void run(){
            for(int i=0;i<times;i++)
                System.out.print(charToPrint);
            System.out.println();
        }
    }
    static class PrintNum implements Runnable{
        private int num;

        public PrintNum(int number){
            this.num=number;
        }
        /*java强制捕获受控制异常*/
        public void run(){
            Thread thread4=new Thread(new Thread_24.PrintChar('e',10));
            thread4.start();
            try {
                for(int i=0;i<num;i++){
                    System.out.print(i);
                    //if(i==50)
                    //AThread.sleep(100);
                    //thread4.join();
                }
                System.out.println();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
