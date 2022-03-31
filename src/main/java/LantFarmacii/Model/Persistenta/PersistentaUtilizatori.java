package LantFarmacii.Model.Persistenta;

import LantFarmacii.Model.ProdusCuProducator;
import LantFarmacii.Model.Utilizator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "utilizatori")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersistentaUtilizatori {

    @XmlElement(name = "utilizator")
    private List<Utilizator> utilizatori ;

    public List<Utilizator> getUtilizatori() {
        return utilizatori;
    }

    public void setUtilizatori(List<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
    }

    static PersistentaUtilizatori lista_utilizatori = new PersistentaUtilizatori();
    static{
        lista_utilizatori.setUtilizatori(new ArrayList<Utilizator>());

    }

    public static void marshal() throws JAXBException, IOException{

        JAXBContext context = JAXBContext.newInstance(LantFarmacii.Model.Persistenta.PersistentaUtilizatori.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(lista_utilizatori, new File("./users.xml"));
    }

    public static PersistentaUtilizatori unmarshal() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersistentaUtilizatori.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        PersistentaUtilizatori util = (PersistentaUtilizatori) jaxbUnmarshaller.unmarshal(new File("./users.xml"));

        return util;
    }

    public static void adaugareUtilizator(Utilizator utilizator) throws JAXBException, IOException {
        lista_utilizatori = unmarshal();
        lista_utilizatori.getUtilizatori().add(utilizator);
        marshal();
    }

    public static void stergereUtilizator(Utilizator util) throws JAXBException, IOException {
        lista_utilizatori = unmarshal();
        for(Utilizator u  : lista_utilizatori.getUtilizatori()) {
            if(u.equals(util)) {
                lista_utilizatori.getUtilizatori().remove(u);
                break;
            }
        }
        marshal();
    }

    public static void updateUtilizator(Utilizator u1, Utilizator u2) throws JAXBException, IOException {
        lista_utilizatori = unmarshal();
        for(Utilizator u  : lista_utilizatori.getUtilizatori()) {
            if(u.equals(u1)) {
                u.setRol(u2.getRol());
                u.setUsername(u2.getUsername());
                u.setParola(u2.getParola());
                u.setNume(u2.getNume());
                u.setId_farmacie(u2.getId_farmacie());

            }
        }
        marshal();
    }
}
