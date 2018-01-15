import java.util.Stack;

public class TestPriorityQueue {
    public static void main(String [] args){
        /**
         * 测试使用队列
         */
        /*初始化病人信息*/
        Patient patient1=new Patient("John",2);
        Patient patient2=new Patient("Jim",1);
        Patient patient3=new Patient("Tim",5);
        Patient patient4=new Patient("Cindy",7);
        /*进入队列*/
        MyPriorityQueue priorityQueue=new MyPriorityQueue();
        priorityQueue.enqueue(patient1);
        priorityQueue.enqueue(patient2);
        priorityQueue.enqueue(patient3);
        priorityQueue.enqueue(patient4);
        /*出队列*/
        priorityQueue.print();
        System.out.println();
        /**
         * 降序显示前50个素数
         */
        Stack stack=new Stack();
        stack.push(2);
        int i=3;
        while(stack.size()<51){
            boolean bool=false;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    bool=true;
                }
            }
            if(bool==false) {
                stack.push(i);
            }
            i++;
        }
        while(!stack.empty())
        System.out.println(stack.pop());


    }
    static class Patient implements Comparable{
        /*定义病人特征*/
        private String name;
        private int priority;
        public Patient(){}
        public Patient(String name,int priority){
            this.name=name;
            this.priority=priority;
        }
        /*重写方法*/
        public String toString(){
            return name+"(priority:"+priority+")";
        }
        public int compareTo(Object o){
            return this.priority-((Patient)o).priority;
        }
    }
}
