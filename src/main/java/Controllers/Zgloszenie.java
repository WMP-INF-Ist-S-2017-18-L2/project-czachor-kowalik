package Controllers;

import Model.Klient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Zgloszenie implements Initializable {

    @FXML
    private TextArea txt_sprawozdanie_S;

    @FXML
    private Text txt_auto_S;

    @FXML
    private MenuButton menu_status_S;

    @FXML
    private Button but_zapisz_S;

    @FXML
    private Text txt_usterka_S;

    @FXML
    private Text txt_opis_S;

    @FXML
    private MenuItem status_doodbioru_S;

    @FXML
    private Text txt_klient_S;

    @FXML
    private MenuItem status_wtrakcie_S;

    @FXML
    private TextField txt_koszt_S;

    @FXML
    private MenuItem status_odebrane_S;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Klient klient = GlownaController.getKlient();


    }
}
