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
import java.util.ArrayList;
import java.util.List;
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


    boolean statusK, statusS, statusU = false;

    public static Klient openK = new Klient("imie", "nazwisko", "adres", 123456789);
    public static Samochod openS = new Samochod("marka", "model", 2000, 2000, 100, openK);
    public static Usterka openU = new Usterka("01.01.2000", "nazwa", "01.01.2000", 100, "opisdlugi", openS, 1);

    public static void zerujS() {
        openS = new Samochod("marka", "model", 2000, 2000, 100, openK);
    }

    public static void zerujU() {
        openU = new Usterka("01.01.2000", "nazwa", "01.01.2000", 100, "opisdlugi", openS, 1);
    }

    private void klientclear() {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Klient klient = new Klient("imie", "nazwisko", "adres", 123456789);
        Samochod samochod = new Samochod("marka", "model", 2000, 2000, 100, klient);
        Usterka usterka = new Usterka("01.01.2000", "nazwa", "01.01.2000", 100, "opisdlugi", samochod, 1);

        Klient.ListRefreshKlient(lista_klient);
        Samochod.ListRefreshSamochod(lista_auta);
        Usterka.ListRefreshUsterka(lista_usterka);

        List<Klient> szukajListK = new ArrayList();
        List<Klient> wynikListK = new ArrayList();

        List<Samochod> szukajListS = new ArrayList();
        List<Samochod> wynikListS = new ArrayList();

        List<Usterka> szukajListU = new ArrayList();
        List<Usterka> wynikListU = new ArrayList();



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
                if (klient.getId_klient() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Nie wybrałeś klienta!");
                    alert.show();
                } else {

                    try {
                        Samochod s = new Samochod();
                        s.dodajSamochod(txt_marka.getText(), txt_model.getText(), Integer.parseInt(txt_rok.getText()), Integer.parseInt(txt_cc.getText()), Integer.parseInt(txt_moc.getText()), klient);
                        samochodclear();
                        Samochod.zakresS(klient, lista_auta);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        but_dodaj_usterka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (samochod.getId_sam() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Nie wybrałeś samochodu!");
                    alert.show();
                } else {
                    try {
                        Usterka u = new Usterka();
                        u.dodajUsterka(txt_datzgloszenia.getText(), txt_usterka.getText(), txt_datodbior.getText(), Integer.parseInt(txt_wycena.getText()), txt_opis.getText(), samochod, 1);
                        Usterka.zakresU(samochod, lista_usterka);
                        usterkaclear();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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

                Klient k;
                k = lista_klient.getSelectionModel().getSelectedItem();
                if (statusK == false) {

                    txt_imie.setText(k.getImie());
                    txt_nazwisko.setText(k.getNazwisko());
                    txt_adres.setText(k.getAdres());
                    txt_tel.setText(Integer.toString(k.getTelefon()));
                    but_edytuj_klient.setText("Zapisz");
                    statusK = true;
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
                    statusK = false;
                    Klient.ListRefreshKlient(lista_klient);
                }


            }
        });

        but_edytuj_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Samochod s;
                s = lista_auta.getSelectionModel().getSelectedItem();
                if (statusS == false) {

                    txt_marka.setText(s.getMarka());
                    txt_model.setText(s.getModel());
                    txt_cc.setText(Integer.toString(s.getCc()));
                    txt_rok.setText(Integer.toString(s.getRok()));
                    txt_moc.setText(Integer.toString(s.getMoc()));
                    but_edytuj_auto.setText("Zapisz");
                    statusS = true;
                    but_dodaj_auto.setVisible(false);
                    but_usun_auto.setVisible(false);

                } else {
                    try {
                        s.edytujSamochod(txt_marka.getText(), txt_model.getText(), Integer.parseInt(txt_rok.getText()), Integer.parseInt(txt_cc.getText()), Integer.parseInt(txt_moc.getText()), s);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    samochodclear();
                    but_dodaj_klient.setVisible(true);
                    but_usun_auto.setVisible(true);
                    but_edytuj_auto.setText("Edytuj");
                    statusS = false;
                    Samochod.ListRefreshSamochod(lista_auta);
                }


            }
        });

        but_edytuj_usterka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Usterka u;
                u = lista_usterka.getSelectionModel().getSelectedItem();
                if (statusU == false) {

                    txt_usterka.setText(u.getNazwa());
                    txt_datzgloszenia.setText(u.getData());
                    txt_datodbior.setText(u.getOdbior());
                    txt_opis.setText(u.getopisUsterka());
                    txt_wycena.setText(Integer.toString(u.getWycena()));
                    but_edytuj_usterka.setText("Zapisz");
                    statusU = true;
                    but_dodaj_usterka.setVisible(false);
                    but_usun_usterka.setVisible(false);

                } else {
                    try {
                        u.edytujUsterka(txt_datzgloszenia.getText(), txt_usterka.getText(), txt_datodbior.getText(), Integer.parseInt(txt_wycena.getText()), txt_opis.getText(), u);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    usterkaclear();
                    but_dodaj_usterka.setVisible(true);
                    but_usun_usterka.setVisible(true);
                    but_edytuj_usterka.setText("Edytuj");
                    statusU = false;
                    Usterka.ListRefreshUsterka(lista_usterka);
                }


            }
        });


        lista_klient.setOnMouseClicked((MouseEvent eventklient) -> {
            if (eventklient.getButton().equals(MouseButton.PRIMARY) && eventklient.getClickCount() == 2) {
                if (lista_klient.getSelectionModel().getSelectedItem() != null) {
                    openK = lista_klient.getSelectionModel().getSelectedItem();
                    klient.setId_klient(lista_klient.getSelectionModel().getSelectedItem().getId_klient());
                    tabPane.getSelectionModel().select(tabSamochod);
                    zerujS();
                    zerujU();
                    try {
                        Samochod.zakresS(openK, lista_auta);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        lista_auta.setOnMouseClicked((MouseEvent eventauto) -> {
            if (eventauto.getButton().equals(MouseButton.PRIMARY) && eventauto.getClickCount() == 2) {
                if (lista_auta.getSelectionModel().getSelectedItem() != null) {
                    openS = lista_auta.getSelectionModel().getSelectedItem();
                    samochod.setId_sam(lista_auta.getSelectionModel().getSelectedItem().getId_sam());
                    zerujU();
                    tabPane.getSelectionModel().select(tabUsterka);
                    try {
                        Usterka.zakresU(openS, lista_usterka);
                        openK = Klient.getK(openS.getId_klient().getId_klient());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        lista_usterka.setOnMouseClicked((MouseEvent eventusterka) -> {
            if (eventusterka.getButton().equals(MouseButton.PRIMARY) && eventusterka.getClickCount() == 2) {
                if (lista_usterka.getSelectionModel().getSelectedItem() != null) {
                    openU = lista_usterka.getSelectionModel().getSelectedItem();
                    try {
                        openS = Samochod.getS(openU.getId_sam().getId_sam());
                        openK = Klient.getK(openS.getId_klient().getId_klient());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }



                    usterka.setId_usterki(lista_usterka.getSelectionModel().getSelectedItem().getId_usterki());
                    openZgloszenie();

                }
            }
        });


        but_szukaj_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Klient.ListRefreshKlient(lista_klient);
                szukajListK.clear();
                wynikListK.clear();
                szukajListK.addAll(lista_klient.getItems());
                String tekst = txt_szukaj_klient.getText().toLowerCase();
                int a = szukajListK.size();
                for (int i = 0; i < a; i++) {
                    if (szukajListK.get(i).toString().toLowerCase().contains(tekst)) {
                        wynikListK.add(szukajListK.get(i));
                    }
                }
                lista_klient.getItems().clear();
                lista_klient.getItems().addAll(wynikListK);
            }
        });

        but_szukaj_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Samochod.ListRefreshSamochod(lista_auta);
                szukajListS.clear();
                wynikListS.clear();
                szukajListS.addAll(lista_auta.getItems());
                String tekst = txt_szukaj_auto.getText().toLowerCase();
                int a = szukajListS.size();
                for (int i = 0; i < a; i++) {
                    if (szukajListS.get(i).toString().toLowerCase().contains(tekst)) {
                        wynikListS.add(szukajListS.get(i));
                    }
                }
                lista_auta.getItems().clear();
                lista_auta.getItems().addAll(wynikListS);
            }
        });

        but_szukaj_usterka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Usterka.ListRefreshUsterka(lista_usterka);
                szukajListU.clear();
                wynikListU.clear();
                szukajListU.addAll(lista_usterka.getItems());
                String tekst = txt_szukaj_usterka.getText().toLowerCase();
                int a = szukajListU.size();
                for (int i = 0; i < a; i++) {
                    if (szukajListU.get(i).toString().toLowerCase().contains(tekst)) {
                        wynikListU.add(szukajListU.get(i));
                    }
                }
                lista_usterka.getItems().clear();
                lista_usterka.getItems().addAll(wynikListU);
            }
        });


        but_wszystkie_klient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Klient.ListRefreshKlient(lista_klient);
                txt_szukaj_klient.clear();
            }
        });

        but_wszystkie_auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Samochod.ListRefreshSamochod(lista_auta);
                txt_szukaj_auto.clear();
            }
        });

        but_wszystkie_usterka.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               Usterka.ListRefreshUsterka(lista_usterka);
               txt_szukaj_usterka.clear();
            }
        });



    }

    private void openZgloszenie() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Zgloszenie.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Szczegóły");
            stage.setScene(new Scene(root, 800, 500));
            stage.setResizable(false);
            stage.show();

            stage.setOnCloseRequest(event -> {
                Usterka.ListRefreshUsterka(lista_usterka);
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}