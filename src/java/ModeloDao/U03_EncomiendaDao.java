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
import modelo.U03_Encomienda;
import interfaces.U03_CRUDencomiendas;

/**
 *
 * @author V330
 */
public class U03_EncomiendaDao implements U03_CRUDencomiendas {

    Conexion con = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    U03_Encomienda en = new U03_Encomienda();

    @Override
    public List listar() {
        ArrayList<U03_Encomienda> list = new ArrayList<>();
        String sql = "select * from encomiendas";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                U03_Encomienda en = new U03_Encomienda();
                en.setId(rs.getInt("id"));
                en.setEnvia_nom(rs.getString("envia_nombre"));
                en.setEnvia_ape(rs.getString("envia_apellido"));
                en.setEnvia_dni(rs.getInt("envia_dni"));
                en.setRecoge_nom(rs.getString("recoge_nombre"));
                en.setRecoge_ape(rs.getString("recoge_apellido"));
                en.setRecoge_dni(rs.getInt("recoge_dni"));
                en.setLugar_recojo(rs.getInt("lugar_recojo"));
                list.add(en);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public U03_Encomienda list(int id) {
        String sql="select *  from encomiendas where id="+id;
        try {
            cn=con.getConnection();
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                en.setId(rs.getInt("id"));
                en.setEnvia_nom(rs.getString("envia_nombre"));
                en.setEnvia_ape(rs.getString("envia_apellido"));
                en.setEnvia_dni(rs.getInt("envia_dni"));
                en.setRecoge_nom(rs.getString("recoge_nombre"));
                en.setRecoge_ape(rs.getString("recoge_apellido"));
                en.setRecoge_dni(rs.getInt("recoge_dni"));
                en.setLugar_recojo(rs.getInt("lugar_recojo"));
                
            }
        } catch (Exception e) {
        }
        return  en;
    }

    @Override
    public boolean add(U03_Encomienda u) {
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement("insert into encomiendas(envia_nombre,envia_apellido,envia_dni,recoge_nombre,recoge_apellido,recoge_dni,lugar_recojo) values(?,?,?,?,?,?,?)");
            ps.setString(1, u.getEnvia_nom());
            ps.setString(2,u.getEnvia_ape());
            ps.setInt(3, u.getEnvia_dni());
            ps.setString(4, u.getRecoge_nom());
            ps.setString(5,u.getRecoge_ape());
            ps.setInt(6, u.getRecoge_dni());
            ps.setInt(7, u.getLugar_recojo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return true;

    }

    @Override
    public boolean edit(U03_Encomienda en) {
        String sql="update encomiendas set envia_nombre='"+en.getEnvia_nom()+"',envia_apellido='"+en.getEnvia_ape()+"',envia_dni='"+en.getEnvia_dni()+"',recoge_nombre='"+en.getRecoge_nom()+"',recoge_apellido='"+en.getEnvia_ape()+"',recoge_dni='"+en.getRecoge_dni()+"'where id="+en.getId();
        try {
            cn=con.getConnection();
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from encomiendas where id="+id;
        try {
            cn=con.getConnection();
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return true;
    }

}
