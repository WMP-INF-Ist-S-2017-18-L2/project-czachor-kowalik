package Utils;

public class Status {

    int status;
    String opis1 = "W trakcie";
    String opis2 = "Do odbioru";
    String opis3 = "Odebrane";



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status>0 && status<4)
        this.status = status;
        else
            System.out.println("Musisz podać liczbe od 1 do 3, gdzie:\n1. "+opis1+"\n2."+opis2+"\n3."+opis3);
    }
}
