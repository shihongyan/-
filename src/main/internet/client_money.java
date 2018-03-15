import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client_money {
    /*定义与服务器交换数据流*/
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    public static void main(String [] args){ new client_money(); }
    public client_money(){
        /*设置从控制台获取的数据*/
        Scanner scanner=new Scanner(System.in);
        /*连接到服务器*/
        try{
            /*客户端创建套接字*/
            Socket socket=new Socket("localhost",8000);
            /*连接服务器的数据通信*/
            fromServer=new DataInputStream(socket.getInputStream());
            toServer=new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.println("请输入利率：");
                double lilv=scanner.nextDouble();
                toServer.writeDouble(lilv);
                System.out.println("请输入贷款年数：");
                int year=scanner.nextInt();
                toServer.writeInt(year);
                System.out.println("请输入贷款总额：");
                double sum=scanner.nextDouble();
                toServer.writeDouble(sum);
                toServer.flush();
                double result=fromServer.readDouble();
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
