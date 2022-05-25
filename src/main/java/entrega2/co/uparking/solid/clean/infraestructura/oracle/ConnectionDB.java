package entrega2.co.uparking.solid.clean.infraestructura.oracle;

import entrega2.co.uparking.solid.clean.encriptacion.ConfigFileEncryption;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

//Se aplica el patrón de diseño singleton
public class ConnectionDB {

    private static ConnectionDB dataSource; //protege del acceso externo
    private BasicDataSource basicDataSource;
    ConfigFileEncryption encrip =  new ConfigFileEncryption();

    //Constructor privado con protección al acceso externo
    private ConnectionDB(){

        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        basicDataSource.setUsername(encrip.getUser());
        basicDataSource.setPassword(encrip.getPassword());
        basicDataSource.setUrl(encrip.getThinconn());

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
    }

    // Método público, llamado por el código
    public static ConnectionDB getInstance() {
        if (dataSource == null) { // sólo si no existe ninguna instancia, entonces crea una nueva
            dataSource = new ConnectionDB();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.basicDataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }


}
