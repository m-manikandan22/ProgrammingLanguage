import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Mani extends Frame implements Runnable, ActionListener {

    TextField textField;
    TextArea textArea;
    Button send;

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream input;
    DataOutputStream output;
    Thread chat;

    Mani() {
        // ---------- UI ----------
        textField = new TextField();
        textArea = new TextArea();
        textArea.setEditable(false);
        send = new Button("Send");

        Panel bottom = new Panel(new BorderLayout());
        bottom.add(textField, BorderLayout.CENTER);
        bottom.add(send, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(textArea, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        send.addActionListener(this);

        // ---------- Window close ----------
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    if (socket != null) socket.close();
                    if (serverSocket != null) serverSocket.close();
                } catch (Exception ex) {}
                System.exit(0);
            }
        });

        setSize(500, 500);
        setTitle("Mani Chat");
        setVisible(true);

        // ---------- Start server thread ----------
        new Thread(() -> startServer()).start();
    }

    void startServer() {
        try {
            textArea.append("Waiting for user...\n");
            serverSocket = new ServerSocket(12000);
            socket = serverSocket.accept();
            textArea.append("User connected!\n");

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            chat = new Thread(this);
            chat.setDaemon(true);
            chat.start();
        } catch (Exception e) {
            textArea.append("Server error\n");
        }
    }

    public void run() {
        while (true) {
            try {
                String msg = input.readUTF();
                textArea.append("User: " + msg + "\n");
            } catch (Exception e) {
                break;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (output == null) return;

        String msg = textField.getText();
        if (msg.isEmpty()) return;

        textArea.append("Mani: " + msg + "\n");
        textField.setText("");

        try {
            output.writeUTF(msg);
            output.flush();
        } catch (IOException ex) {}
    }

    public static void main(String[] args) {
        new Mani();
    }
}
