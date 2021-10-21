package ex22_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class ex22_6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ex22_6.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ex22_6");
        stage.setScene(scene);
        stage.show();
    }
}
