import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer extends JFrame{
    public static void main(String [] args){
        new MultiThreadServer();
    }
    public MultiThreadServer(){
        try{
            /*创建serverSocket*/
            ServerSocket serverSocket=new ServerSocket(8000);
            System.out.println("MultiThreadServer started at "+new Date()+'\n');
            int clientNo=1;
            while(true){
                /*设置监听*/
                Socket socket=serverSocket.accept();
                System.out.println("Starting thread for client "+clientNo+" at"+new Date()+'\n');
                /*获取IP地址或主机名*/
                InetAddress inetAddress=serverSocket.getInetAddress();
                System.out.println("Client"+clientNo+"'s IP address is "+inetAddress.getHostAddress()+"\n");
                System.out.println("Client"+clientNo+"'s host name is "+inetAddress.getHostName()+"\n");
                /*每个任务创建一个服务*/
                HandleAClient task=new HandleAClient(socket);
                task.run();
                clientNo++;
            }
        }catch (IOException ex){
            System.err.println(ex);
        }
    }
    class HandleAClient implements Runnable{
        private Socket socket;
        public HandleAClient(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
            try{
                DataInputStream inputFromClient=new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient=new DataOutputStream(socket.getOutputStream());
                while(true){
                    double radius=inputFromClient.readDouble();
                    double area=radius*radius*Math.PI;
                    outputToClient.writeDouble(area);
                    System.out.println("radius received from client:"+radius+'\n');
                    System.out.println("Area found:"+area+'\n');
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }
}
