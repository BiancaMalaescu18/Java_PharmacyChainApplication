package LantFarmacii.View;

import javax.swing.*;
import java.time.LocalDate;

public interface iViewAngajat {

    public Double getPrice();

    public Integer getQuantity();

    public LocalDate getValability();

    public String getName();

    public Boolean getDisponibility();

    public Integer getId();

    public String getManufacturer();

    public String[] getProdusSters();

    public Boolean getFilterDisponibility();

    public LocalDate getFilterValability();

    public Double getFilterPrice();

    public String getFilterManufacturer();

}
