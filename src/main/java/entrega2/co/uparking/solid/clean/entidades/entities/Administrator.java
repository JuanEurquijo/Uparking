package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IValetDAO;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.ValetDAO;

import java.util.ArrayList;
import java.util.List;

public class Administrator implements IValetDAO {

    private int id;
    private String nameUser;
    private String password;

    @Override
    public boolean insertValet(ValetParking valet) {

        IValetDAO valetDAO = new ValetDAO();

        if(valetDAO.insertValet(valet))
        {
            return true;
        }
        return false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
