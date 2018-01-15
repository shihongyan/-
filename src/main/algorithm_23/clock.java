import javax.swing.*;

public class clock extends JApplet {
    public clock(){
        add(new JLabel("Hi,The World is so beautiful !!!"));
    }
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame=new JFrame("clock");
                frame.add(new clock());
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(200,200);
                frame.setVisible(true);
            }
        });
    }
}
