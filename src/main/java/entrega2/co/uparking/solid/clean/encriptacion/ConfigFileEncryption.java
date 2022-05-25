package entrega2.co.uparking.solid.clean.encriptacion;

import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

import static entrega2.co.uparking.solid.clean.encriptacion.Encryption.*;


public class ConfigFileEncryption {

    private String user;
    private String password;
    private String thinconn;
    private SecretKeySpec key;

    public ConfigFileEncryption() {

        try {
            FileInputStream inputStream = new FileInputStream("src\\conf\\config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            user = properties.getProperty("USERNAME");
            password = properties.getProperty("PASSWORD");
            thinconn = properties.getProperty("THINCONN");

            if (user == null || password == null || thinconn == null) {
                throw new IllegalArgumentException("No such parameter present in config file");
            }

            byte[] salt = new String("12345678").getBytes();
            int iterationCount = 40000;
            int keyLength = 128;
            key = createSecretKey(password.toCharArray(), salt, iterationCount, keyLength);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getThinconn() {
        return thinconn;
    }

    public void setThinconn(String thinconn) {
        this.thinconn = thinconn;
    }

    public SecretKeySpec getKey() {
        return key;
    }

    public void setKey(SecretKeySpec key) {
        this.key = key;
    }
}
