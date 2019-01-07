package Model;

import Controllers.GlownaController;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Utils.DbManager.getConnectSource;


@DatabaseTable(tableName = "Klient")
public class Klient {

    @DatabaseField(canBeNull = false)
    private String imie;

    @DatabaseField(canBeNull = false)
    private String nazwisko;

    @DatabaseField(canBeNull = false)
    private String adres;

    @DatabaseField(canBeNull = false, width = 9)
    private int telefon;

    @DatabaseField(canBeNull = false, generatedId=true, unique = true)
    private int id_klient;




    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getId_klient() {
        return id_klient;
    }

    public void setId_klient(int id_klient) {
        this.id_klient = id_klient;
    }


    public Klient() {


    }

   public static Dao<Klient, Integer> klientDao;

    {
        try {
            klientDao = DaoManager.createDao(getConnectSource(), Klient.class);
        } catch (SQLException e) {e.printStackTrace();
            e.printStackTrace();
        }
    }



    public Klient(String imie, String nazwisko, String adres, int telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.telefon = telefon;

    }

    public void dodajKlient(String imie, String nazwisko, String adres, int telefon) throws SQLException {

        klientDao.createOrUpdate(new Klient(imie, nazwisko, adres, telefon));

    }

    @Override
    public String toString() {
        return  imie +" "+ nazwisko + ", " + adres + ", tel: " + telefon;
    }

    public static void ListRefreshKlient(ListView<Klient> lista) {
        try {
            lista.getItems().clear();
            lista.getItems().addAll(klientDao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    }

