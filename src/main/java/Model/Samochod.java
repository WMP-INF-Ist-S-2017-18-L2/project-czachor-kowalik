package Model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;

import static Utils.DbManager.getConnectSource;

@DatabaseTable(tableName = "Model.Samochod")
public class Samochod {

    @DatabaseField(canBeNull = false)
    private String marka;

    @DatabaseField(canBeNull = false)
    private String model;

    @DatabaseField(canBeNull = false)
    private int rok;

    @DatabaseField(canBeNull = false)
    private int cc;

    @DatabaseField(canBeNull = false)
    private int moc;

    @DatabaseField(canBeNull = false, generatedId = true, unique = true)
    private int id_sam;

    @DatabaseField(canBeNull = false, foreign = true)
    private Klient id_klient;


    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getMoc() {
        return moc;
    }

    public void setMoc(int moc) {
        this.moc = moc;
    }

    public int getId_sam() {
        return id_sam;
    }

    public void setId_sam(int id_sam) {
        this.id_sam = id_sam;
    }

    public Klient getId_klient() {
        return id_klient;
    }

    public void setId_klient(Klient id_klient) {
        this.id_klient = id_klient;
    }

    public Samochod() throws SQLException {

    }

    Dao<Samochod, Integer> samochodDao =
            DaoManager.createDao(getConnectSource(), Samochod.class);
}
