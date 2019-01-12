package Model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.table.DatabaseTable;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;

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

    @DatabaseField(canBeNull = false, foreign = true)
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

    public Usterka() {

    }

    public static Dao<Usterka, Integer> usterkaDao;


    {
        try {
            usterkaDao = DaoManager.createDao(getConnectSource(), Usterka.class);
        } catch (SQLException e) {e.printStackTrace();
            e.printStackTrace();
        }
    }


    public Usterka(String data, String nazwa, String odbior, int wycena, String opisUsterka, Samochod id_sam, int status) {
        this.data = data;
        this.nazwa = nazwa;
        this.odbior = odbior;
        this.wycena = wycena;
        this.opisUsterka = opisUsterka;
        this.id_sam = id_sam;
        this.status = status;
    }

    @Override
    public String toString() {
        return  nazwa + ";  od " + data + " do " + odbior + "; wycena: " + wycena;
    }



    public void dodajUsterka(String data, String nazwa, String odbior, int wycena, String opisUsterka, Samochod id_sam, int status) throws SQLException {

        usterkaDao.createOrUpdate(new Usterka(data, nazwa, odbior, wycena ,opisUsterka, id_sam, status));

    }

    public void usunUsterka(ListView<Usterka> lista) throws SQLException {

        usterkaDao.delete(lista.getSelectionModel().getSelectedItem());

    }

    UpdateBuilder<Usterka, Integer> Update = usterkaDao.updateBuilder();

    public void edytujUsterka(String data, String nazwa, String odbior, int wycena, String opisUsterka, Usterka usterka) throws SQLException {
        Update.updateColumnValue("data", data);
        Update.updateColumnValue("nazwa", nazwa);
        Update.updateColumnValue("odbior", odbior);
        Update.updateColumnValue("opisUsterka", opisUsterka);
        Update.updateColumnValue("status", status);
        Update.updateColumnValue("wycena", wycena);
        Update.where().eq("id_usterki", usterka.getId_usterki());
        Update.update();

    }

    public void zapiszZmiany(String opisNaprawy, int koszt, int status, int id) throws SQLException {
        if(opisNaprawy!=null) {Update.updateColumnValue("opisNaprawy" , opisNaprawy);}
        if(status!=0) {Update.updateColumnValue("status" , status);}
        if(koszt!=0) Update.updateColumnValue("wycena" , koszt);
        Update.where().eq("id_usterki", id);
        Update.update();
    }

    public static void zakresU(ListView<Samochod> listaS, ListView<Usterka> listaU) throws SQLException {
        QueryBuilder<Usterka, Integer> zakres = usterkaDao.queryBuilder();
        zakres.where().eq("id_sam_id", listaS.getSelectionModel().getSelectedItem().getId_sam());
        PreparedQuery<Usterka> prepare = zakres.prepare();
        List<Usterka> lista = Usterka.usterkaDao.query(prepare);
        listaU.getItems().clear();
        listaU.getItems().addAll(lista);
    }


    public static void ListRefreshUsterka(ListView<Usterka> lista) {
        try {
            lista.getItems().clear();
            lista.getItems().addAll(usterkaDao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}