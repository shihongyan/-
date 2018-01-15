import javax.swing.*;

public class FlashingText extends JApplet implements Runnable {
    private JLabel jLabel=new JLabel("welcome",JLabel.CENTER);
    public FlashingText(){
        add(jLabel);
        new Thread(this).start();
    }
    public void run(){
        try{
            while(true){
                if(jLabel.getText()==null)
                    jLabel.setText("welcome");
                else
                    jLabel.setText(null);
                Thread.sleep(200);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
