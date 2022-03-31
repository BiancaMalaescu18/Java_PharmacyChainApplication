package LantFarmacii.Presenter;

import LantFarmacii.Model.Persistenta.PersistentaProduse;
import LantFarmacii.Model.Persistenta.PersistentaUtilizatori;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import LantFarmacii.Model.ProdusCuProducator;
import LantFarmacii.Model.Utilizator;
import LantFarmacii.Presenter.PrezentareAdministrator;
import LantFarmacii.View.ViewAdministrator;
import LantFarmacii.View.ViewLogin;
import LantFarmacii.View.iViewAngajat;
import LantFarmacii.View.ViewAngajat;

public class PrezentareAnjagat {

    private iViewAngajat viz;
    private static PersistentaProduse produse = new PersistentaProduse();

    public PrezentareAnjagat (iViewAngajat x) {
        viz = x;
    }

    public static PersistentaProduse vizualizare()  {
        try {
            produse = PersistentaProduse.unmarshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return produse;
    }

    public Object[][] tableData(PersistentaProduse produse) {
        int sz = produse.getProduse().size();
        Object[][] data = new Object[sz][];

        for (int i = 0; i < sz; i++) {
            data[i] = new Object[]{produse.getProduse().get(i).getNume(), produse.getProduse().get(i).isDisponibilitate(), produse.getProduse().get(i).getId(), produse.getProduse().get(i).getProducator(), produse.getProduse().get(i).getPret(), produse.getProduse().get(i).getCantitate(), produse.getProduse().get(i).getValabilitate()};
        }

        return data;
    }

    public void adaugare() throws JAXBException {
        ProdusCuProducator produs = new ProdusCuProducator(viz.getName(), viz.getDisponibility(), viz.getId(), viz.getManufacturer(), viz.getPrice(), viz.getQuantity(), viz.getValability());
        PersistentaProduse.adaugareProdus(produs);
    }

    public void stergere() throws  JAXBException {
        String[] s = viz.getProdusSters();
        ProdusCuProducator p = new ProdusCuProducator(s[0], Boolean.parseBoolean(s[1]), Integer.parseInt(s[2]), s[3], Double.parseDouble(s[4]), Integer.parseInt(s[5]), LocalDate.parse(s[6]));
        PersistentaProduse.stergereProdus(p);
    }

    public void update() throws  JAXBException {
        String[] s = viz.getProdusSters();
        ProdusCuProducator p = new ProdusCuProducator(s[0], Boolean.parseBoolean(s[1]), Integer.parseInt(s[2]), s[3], Double.parseDouble(s[4]), Integer.parseInt(s[5]), LocalDate.parse(s[6]));
        ProdusCuProducator p2 = new ProdusCuProducator(viz.getName(), viz.getDisponibility(), viz.getId(), viz.getManufacturer(), viz.getPrice(), viz.getQuantity(), viz.getValability());
        PersistentaProduse.updateProdus(p, p2);
    }

    public static PersistentaProduse cautare(String text)  {

        try {
            produse = PersistentaProduse.unmarshal();
            produse.getProduse().removeIf(prod -> !prod.getNume().equals(text));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return produse;
    }

    public static PersistentaProduse filtrareDisponibilitate(boolean disp)  {

        try {
            produse = PersistentaProduse.unmarshal();
            produse.getProduse().removeIf(p -> p.isDisponibilitate() != disp);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return produse;
    }

    public static PersistentaProduse filtrareValabilitate(LocalDate valab)  {

        System.out.println();
        try {
            produse = PersistentaProduse.unmarshal();
            produse.getProduse().removeIf(p -> p.getValabilitate().compareTo(valab) != 0);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return produse;
    }

    public static PersistentaProduse filtrareProducator(String text)  {

        try {
            produse = PersistentaProduse.unmarshal();
            produse.getProduse().removeIf(prod -> !prod.getProducator().equals(text));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return produse;
    }

    public static PersistentaProduse filtrarePret(Double pret)  {

        System.out.println();
        try {
            produse = PersistentaProduse.unmarshal();
            produse.getProduse().removeIf(p -> p.getPret() !=  pret);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return produse;
    }

    public static void genRaportJson() throws JAXBException, IOException {
        produse = PersistentaProduse.unmarshal();
        PersistentaProduse.raportJson(produse);
    }

    public static void genRaportCSV() throws JAXBException, IOException {
        produse = PersistentaProduse.unmarshal();
        PersistentaProduse.raportCSV(produse);
    }



}
