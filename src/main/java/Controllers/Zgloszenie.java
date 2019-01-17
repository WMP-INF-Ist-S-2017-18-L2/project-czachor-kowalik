package Controllers;

import Model.Usterka;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
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


    Usterka usterka = GlownaController.openU;
    int status = usterka.getStatus();

    public void tekstStatus(MenuButton button) {
        if (status == 1) {
            button.setText("W trakcie");
        } else if (status == 2) {
            button.setText("Do odbioru");
        } else if (status == 3) {
            button.setText("Odebrane");
        } else {
            button.setText("Zjebane");
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txt_klient_S.setText(GlownaController.openK.toString());
        txt_auto_S.setText(GlownaController.openS.toString());
        txt_usterka_S.setText(usterka.toString());
        txt_opis_S.setText(usterka.getopisUsterka());
        txt_sprawozdanie_S.setText(usterka.getOpisNaprawy());
        txt_koszt_S.setText(Integer.toString(usterka.getWycena()));
        tekstStatus(menu_status_S);


//
        but_zapisz_S.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usterka.setOpisNaprawy(txt_sprawozdanie_S.getText());
                usterka.setWycena(Integer.parseInt(txt_koszt_S.getText()));
                usterka.setStatus(status);
                try {
                    usterka.zapiszZmiany(txt_sprawozdanie_S.getText(), Integer.parseInt(txt_koszt_S.getText()), status, GlownaController.openU.getId_usterki());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                txt_usterka_S.setText(usterka.toString());
                GlownaController.openU = usterka;
            }
        });

        status_wtrakcie_S.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                status = 1;
                tekstStatus(menu_status_S);
            }
        });

        status_doodbioru_S.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                status = 2;
                tekstStatus(menu_status_S);
            }
        });

        status_odebrane_S.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                status = 3;
                tekstStatus(menu_status_S);
            }
        });





    }
}
