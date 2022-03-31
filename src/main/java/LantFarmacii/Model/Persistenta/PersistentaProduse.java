package LantFarmacii.Model.Persistenta;

import LantFarmacii.Model.*;
import com.google.gson.*;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.lang.reflect.Type;
import java.time.LocalDate;

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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "produse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersistentaProduse {
    @XmlElement(name = "produs")
    private List<ProdusCuProducator> produse = null;


    public List<ProdusCuProducator> getProduse() {
        return produse;
    }

    public void setProduse(List<ProdusCuProducator> produse) {
        this.produse = produse;
    }

    static PersistentaProduse listaProduse = new PersistentaProduse();
    static  {
        listaProduse.setProduse(new ArrayList<ProdusCuProducator>());
    }

    public static void marshal() throws JAXBException {

        JAXBContext context2 = JAXBContext.newInstance(LantFarmacii.Model.Persistenta.PersistentaProduse.class);
        Marshaller mar2 = context2.createMarshaller();
        mar2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar2.marshal(listaProduse, new File("./products.xml"));
    }

    public static PersistentaProduse unmarshal() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersistentaProduse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        PersistentaProduse prd =  (PersistentaProduse) jaxbUnmarshaller.unmarshal( new File("./products.xml") );

        return prd;
    }

    public static void adaugareProdus(ProdusCuProducator produs) throws JAXBException {
        listaProduse = unmarshal();
        listaProduse.getProduse().add(produs);
        marshal();
    }

    public static void stergereProdus(ProdusCuProducator produs) throws  JAXBException {
        listaProduse = unmarshal();
        listaProduse.getProduse().removeIf(p -> p.equals(produs));
        marshal();
    }

    public static void updateProdus(ProdusCuProducator p1, ProdusCuProducator p2) throws  JAXBException {
        listaProduse = unmarshal();
        for(ProdusCuProducator p : listaProduse.getProduse()){
            if(p.equals(p1)){
                p.setProducator(p2.getProducator());
                p.setNume(p2.getNume());
                p.setCantitate(p2.getCantitate());
                p.setPret(p2.getPret());
                p.setDisponibilitate(p2.isDisponibilitate());
                p.setId(p2.getId());
                p.setValabilitate(p2.getValabilitate());
            }
        }
        marshal();
    }
    public static void raportJson(PersistentaProduse produse) throws IOException {
        Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("./raport.json")) {
            g.toJson(produse.getProduse(), writer);
        }
    }

    public  static  void raportCSV(PersistentaProduse produse) throws IOException {
        ArrayList<String[]> array = new ArrayList<>();
        String[] header = {"Nume", "Disponibilitate", "Id", "Producator", "Pret", "Cantitate", "Valabilitate"};
        for(ProdusCuProducator p: produse.getProduse()) {
            array.add(new String[] {p.getNume(), String.valueOf(p.isDisponibilitate()), String.valueOf(p.getId()), p.getProducator(), String.valueOf(p.getPret()), String.valueOf(p.getCantitate()), String.valueOf(p.getValabilitate())});
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter("./raport.csv"))) {
            writer.writeAll(array);
        }
    }
}

///Clasa care permite generarea reportului Json si pentru atribute de tip LocalDate
class LocalDateAdapter implements JsonSerializer<LocalDate> {

    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
    }
}

