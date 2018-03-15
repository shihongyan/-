import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends JFrame {
    public static void main(String [] args){
        new Server();
    }
    public Server(){
        try{
            /*创建套结字*/
            ServerSocket serverSocket=new ServerSocket(8000,8001);
            System.out.println("Server started at "+new Date()+'\n');
            /*设置服务器监听*/
            Socket socket=serverSocket.accept();
            /*设置输入输出流*/
            DataInputStream inputFromClient=new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient=new DataOutputStream(socket.getOutputStream());

            while(true){
                System.out.println("begin");
                /*从客户端接收数据*/
                double radius=inputFromClient.readDouble();
                /*计算面积*/
                double area=radius*radius*Math.PI;
                /*将结果传给客户端*/
                outputToClient.writeDouble(area);
               System.out.println("Radius received from client: "+radius+'\n');
                System.out.println("Area fount: "+area+'\n');
            }
        }catch (IOException e){
            System.err.println(e);
        }

    }
}
