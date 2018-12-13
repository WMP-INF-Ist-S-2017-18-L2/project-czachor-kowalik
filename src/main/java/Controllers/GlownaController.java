package Controllers;

import Model.Klient;
import Utils.DbManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GlownaController implements Initializable {

    @FXML
    private MenuItem status_wtrakcie;

    @FXML
    private TextField txt_szukanie;

    @FXML
    private MenuItem status_wszystkie;

    @FXML
    private ListView<?> lista_klient;

    @FXML
    private Button but_dodaj_usterka;

    @FXML
    private Button but_odswiez_auto;

    @FXML
    private TextField txt_marka;

    @FXML
    private TextField txt_adres;

    @FXML
    private TextField txt_cc;

    @FXML
    private ListView<?> lista_szukanie;

    @FXML
    private Button but_odswiez_usterka;

    @FXML
    private TextField txt_datzgloszenia;

    @FXML
    private TextField txt_moc;

    @FXML
    private Button but_dodaj_auto;

    @FXML
    private Text txt_id_usterki;

    @FXML
    private TextField txt_rok;

    @FXML
    private TextField txt_wycena;

    @FXML
    private TextField txt_usterka;

    @FXML
    private TextField txt_nazwisko;

    @FXML
    private MenuItem status_odebrane;

    @FXML
    private TextField txt_model;

    @FXML
    private ListView<?> lista_auta;

    @FXML
    private TextField txt_tel;

    @FXML
    private MenuItem status_doodbioru;

    @FXML
    private TextArea txt_opis;

    @FXML
    private Button but_dodaj_klient;

    @FXML
    private Button but_odswiez_klient;

    @FXML
    private TextField txt_datodbior;

    @FXML
    private TextField txt_imie;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        but_dodaj_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Klient k = new Klient();
                    k.dodajKlient("Adam", "Nowak", "Kopisto", 1111, 88);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });



    }


    }
