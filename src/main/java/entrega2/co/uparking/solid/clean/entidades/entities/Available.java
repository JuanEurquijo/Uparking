package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IState;

public class Available implements IState {

    @Override
    public void changeState(ValetParking valet) {
        valet.setState("Disponible");
    }
}
