package entrega2.co.uparking.solid.clean.infraestructura.oracle;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IValetDAO;
import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValetDAO implements IValetDAO {

    @Override
    public boolean insertValet(ValetParking valet) {

        boolean state =  false;
        String SQL = "INSERT INTO VALETS (name, typedoc, numdoc, age, experience) VALUES (?, ?, ?, ? ,?)";
        try (
                Connection conex = DriverManager.getConnection(
                        ConnectionDB.getInstance().encrip.getThinconn(),
                        ConnectionDB.getInstance().encrip.getUser(),
                        ConnectionDB.getInstance().encrip.getPassword());
                PreparedStatement pst = conex.prepareStatement(SQL);) {

            pst.setString(1, valet.getName());
            pst.setString(2, valet.getTypeDoc());
            pst.setLong(3, valet.getNumDoc());
            pst.setInt(4, valet.getAge());
            pst.setString(5, valet.getExperience());
            state = pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
        return state;
    }


    public List<ValetParking> checkAccount() {
        List<ValetParking> valets = new ArrayList<>();
        String SQL = "select ID, name, typeDoc, numDoc, age, experience from valets";
        try {
            Connection conex = DriverManager.getConnection(
                    ConnectionDB.getInstance().encrip.getThinconn(),
                    ConnectionDB.getInstance().encrip.getUser(),
                    ConnectionDB.getInstance().encrip.getPassword());
            PreparedStatement ps = conex.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ValetParking valet  = new ValetParking();
                valet.setId(rs.getInt("ID"));
                valet.setName(rs.getString("name"));
                valet.setTypeDoc(rs.getString("typeDoc"));
                valet.setNumDoc(rs.getLong("numDoc"));
                valet.setAge(rs.getInt("age"));
                valet.setExperience(rs.getString("experience"));

                valets.add(valet);
            }

        } catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
        return valets;
    }
}
