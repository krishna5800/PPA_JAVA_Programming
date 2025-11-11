import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

class Challenge implements ActionListener
{
    // GUI
    JFrame fobj;
    JButton bobj;
    JTextField tobj;
    JLabel messageLabel, chatLabel;

    // Networking
    PrintStream poutobj;
    BufferedReader binobj;
    Socket socket;

    public Challenge(String title, int width, int height, PrintStream poutobj, BufferedReader binobj, Socket socket)
    {
        this.poutobj = poutobj;
        this.binobj = binobj;
        this.socket = socket;

        fobj = new JFrame(title);

        messageLabel = new JLabel("Message");
        messageLabel.setBounds(50,50,100,30);

        tobj = new JTextField();
        tobj.setBounds(150,50,100,30);

        bobj = new JButton("Send");
        bobj.setBounds(100,150,80,30);

        chatLabel = new JLabel("");
        chatLabel.setBounds(90,200,200,30);

        fobj.add(bobj);
        fobj.add(tobj);
        fobj.add(messageLabel);
        fobj.add(chatLabel);

        bobj.addActionListener(this);

        fobj.setLayout(null);
        fobj.setSize(width,height);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fobj.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent aobj)
    {
        try
        {
            String str = tobj.getText().trim();
            if (str.isEmpty()) return;

            // Send to server
            poutobj.println(str);

            if ("End".equals(str)) {
                // Do not wait for a reply; end conversation locally
                chatLabel.setText("You ended the chat.");
                disableUI();
                closeQuietly();
                return;
            }

            // Read server’s reply
            String reply = binobj.readLine();
            if (reply == null) {
                chatLabel.setText("Server disconnected.");
                disableUI();
                closeQuietly();
                return;
            }

            // Show reply in label
            chatLabel.setText("Server Says : " + reply);

            // Clear input box
            tobj.setText("");
        }
        catch(Exception eobj)
        {
            chatLabel.setText("Error: " + eobj.getMessage());
            disableUI();
            closeQuietly();
        }
    }

    private void disableUI() {
        bobj.setEnabled(false);
        tobj.setEditable(false);
    }

    private void closeQuietly() {
        try { binobj.close(); } catch (Exception ignored) {}
        try { poutobj.flush(); } catch (Exception ignored) {}
        try { poutobj.close(); } catch (Exception ignored) {}
        try { socket.close(); } catch (Exception ignored) {}
    }
}

class ChatClientLoop
{
    public static void main(String A[]) throws Exception
    {
        Socket sobj = new Socket("localhost", 5100);
        System.out.println("Client gets connected with server successfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream(), true); // autoFlush
        BufferedReader bobj = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        new Challenge("Client", 300, 300, pobj, bobj, sobj);
    }
}
