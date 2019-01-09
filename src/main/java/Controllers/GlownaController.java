package Controllers;

import Model.Klient;
import Model.Samochod;
import Model.Usterka;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GlownaController implements Initializable {

    @FXML
    private Button but_wszystkie_usterka;

    @FXML
    private Button but_szukaj_klient;

    @FXML
    public ListView<Klient> lista_klient;

    @FXML
    private Button but_usun_auto;

    @FXML
    private Button but_dodaj_usterka;

    @FXML
    private TextField txt_marka;

    @FXML
    private TextField txt_adres;

    @FXML
    private TextField txt_cc;

    @FXML
    private TextField txt_szukaj_auto;

    @FXML
    private TextField txt_szukaj_klient;

    @FXML
    private Button but_usun_klient;

    @FXML
    private TextField txt_datzgloszenia;

    @FXML
    private TextField txt_moc;

    @FXML
    private Button but_dodaj_auto;

    @FXML
    private Button but_edytuj_auto;

    @FXML
    private TextField txt_rok;

    @FXML
    private Button but_wszystkie_klient;

    @FXML
    private TextField txt_wycena;

    @FXML
    private Button but_edytuj_usterka;

    @FXML
    private TextField txt_usterka;

    @FXML
    private Button but_szukaj_usterka;

    @FXML
    private Button but_szukaj_auto;

    @FXML
    private Button but_wszystkie_auto;

    @FXML
    private TextField txt_nazwisko;

    @FXML
    private TextField txt_model;

    @FXML
    public ListView<Samochod> lista_auta;

    @FXML
    private TextField txt_tel;

    @FXML
    private Tab tabKlient;

    @FXML
    private Tab tabUsterka;

    @FXML
    private Tab tabSamochod;

    @FXML
    private TextArea txt_opis;

    @FXML
    public ListView<Usterka> lista_usterka;

    @FXML
    private Button but_dodaj_klient;

    @FXML
    private TextField txt_szukaj_usterka;

    @FXML
    private TextField txt_datodbior;

    @FXML
    private Button but_edytuj_klient;

    @FXML
    private TextField txt_imie;

    @FXML
    private TabPane tabPane;

    @FXML
    private Button but_usun_usterka;


    boolean status = false;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Klient klient = new Klient("imie", "nazwisko", "adres", 123456789);
        Samochod samochod = new Samochod("marka", "model", 2000, 2000, 100, klient);
        Usterka usterka = new Usterka("01.01.2000", "nazwa", "01.01.2000", 100, "opisdlugi", samochod, 1);
        Klient.ListRefreshKlient(lista_klient);
        Samochod.ListRefreshSamochod(lista_auta);
        Usterka.ListRefreshUsterka(lista_usterka);



        but_dodaj_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!txt_imie.getText().isEmpty() && !txt_nazwisko.getText().isEmpty() && !txt_adres.getText().isEmpty() && !txt_tel.getText().isEmpty()) {
                        Klient k = new Klient();
                        if (txt_tel.getText().matches("[0-9]*") && txt_tel.getText().length() == 9) {
                            k.dodajKlient(txt_imie.getText(), txt_nazwisko.getText(), txt_adres.getText(), Integer.parseInt(txt_tel.getText()));
                            Klient.ListRefreshKlient(lista_klient);
                            klientclear();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setContentText("Nieprawidłowy numer telefonu!");
                            alert.show();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("Niewypełniłeś wszystkich pól!");
                        alert.show();

                    }


                } catch (SQLException e) {
                    e.printStackTrace();

                }


            }
        });


        but_dodaj_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Samochod s = new Samochod();
                    s.dodajSamochod(txt_marka.getText(), txt_model.getText(), Integer.parseInt(txt_rok.getText()), Integer.parseInt(txt_cc.getText()), Integer.parseInt(txt_moc.getText()), klient);
                    samochodclear();
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
                    Usterka.ListRefreshUsterka(lista_usterka);
                    usterkaclear();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        but_usun_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Klient k = new Klient();
                    k.usunKlient(lista_klient);
                    Klient.ListRefreshKlient(lista_klient);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        but_usun_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Samochod s = new Samochod();
                    s.usunSamochod(lista_auta);
                    Samochod.ListRefreshSamochod(lista_auta);
                    klientclear();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        but_usun_usterka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Usterka u = new Usterka();
                    u.usunUsterka(lista_usterka);
                    Usterka.ListRefreshUsterka(lista_usterka);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        but_edytuj_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Klient k,temp  = new Klient();
                k = lista_klient.getSelectionModel().getSelectedItem();
                temp = lista_klient.getSelectionModel().getSelectedItem();
                if (status == false) {

                    txt_imie.setText(k.getImie());
                    txt_nazwisko.setText(k.getNazwisko());
                    txt_adres.setText(k.getAdres());
                    txt_tel.setText(Integer.toString(k.getTelefon()));
                    but_edytuj_klient.setText("Zapisz");
                    status = true;
                    but_dodaj_klient.setVisible(false);
                    but_usun_klient.setVisible(false);

                } else {
                    try {
                        k.edytujKlient(txt_imie.getText(), txt_nazwisko.getText(), txt_adres.getText(), Integer.parseInt(txt_tel.getText()), k);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    klientclear();
                    but_dodaj_klient.setVisible(true);
                    but_usun_klient.setVisible(true);
                    but_edytuj_klient.setText("Edytuj");
                    status = false;
                    Klient.ListRefreshKlient(lista_klient);
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
                    samochod.setId_sam(lista_auta.getSelectionModel().getSelectedItem().getId_sam());
                    tabPane.getSelectionModel().select(tabUsterka);

                }
            }
        });

        lista_usterka.setOnMouseClicked((MouseEvent eventusterka) -> {
            if (eventusterka.getButton().equals(MouseButton.PRIMARY) && eventusterka.getClickCount() == 2) {
                if (lista_usterka.getSelectionModel().getSelectedItem() != null) {
                    usterka.setId_usterki(lista_usterka.getSelectionModel().getSelectedItem().getId_usterki());
                    openZgloszenie(usterka);

                }
            }
        });


    }

    private void klientclear(){
        txt_imie.clear();
        txt_nazwisko.clear();
        txt_adres.clear();
        txt_tel.clear();
    }

    private void samochodclear() {
        txt_marka.clear();
        txt_model.clear();
        txt_rok.clear();
        txt_moc.clear();
        txt_cc.clear();
    }

    private void usterkaclear() {
        txt_usterka.clear();
        txt_datodbior.clear();
        txt_datzgloszenia.clear();
        txt_wycena.clear();
        txt_opis.clear();
    }

    private void openZgloszenie(Usterka usterka) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Zgloszenie.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Szczegóły");
            stage.setScene(new Scene(root, 850, 700));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


}}

