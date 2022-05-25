package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia;

import entrega1.model.Cuenta;

import java.util.List;

public interface ICuentasDAO {

    public boolean insertAccount(Cuenta cuenta);
    public List<Cuenta> checkAccount();
}
