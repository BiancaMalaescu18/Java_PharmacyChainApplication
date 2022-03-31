package LantFarmacii.Model;


public class Produs {

    private String nume;
    private boolean disponibilitate;


    public Produs() {
    }

    public Produs(String nume, boolean disponibilitate) {
        this.nume = nume;
        this.disponibilitate = disponibilitate;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public boolean isDisponibilitate() {
        return disponibilitate;
    }




}
