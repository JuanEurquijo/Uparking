/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entrega1.model;

/**
 *
 * @author User
 */
public class Cuenta {
    

    private String user;
    private String tipoDoc;
    private long document;
    private String email;
    private String password;

    public Cuenta() {
    }

    public Cuenta(String user, String tipoDoc, long document, String email, String password) {
        this.user = user;
        this.tipoDoc = tipoDoc;
        this.document = document;
        this.email = email;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return user + "," + tipoDoc + "," + document + "," + email + "," + password;
    }

    
   
    
    

}
