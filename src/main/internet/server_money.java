import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server_money {
    private DataInputStream fromclient;
    private DataOutputStream toclient;
    public static void main(String [] args){
        new server_money();
    }
    public server_money(){
        try{
            /*创建套接字*/
            ServerSocket serverSocket=new ServerSocket(8000);
            /*设置监听*/
            Socket socket=serverSocket.accept();
            InetAddress inetAddress=socket.getInetAddress();
            System.out.println("连接客户端IP："+inetAddress.getHostAddress());
            System.out.println("连接客户端名称："+inetAddress.getHostName());
            fromclient=new DataInputStream(socket.getInputStream());
            toclient=new DataOutputStream(socket.getOutputStream());
            while(true){
                double lilv=fromclient.readDouble();
                int year=fromclient.readInt();
                double sum=fromclient.readDouble();
                double result=sum*(1+lilv)/(year*12);
                toclient.writeDouble(result);
                System.out.println("输入的利率："+lilv);
                System.out.println("贷款时间："+year);
                System.out.println("贷款本金："+sum);
                System.out.println("每月应还："+result);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
