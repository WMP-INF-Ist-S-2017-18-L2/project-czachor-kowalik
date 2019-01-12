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

@DatabaseTable(tableName = "Samochod")
public class Samochod {

    @DatabaseField(canBeNull = false)
    public String marka;

    @DatabaseField(canBeNull = false)
    public String model;

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

    public Samochod() {

    }

    static Dao<Samochod, Integer> samochodDao;

    {
        try {
            samochodDao = DaoManager.createDao(getConnectSource(), Samochod.class);
        } catch (SQLException e) {e.printStackTrace();
            e.printStackTrace();
        }
    }



    public Samochod(String marka, String model, int rok, int cc, int moc, Klient id_klient) {
        this.marka = marka;
        this.model = model;
        this.rok = rok;
        this.cc = cc;
        this.moc = moc;
        this.id_klient = id_klient;
    }



    public void dodajSamochod(String marka, String model, int rok, int cc, int moc, Klient id_klient) throws SQLException {

        samochodDao.createOrUpdate(new Samochod(marka, model, rok, cc, moc, id_klient));

    }

    public void usunSamochod(ListView<Samochod> lista) throws SQLException {

        samochodDao.delete(lista.getSelectionModel().getSelectedItem());

    }

    public void edytujSamochod(String marka, String model, int rok, int cc, int moc, Samochod samochod) throws SQLException {
        UpdateBuilder<Samochod, Integer> Update = samochodDao.updateBuilder();
        Update.updateColumnValue("marka", marka);
        Update.updateColumnValue("model", model);
        Update.updateColumnValue("cc", cc);
        Update.updateColumnValue("rok", rok);
        Update.where().eq("id_sam", samochod.getId_sam());
        Update.update();

    }

    public static void zakresS(ListView<Klient> listaK, ListView<Samochod> listaS) throws SQLException {
        QueryBuilder<Samochod, Integer> zakres = samochodDao.queryBuilder();
        zakres.where().eq("id_klient_id", listaK.getSelectionModel().getSelectedItem().getId_klient());
        PreparedQuery<Samochod> prepare = zakres.prepare();
        List<Samochod> lista = Samochod.samochodDao.query(prepare);
        listaS.getItems().clear();
        listaS.getItems().addAll(lista);
    }

    @Override
    public String toString() {
        return  marka +" "+ model + "   rok: " + rok + "r, cc: " + cc + ", moc: " + moc +"KM;";
    }

    public static void ListRefreshSamochod(ListView<Samochod> lista) {
        try {
            lista.getItems().clear();
            lista.getItems().addAll(samochodDao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
