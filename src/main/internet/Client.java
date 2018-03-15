import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    /*输入输出流*/
    private DataOutputStream toServer;
    private DataInputStream fromServer;
    public static void main(String [] args){
        new Client();
    }
    public Client(){
        try{
            /*定义输入流--从控制台获取输入*/
            Scanner sc=new Scanner(System.in);
            /*设置连接到服务器*/
            Socket socket=new Socket("localhost",8000);
            fromServer=new DataInputStream(socket.getInputStream());
            toServer=new DataOutputStream(socket.getOutputStream());
            while(true){
                /*获取数据radius*/
                double radius=Double.parseDouble(sc.next());
                /*传送到服务器*/
                toServer.writeDouble(radius);
                /*清空缓存区数据流*/
                toServer.flush();
                /*得到服务器计算后的数据*/
                double area=fromServer.readDouble();
                System.out.println("Radius is "+radius+"\n");
                System.out.println("Area received from the server is "+area+'\n');
            }
        }catch (IOException ex){
            System.out.println(ex.toString());
        }
    }
}
