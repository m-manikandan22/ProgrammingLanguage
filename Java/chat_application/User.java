import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class User extends Frame implements Runnable, ActionListener {

    TextField textField;
    TextArea textArea;
    Button send;

    Socket socket;
    DataInputStream input;
    DataOutputStream output;
    Thread chat;

    User() {
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

        // ---------- Window Closer ----------
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    if (socket != null) socket.close();
                } catch (Exception ex) {}
                System.exit(0);
            }
        });

        // ---------- Network ----------
        try {
            socket = new Socket("localhost", 12000);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            textArea.append("Connection error\n");
        }

        chat = new Thread(this);
        chat.setDaemon(true);
        chat.start();

        // ---------- Frame ----------
        setSize(500, 500);
        setTitle("User Chat");
        setVisible(true);
    }

    public void run() {
        while (true) {
            try {
                String msg = input.readUTF();
                textArea.append("Mani: " + msg + "\n");
            } catch (Exception e) {
                break;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String msg = textField.getText();
        if (msg.isEmpty()) return;

        textArea.append("User: " + msg + "\n");
        textField.setText("");

        try {
            output.writeUTF(msg);
            output.flush();
        } catch (IOException ex) {}
    }

    public static void main(String[] args) {
        new User();
    }
}
