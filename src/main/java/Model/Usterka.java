package Model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;

import static Utils.DbManager.getConnectSource;


@DatabaseTable(tableName = "Usterka")
public class Usterka {

    @DatabaseField(canBeNull = false )
    private String data;

    @DatabaseField(canBeNull = false)
    private String nazwa;

    @DatabaseField(canBeNull = false)
    private String odbior;

    @DatabaseField(canBeNull = false)
    private int wycena;

    @DatabaseField()
    private String opisUsterka;

    @DatabaseField(canBeNull = false, generatedId = true, unique = true)
    private int id_usterki;

    @DatabaseField(canBeNull = true, foreign = true)
    private Samochod id_sam;

    @DatabaseField(canBeNull = false)
    private int status;

    @DatabaseField
    private String opisNaprawy;

    public String getOpisNaprawy() {
        return opisNaprawy;
    }

    public void setOpisNaprawy(String opisNaprawy) {
        this.opisNaprawy = opisNaprawy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOdbior() {
        return odbior;
    }

    public void setOdbior(String odbior) {
        this.odbior = odbior;
    }

    public int getWycena() {
        return wycena;
    }

    public void setWycena(int wycena) {
        this.wycena = wycena;
    }

    public String getopisUsterka() {
        return opisUsterka;
    }

    public void setopisUsterka(String opisUsterka) {
        this.opisUsterka = opisUsterka;
    }

    public int getId_usterki() {
        return id_usterki;
    }

    public void setId_usterki(int id_usterki) {
        this.id_usterki = id_usterki;
    }

    public Samochod getId_sam() {
        return id_sam;
    }

    public void setId_sam(Samochod id_sam) {
        this.id_sam = id_sam;
    }

    public Usterka() throws SQLException {

    }

    Dao<Usterka, Integer> usterkaDao;


    {
        try {
            usterkaDao = DaoManager.createDao(getConnectSource(), Usterka.class);
        } catch (SQLException e) {e.printStackTrace();
            e.printStackTrace();
        }
    }


    public Usterka(String data, String nazwa, String odbior, int wycena, String opisUsterka) {
        this.data = data;
        this.nazwa = nazwa;
        this.odbior = odbior;
        this.wycena = wycena;
        this.opisUsterka = opisUsterka;
    }





    public void dodajUsterka(String data, String nazwa, String odbior, int wycena, String opisUsterka) throws SQLException {

        usterkaDao.createOrUpdate(new Usterka(data, nazwa, odbior, wycena ,opisUsterka));

    }



}