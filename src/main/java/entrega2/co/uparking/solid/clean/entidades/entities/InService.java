package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IState;

public class InService implements IState {

    @Override
    public void changeState(ValetParking newValet) {
        newValet.setState("En Servicio");
    }
}
