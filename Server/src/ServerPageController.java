import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerPageController implements Initializable {
    public AnchorPane serverPageContext;
    public TextArea txtTextArea;
    public TextField txtTextField;

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    String messageIn = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(()->{
            try {
                serverSocket = new ServerSocket(5000);
                System.out.println("Server Started Waiting for client! .....");
                socket=serverSocket.accept();
                System.out.println("Client Accepted! .......");

                dataInputStream=new DataInputStream(socket.getInputStream());
                dataOutputStream=new DataOutputStream(socket.getOutputStream());

                while (!messageIn.equals("end")){
                    messageIn=dataInputStream.readUTF();
                    txtTextArea.appendText("\nClient:" + messageIn.trim()+"\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    public void sendBtnOnAction(ActionEvent actionEvent) throws IOException {
        String text = txtTextField.getText();
        txtTextArea.appendText("\t\t\t\t\t\t\t\tServer :" +text.trim());
        dataOutputStream.writeUTF(text);
        txtTextField.setText("");

    }
}
