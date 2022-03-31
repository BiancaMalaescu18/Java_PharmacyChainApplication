package LantFarmacii.Presenter;

import LantFarmacii.Model.Persistenta.PersistentaUtilizatori;
import LantFarmacii.Model.Utilizator;
import LantFarmacii.View.iViewAdministrator;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class PrezentareAdministrator {

    private iViewAdministrator viz;
    private static PersistentaUtilizatori utilizatori = new PersistentaUtilizatori();

    public PrezentareAdministrator (iViewAdministrator x) {
        viz = x;
    }

    public static PersistentaUtilizatori vizualizare()  {
        try {
            utilizatori = PersistentaUtilizatori.unmarshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return utilizatori;
    }

    public void adaugare() throws JAXBException, IOException {
        Utilizator ut = new Utilizator(viz.getRole(), viz.getUsername(), viz.getPassword(), viz.getName(), viz.getId_ph());
        PersistentaUtilizatori.adaugareUtilizator(ut);
    }

    public void stergere() throws JAXBException, IOException {
        String[] s = viz.getUtilizatorSters();
        Utilizator u = new Utilizator(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]));
        PersistentaUtilizatori.stergereUtilizator(u);
    }

    public void update() throws JAXBException, IOException {
        String[] s = viz.getUtilizatorSters();
        Utilizator u = new Utilizator(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]));
        Utilizator u2 = new Utilizator(viz.getRole(), viz.getUsername(), viz.getPassword(), viz.getName(), viz.getId_ph());
        PersistentaUtilizatori.updateUtilizator(u, u2);
    }

    public Object[][] tableData2(PersistentaUtilizatori util) {
        int sz = util.getUtilizatori().size();
        Object[][] data = new Object[sz][];

        for (int i = 0; i < sz; i++) {
            data[i] = new Object[]{util.getUtilizatori().get(i).getRol(), util.getUtilizatori().get(i).getUsername(), util.getUtilizatori().get(i).getParola(), util.getUtilizatori().get(i).getNume(), util.getUtilizatori().get(i).getId_farmacie()};
        }

        return data;
    }
}
