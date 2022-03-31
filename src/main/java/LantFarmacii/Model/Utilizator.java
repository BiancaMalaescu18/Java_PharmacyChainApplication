package LantFarmacii.Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "rol", "username", "parola", "nume", "id_farmacie"})

public class Utilizator {
    private String rol; //daca e administrator sau angajat al unei farmacii
    private String username;
    private String parola;
    private String nume;
    private int  id_farmacie;

    public Utilizator(){

    }

    public Utilizator(String rol, String username, String parola, String nume, int id_farmacie) {
        this.rol = rol;
        this.username = username;
        this.parola = parola;
        this.nume = nume;
        this.id_farmacie = id_farmacie;
    }

    //@XmlElement(name = "id_farmacie")
    public void setId_farmacie(int id_farmacie) {this.id_farmacie = id_farmacie;}

   // @XmlElement(name = "rol")
    public void setRol(String rol) {
        this.rol = rol;
    }

    //@XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    //@XmlElement(name = "parola")
    public void setParola(String parola) {
        this.parola = parola;
    }

    //@XmlElement(name = "nume")
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRol() {
        return rol;
    }

    public String getUsername() {
        return username;
    }

    public String getParola() {
        return parola;
    }

    public String getNume() {
        return nume;
    }

    public int getId_farmacie() {return id_farmacie; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizator that = (Utilizator) o;
        return id_farmacie == that.id_farmacie && Objects.equals(rol, that.rol) && Objects.equals(username, that.username) && Objects.equals(parola, that.parola) && Objects.equals(nume, that.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol, username, parola, nume, id_farmacie);
    }
}
