import javax.swing.*;
import java.awt.event.*;

class Challenge implements ActionListener
{
    //Characteristics

    JFrame fobj;
    JButton bobj;
    JTextField tobj;
    JLabel messageLabel,chatLabel;

    public Challenge(String title, int width, int height)
    {
        fobj = new JFrame(title);

        messageLabel = new JLabel("Message");
        messageLabel.setBounds(50,50,100,30);

        tobj = new JTextField();
        tobj.setBounds(150,50,100,30);

        bobj = new JButton("Send");
        bobj.setBounds(100,150,80,30);

        chatLabel = new JLabel("");
        chatLabel.setBounds(90,200,100,30);

        fobj.add(bobj);
        fobj.add(tobj);
        fobj.add(messageLabel);
        fobj.add(chatLabel);
        
        fobj.setLayout(null);
        fobj.setSize(width,height);

        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public void actionPerformed(ActionEvent aobj)
    {
    }
}

class Server_GUI 
{
    public static void main(String A[]) 
    {
        Challenge cobj = new Challenge("Server", 300, 300);
    }
}
