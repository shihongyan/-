import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.net.Socket;

public class AppletClient extends JApplet{
    private JLabel jlblCount=new JLabel();
    private boolean isStandAlone=false;
    private String host="localhost";
    public void init(){
        add(jlblCount);
            try{
                Socket socket;
                if(isStandAlone)
                    socket = new Socket(host, 8000);
                else
                    socket=new Socket(getCodeBase().getHost(),8000);
                DataInputStream inputFromServer=new DataInputStream(socket.getInputStream());
                int count=inputFromServer.readInt();
                jlblCount.setText("You are visitor number "+count);
                inputFromServer.close();
            }catch (Exception ex){
                System.out.println(ex);
            }
    }
    public static void main(String [] args){
        JFrame frame=new JFrame("Applet client");
        AppletClient applet=new AppletClient();
        applet.isStandAlone=true;
        if(args.length==1)
            applet.host=args[0];
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        frame.pack();
        frame.setVisible(true);
    }
}
