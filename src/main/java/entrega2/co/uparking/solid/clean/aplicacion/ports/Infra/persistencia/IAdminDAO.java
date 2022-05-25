package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia;

import entrega2.co.uparking.solid.clean.entidades.entities.Administrator;

import java.util.List;

public interface IAdminDAO {

    public List<Administrator> checkAccounts();
}
