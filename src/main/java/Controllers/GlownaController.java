package Controllers;
import Model.Klient;
import Model.Samochod;
import Model.Usterka;
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
                    k.dodajKlient(txt_imie.getText(), txt_nazwisko.getText(), txt_adres.getText(), Integer.parseInt(txt_tel.getText()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        })
        ;
        Klient klient = new Klient("kutas", "ziom", "dhe", 456);
        klient.setId_klient(1);
        Klient dupa = new Klient("dupas", "ziom", "dhe", 456);
        dupa.setId_klient(2);

        but_dodaj_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Samochod s = new Samochod();
                    s.dodajSamochod(txt_marka.getText(), txt_model.getText(), Integer.parseInt(txt_rok.getText()), Integer.parseInt(txt_cc.getText()), Integer.parseInt(txt_moc.getText()), dupa);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        but_dodaj_usterka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Usterka u = new Usterka();
                    u.dodajUsterka(txt_datzgloszenia.getText(), txt_usterka.getText(), txt_datodbior.getText(), Integer.parseInt(txt_wycena.getText()), txt_opis.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    }
