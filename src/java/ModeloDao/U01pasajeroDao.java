/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.U01pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Manuel
 */
public class U01pasajeroDao implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean guardar(U01pasajero pasajero) {
        try {
            con = cn.getConnection();
            ps = con.prepareStatement("insert into personas (nombres, apellido_paterno, apellido_materno,sexo, telefono, edad, documento_id, cod_documento, cuenta_id) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApepat());
            ps.setString(3, pasajero.getApemat());
            ps.setString(4, pasajero.getSexo());
            ps.setString(5, pasajero.getTelef());
            ps.setInt(6, Integer.parseInt(pasajero.getEdad()));
            ps.setInt(7, Integer.parseInt(pasajero.getTipo_doc()));
            ps.setString(8, pasajero.getNumdoc());
            ps.setInt(9, Integer.parseInt(pasajero.getUsuario_id()));
           
            System.out.println("-------dao----------");
            System.out.println("tipodoc: "+pasajero.getTipo_doc());
            System.out.println("numdoc: "+pasajero.getNumdoc());
            System.out.println("nombre: "+pasajero.getNombre());
            System.out.println("apepat: "+pasajero.getApepat());
            System.out.println("apemat: "+pasajero.getApemat());
            System.out.println("edad: "+pasajero.getEdad());
            System.out.println("sexo: "+pasajero.getSexo());
            System.out.println("telef: "+pasajero.getTelef());
            //System.out.println("itinerario: "+itinerario_id);
            //System.out.println("nom_asiento: "+nom_asiento);
            System.out.println("usuarioid: "+pasajero.getUsuario_id());
            
            ps.executeUpdate();
            
            ps=con.prepareStatement("insert into comprobantes (persona_id, cuenta_id, itinerario_id,asiento_id, monto) values (?,?,?,?,?)");
            ps.setString(1, pasajero.getUsuario_id());
            
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return false;
    }
}
