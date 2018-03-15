import java.io.DataOutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

public class CountServer {
    private RandomAccessFile raf;
    private int count;
    public static void main(String [] args){
        new CountServer();
    }
    public CountServer(){
     try{
         /*服务器创建套接字*/
         ServerSocket serverSocket=new ServerSocket();
         System.out.println("Server started ");
         raf=new RandomAccessFile("count.dat","rw");
         if(raf.length()==0)
             count=0;
         else
             count=raf.readInt();
         while(true){
             /*监听通信*/
             Socket socket=serverSocket.accept();
             DataOutputStream outputToClient=new DataOutputStream(socket.getOutputStream());
             count++;
             outputToClient.writeInt(count);
             raf.seek(0);
             raf.writeInt(count);
         }
     }catch (Exception ex){
         System.out.println(ex);
     }
    }
}
