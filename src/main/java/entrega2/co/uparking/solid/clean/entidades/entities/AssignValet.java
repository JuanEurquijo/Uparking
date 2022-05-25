package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.ValetDAO;
import javafx.scene.control.Alert;

import java.util.*;

public class AssignValet {

    private Map<Cuenta, ValetParking> assigned = new HashMap<Cuenta, ValetParking>();

    private List<ValetParking> valets = new ArrayList<>();

    public AssignValet() {
    }

    public void associateValet(Cuenta user){

        ValetDAO valet = new ValetDAO();
        valets = valet.checkAccount();
        InService service = new InService();
        assigned.put(user,valets.get(0));
        service.changeState(valets.get(0));
        valets.remove(0);

       /* assigned.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " = " + entry.getValue());
        });*/
    }

    public Map<Cuenta, ValetParking> getAssigned() {
        return assigned;
    }

    public void setAssigned(Map<Cuenta, ValetParking> assigned) {
        this.assigned = assigned;
    }

    public List<ValetParking> getValets() {
        return valets;
    }

    public void setValets(List<ValetParking> valets) {
        this.valets = valets;
    }
}
