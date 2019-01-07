package Controllers;

import Model.Klient;
import Model.Samochod;
import Model.Usterka;
import Utils.DbManager;
import com.j256.ormlite.dao.GenericRawResults;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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
    public ListView<Klient> lista_klient;

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
    private ListView<Samochod> lista_auta;

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

    @FXML
    private Tab tabKlient;

    @FXML
    private Tab tabUsterka;

    @FXML
    private Tab tabSamochod;

    @FXML
    private TabPane tabPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Klient klient = new Klient("imie", "nazwisko", "adres", 123456789);
        Samochod samochod = new Samochod("marka", "model", 2000, 2000, 100, klient);
        Usterka usterka = new Usterka("01.01.2000", "nazwa", "01.01.2000", 100, "opisdlugi", samochod, 1);
        Klient.ListRefreshKlient(lista_klient);
        Samochod.ListRefreshSamochod(lista_auta);


        but_dodaj_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(!txt_imie.getText().isEmpty() && !txt_nazwisko.getText().isEmpty() && !txt_adres.getText().isEmpty() && !txt_tel.getText().isEmpty()){
                    Klient k = new Klient();
                    if(txt_tel.getText().matches("[0-9]*") && txt_tel.getText().length() == 9) {
                        k.dodajKlient(txt_imie.getText(), txt_nazwisko.getText(), txt_adres.getText(), Integer.parseInt(txt_tel.getText()));
                        Klient.ListRefreshKlient(lista_klient);
                        txt_imie.clear();
                        txt_nazwisko.clear();
                        txt_adres.clear();
                        txt_tel.clear();
                    }
                    else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Nieprawidłowy numer telefonu!");
                    alert.show();
                    }}
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("Niewypełniłeś wszystkich pól!");
                        alert.show();

                    }


                } catch (SQLException e) {
                    e.printStackTrace();

                }


            }
        })
        ;


        but_dodaj_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Samochod s = new Samochod();
                    s.dodajSamochod(txt_marka.getText(), txt_model.getText(), Integer.parseInt(txt_rok.getText()), Integer.parseInt(txt_cc.getText()), Integer.parseInt(txt_moc.getText()), klient);
                    txt_marka.clear();
                    txt_model.clear();
                    txt_rok.clear();
                    txt_moc.clear();
                    txt_cc.clear();
                    Samochod.ListRefreshSamochod(lista_auta);
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
                    u.dodajUsterka(txt_datzgloszenia.getText(), txt_usterka.getText(), txt_datodbior.getText(), Integer.parseInt(txt_wycena.getText()), txt_opis.getText(), samochod, 1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        lista_klient.setOnMouseClicked((MouseEvent eventklient) -> {
            if (eventklient.getButton().equals(MouseButton.PRIMARY) && eventklient.getClickCount() == 2) {
                if (lista_klient.getSelectionModel().getSelectedItem() != null) {
                    klient.setId_klient(lista_klient.getSelectionModel().getSelectedItem().getId_klient());
                    tabPane.getSelectionModel().select(tabSamochod);

                }
            }
        });

        lista_auta.setOnMouseClicked((MouseEvent eventauto) -> {
            if (eventauto.getButton().equals(MouseButton.PRIMARY) && eventauto.getClickCount() == 2) {
                if (lista_auta.getSelectionModel().getSelectedItem() != null) {
                    samochod.setId_klient(lista_auta.getSelectionModel().getSelectedItem().getId_klient());
                    tabPane.getSelectionModel().select(tabUsterka);

                }
            }
        });



    }}