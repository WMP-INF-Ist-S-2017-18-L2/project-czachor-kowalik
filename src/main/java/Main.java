import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static javafx.application.Application.launch;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Glowna.fxml"));

        Scene scene = new Scene(root);
        stage.setMinHeight(700);
        stage.setMinWidth(850);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, IOException {
// this uses h2 but you can change it to match your database
        String databaseUrl = "jdbc:sqlite:bazadanych.db";
// create a connection source to our database
        ConnectionSource connectionSource;
        connectionSource = new JdbcConnectionSource(databaseUrl);

// instantiate the DAO to handle Account with String id
        Dao<Klient, Integer> klientDao =
                DaoManager.createDao(connectionSource, Klient.class);
        Dao<Samochod,Integer> samochodDao =
                DaoManager.createDao(connectionSource, Samochod.class);
        Dao<Usterka,Integer> usterkaDao =
                DaoManager.createDao(connectionSource, Usterka.class);



//            TableUtils.createTable(connectionSource, Klient.class);
//            TableUtils.createTable(connectionSource, Samochod.class);
//            TableUtils.createTable(connectionSource, Usterka.class);

        launch(args);

// close the connection source
        connectionSource.close();
    }
}
