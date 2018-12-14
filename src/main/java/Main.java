import Controllers.GlownaController;
import Utils.DbManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.awt.geom.AreaOp;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Glowna.fxml"));

        Scene scene = new Scene(root);
        stage.setMinHeight(700);
        stage.setMinWidth(850);
        stage.setTitle("Warsztat");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, IOException {
        DbManager.initDatabase();
        launch(args);



    }
}
