/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.U03_Usuario;
import interfaces.U03_CRUD;

/**
 *
 * @author V330
 */
public class U03_UsuarioDAO implements U03_CRUD {

    Conexion con = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    U03_Usuario us = new U03_Usuario();
    String usr="cmateo0";

    @Override
    public List listar() {
        ArrayList<U03_Usuario> list = new ArrayList<>();
        String sql = "select * from cuentas";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                U03_Usuario us = new U03_Usuario();                              
                us.setId(rs.getInt("cuenta_id"));
                us.setUsuario(rs.getString("usuario"));
                us.setEmail(rs.getString("email"));
                list.add(us);

            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public U03_Usuario list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(U03_Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(U03_Usuario per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
