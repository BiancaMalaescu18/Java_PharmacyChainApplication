package LantFarmacii.Model;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "produs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProdusCuProducator extends Produs{


    private String producator;
    private Integer id;
    private Double pret;
    private Integer cantitate;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate valabilitate;

    public ProdusCuProducator(){

    }

    public ProdusCuProducator(Integer id, String producator, Double pret, Integer cantitate, LocalDate valabilitate) {
        this.id = id;
        this.producator = producator;
        this.pret = pret;
        this.cantitate = cantitate;
        this.valabilitate = valabilitate;
    }

    public ProdusCuProducator(String nume, boolean disponibilitate, Integer id, String producator, Double pret, Integer cantitate, LocalDate valabilitate) {
        super(nume, disponibilitate);
        this.id = id;
        this.producator = producator;
        this.pret = pret;
        this.cantitate = cantitate;
        this.valabilitate = valabilitate;
    }



    public LocalDate getValabilitate() {
        return valabilitate;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getPret() {
        return pret;
    }

    public String getProducator() {
        return producator;
    }

    public Integer getId() {
        return id;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    public void setValabilitate(LocalDate valabilitate) {
        this.valabilitate = valabilitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdusCuProducator that = (ProdusCuProducator) o;
        return Objects.equals(producator, that.producator) && Objects.equals(id, that.id) && Objects.equals(pret, that.pret) && Objects.equals(cantitate, that.cantitate) && Objects.equals(valabilitate, that.valabilitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producator, id, pret, cantitate, valabilitate);
    }
}
///Clasa folosita pentru a putea face marshal si pe atribute de tip LocalDate
class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}

