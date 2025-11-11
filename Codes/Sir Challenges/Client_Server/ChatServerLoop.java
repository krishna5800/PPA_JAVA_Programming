import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

class ServerChallenge implements ActionListener
{
    // GUI (same layout as client)
    JFrame fobj;
    JButton bobj;
    JTextField tobj;
    JLabel messageLabel, chatLabel;

    // Networking
    PrintStream poutobj;      // to client
    BufferedReader binobj;    // from client
    Socket clientSocket;
    ServerSocket serverSocket;

    public ServerChallenge(String title, int width, int height, PrintStream poutobj, BufferedReader binobj,
                           Socket clientSocket, ServerSocket serverSocket)
    {
        this.poutobj = poutobj;
        this.binobj = binobj;
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;

        fobj = new JFrame(title);

        messageLabel = new JLabel("Message");
        messageLabel.setBounds(50, 50, 100, 30);

        tobj = new JTextField();
        tobj.setBounds(150, 50, 100, 30);

        bobj = new JButton("Send");
        bobj.setBounds(100, 150, 80, 30);

        chatLabel = new JLabel("");
        chatLabel.setBounds(90, 200, 200, 30);

        fobj.add(bobj);
        fobj.add(tobj);
        fobj.add(messageLabel);
        fobj.add(chatLabel);

        bobj.addActionListener(this);

        fobj.setLayout(null);
        fobj.setSize(width, height);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fobj.setVisible(true);

        // Background reader so GUI stays responsive
        Thread reader = new Thread(this::listenToClient, "client-listener");
        reader.setDaemon(true);
        reader.start();
    }

    private void listenToClient()
    {
        try {
            String msg;
            while ((msg = binobj.readLine()) != null) {
                final String fromClient = msg;

                if ("End".equals(fromClient)) {
                    SwingUtilities.invokeLater(() -> {
                        chatLabel.setText("Client ended the chat.");
                        disableUI();
                    });
                    closeQuietly();
                    return;
                }

                SwingUtilities.invokeLater(() ->
                    chatLabel.setText("Client Says : " + fromClient)
                );
            }

            // Client closed connection (readLine returned null)
            SwingUtilities.invokeLater(() -> {
                chatLabel.setText("Client disconnected.");
                disableUI();
            });
            closeQuietly();

        } catch (IOException e) {
            SwingUtilities.invokeLater(() -> {
                chatLabel.setText("Connection error.");
                disableUI();
            });
            closeQuietly();
        }
    }

    @Override
    public void actionPerformed(ActionEvent aobj)
    {
        try {
            String str = tobj.getText().trim();
            if (str.isEmpty()) return;

            // Send reply to client (server does not echo locally)
            poutobj.println(str);
            tobj.setText("");
        } catch (Exception eobj) {
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
        try { clientSocket.close(); } catch (Exception ignored) {}
        try { serverSocket.close(); } catch (Exception ignored) {}
    }
}

public class ChatServerLoop
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("Server is waiting at port number 5100");

        Socket sobj = ssobj.accept();
        System.out.println("Client request gets accepted successfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream(), true); // autoFlush
        BufferedReader bobj = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        SwingUtilities.invokeLater(() ->
            new ServerChallenge("Server", 300, 300, pobj, bobj, sobj, ssobj)
        );
    }
}
