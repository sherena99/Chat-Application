package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {
    public AnchorPane loginFormContext;
    public TextField txtUserName;
    public TextField txtPassword;

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        if (txtUserName.getText().equals("ClientOne") && txtPassword.getText().equals("1111")) {
            Parent load = FXMLLoader.load(getClass().getResource("../View/ClientOne.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();



        } else if (txtUserName.getText().equals("ClientTwo") && txtPassword.getText().equals("2222")) {
            Parent load = FXMLLoader.load(getClass().getResource("../View/ClientTwo.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } else if (txtUserName.getText().equals("ClientThree") && txtPassword.getText().equals("3333")) {
            Parent load = FXMLLoader.load(getClass().getResource("../View/ClientThree.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Please enter the correct username or password !", ButtonType.CLOSE).show();
        }
    }

}
