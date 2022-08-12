package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientOneController implements Initializable {
    public AnchorPane clientOneContext;
    public TextArea txtTextArea;
    public TextField txtTextField;

    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    Socket socket = null;
    String messageIn = "";


    public void sendBtnOnAction(ActionEvent actionEvent) throws IOException {
        String reply = "";
        reply = txtTextField.getText();
        txtTextArea.appendText(("\t\t\t\t\t\t\t\tClientOne :" + reply.trim()));
        dataOutputStream.writeUTF(reply);
        txtTextField.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("localhost", 5000);
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());


                    while (!messageIn.equals("end")) {
                        messageIn = dataInputStream.readUTF();
                        txtTextArea.appendText("\nServer :" + messageIn.trim() + "\n");
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
