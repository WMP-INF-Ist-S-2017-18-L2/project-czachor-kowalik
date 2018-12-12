package Model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;

import static Utils.DbManager.getConnectSource;


@DatabaseTable(tableName = "Model.Klient")
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


    public Klient() throws SQLException {


    }

    Dao<Klient, Integer> klientDao =
            DaoManager.createDao(getConnectSource(), Klient.class);


    Klient obiektKlient = new Klient();

    public void ustawKlient(String imie, String nazwisko, String adres, int telefon, int id_klient){
        obiektKlient.imie = imie;
        obiektKlient.nazwisko = nazwisko;
        obiektKlient.adres = adres;
        obiektKlient.telefon = telefon;
        obiektKlient.id_klient = id_klient;
    }

    public void dodajKlient (String imie, String nazwisko, String adres, int telefon, int id_klient){
        ustawKlient(imie,nazwisko,adres, telefon, id_klient);

    }


}