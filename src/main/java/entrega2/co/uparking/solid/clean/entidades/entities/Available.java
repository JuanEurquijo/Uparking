package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IState;
import entrega2.co.uparking.solid.clean.entidades.enums.ValetEnum;

public class Available implements IState {

    @Override
    public void changeState(ValetParking valet) {
        valet.setState(String.valueOf(ValetEnum.DISPONIBLE));
    }
}
