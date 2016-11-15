/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.beans.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import tk.keitedev.server.beans.interfaces.InterfaceBean;

/**
 *
 * @author Dani
 */
public class UsuarioBean implements InterfaceBean{
    @Expose
    private int id;
    @Expose
    private String nombre,apellido1,apellido2,dni,login;
    @Expose
    private String password;
    @Expose(serialize = false)
    private int id_tipo_usuario;
    @Expose(deserialize = false)
    private TipoUsuarioBean ob_tipo_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public TipoUsuarioBean getOb_tipo_usuario() {
        return ob_tipo_usuario;
    }

    public void setOb_tipo_usuario(TipoUsuarioBean ob_tipo_usuario) {
        this.ob_tipo_usuario = ob_tipo_usuario;
    }

    
    
    @Override
    public void fill(ResultSet rs,Connection conn,int expand) throws SQLException {
        this.id = rs.getInt("id");
        this.nombre = rs.getString("nombre");
        this.apellido1 = rs.getString("apellido1");
        this.apellido2 = rs.getString("apellido2");
        this.dni = rs.getString("dni");
        this.login = rs.getString("login");
        this.password = rs.getString("password");
        if(expand <= 0){
            this.id_tipo_usuario = rs.getInt("id_tipo_usuario");
        }else{
            this.id_tipo_usuario = rs.getInt("id_tipo_usuario");
        }
    }

    @Override
    public String getPairs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
