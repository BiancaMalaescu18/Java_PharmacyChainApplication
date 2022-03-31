package LantFarmacii.Presenter;

import LantFarmacii.Model.Persistenta.PersistentaProduse;
import LantFarmacii.Model.Persistenta.PersistentaUtilizatori;
import LantFarmacii.Model.ProdusCuProducator;
import LantFarmacii.Model.Utilizator;
import LantFarmacii.View.*;

import javax.xml.bind.JAXBException;

public class PrezentareLogin {

    private iViewLogin viz= new ViewLogin();

    public PrezentareLogin(){

    }


    public static boolean  autentificare(String username, String password) throws JAXBException {
        boolean gasit = false;
        for(Utilizator u: PersistentaUtilizatori.unmarshal().getUtilizatori()){
            if(u.getUsername().equals(username) && u.getParola().equals(password)){
                gasit = true;
                if(u.getRol().equals("administrator"))
                {
                    iViewAdministrator v = new ViewAdministrator();

                }
                else{
                    iViewAngajat v = new ViewAngajat();

                }

            }

        }
        return gasit;

    }


}
