package entrega2.co.uparking.solid.clean.infraestructura.oracle;
import entrega2.co.uparking.solid.clean.entidades.entities.Administrator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public List<Administrator> checkAccounts() {
        List<Administrator> admins = new ArrayList<>();
        String SQL = "select ID, nameUser, pass from administrador";
        try {
            Connection conex = DriverManager.getConnection(
                    ConnectionDB.getInstance().encrip.getThinconn(),
                    ConnectionDB.getInstance().encrip.getUser(),
                    ConnectionDB.getInstance().encrip.getPassword());
            PreparedStatement ps = conex.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Administrator admin  = new Administrator();
                admin.setId(rs.getInt("ID"));
                admin.setNameUser(rs.getString("nameUser"));
                admin.setPassword(rs.getString("pass"));
                admins.add(admin);
            }

        } catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
        return admins;
    }
}
