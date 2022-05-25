package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia;

import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;

import java.util.List;

public interface IValetDAO {
    public boolean insertValet(ValetParking valet);

}
