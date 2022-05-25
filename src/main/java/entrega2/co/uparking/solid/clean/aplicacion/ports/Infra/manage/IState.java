package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage;

import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;
import entrega2.co.uparking.solid.clean.entidades.enums.ValetEnum;

public interface IState {

    public void changeState(ValetParking valet);
}
