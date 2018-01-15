public class Thread_24 {
    public static void main(String [] args){
        /*创建任务*/
        Runnable printA=new PrintChar('a',100);
        Runnable printB=new PrintChar('b',100);
        Runnable print100=new PrintNum(100);

        /*创建线程*/
        Thread thread1=new Thread(printA);
        Thread thread2=new Thread(printB);
        Thread thread3=new Thread(print100);

        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);

        System.out.println(thread2.getPriority()+"   "+thread1.getPriority()+"   "+thread3.getPriority());

        /*开启线程*/
        thread1.start();
        //System.out.println();
        thread2.start();
        //System.out.println();
        thread3.start();
        //System.out.println();
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
            Thread thread4=new Thread(new PrintChar('e',10));
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
