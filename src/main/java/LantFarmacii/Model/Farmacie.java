package LantFarmacii.Model;

import java.util.ArrayList;
import java.util.List;

public class Farmacie {
    private int id;
    private String denumire;
    private String localitate;
    private String strada;
    private List<Integer> produse; //tin id-urile produselor

    public int getId() { return id;}

    public List<Integer> getProduse() {
        return produse;
    }
}
