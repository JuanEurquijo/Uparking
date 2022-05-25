package entrega2.co.uparking.solid.clean.infraestructura.oracle;

import entrega1.model.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentasDAO {

    public boolean insertAccount(Cuenta cuenta) {

        boolean state = false;

        String SQL = "INSERT INTO usuarios (usuario, tipo_documento, numero_documento, email, pass) VALUES (?, ?, ?, ? ,?)";
        try (
                Connection conex = DriverManager.getConnection(
                        ConnectionDB.getInstance().encrip.getThinconn(),
                        ConnectionDB.getInstance().encrip.getUser(),
                        ConnectionDB.getInstance().encrip.getPassword());
                PreparedStatement pst = conex.prepareStatement(SQL);) {

            pst.setString(1, cuenta.getUser());
            pst.setString(2, cuenta.getTipoDoc());
            pst.setLong(3, cuenta.getDocument());
            pst.setString(4, cuenta.getEmail());
            pst.setString(5, cuenta.getPassword());
            state = pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
        return state;
    }

    public List<Cuenta> checkAccount() {
        List<Cuenta> cuentas = new ArrayList<>();
        String SQL = "select ID, usuario, tipo_documento, numero_documento, email, pass from usuarios";
        try {
                Connection conex = DriverManager.getConnection(
                        ConnectionDB.getInstance().encrip.getThinconn(),
                        ConnectionDB.getInstance().encrip.getUser(),
                        ConnectionDB.getInstance().encrip.getPassword());
                PreparedStatement ps = conex.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cuenta cuenta  = new Cuenta();
                cuenta.setID(rs.getInt("ID"));
                cuenta.setUser(rs.getString("usuario"));
                cuenta.setTipoDoc(rs.getString("tipo_documento"));
                cuenta.setDocument(rs.getLong("numero_documento"));
                cuenta.setEmail(rs.getString("email"));
                cuenta.setPassword(rs.getString("pass"));

                cuentas.add(cuenta);
            }

        } catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
        return cuentas;
    }

}
