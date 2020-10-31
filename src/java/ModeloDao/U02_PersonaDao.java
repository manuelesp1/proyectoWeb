package ModeloDao;

import Config.U02_Conexion;
import Modelo.U02_Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.U02_CRUD;

public class U02_PersonaDao implements U02_CRUD{
U02_Conexion cn=new U02_Conexion();
Connection con;   
PreparedStatement ps;
ResultSet rs;
U02_Persona p=new U02_Persona();

    @Override
    public List listar() {
    ArrayList<U02_Persona> list=new ArrayList<>();
    String sql="Select * from rutas";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                U02_Persona p=new U02_Persona();
                p.setRuta(rs.getInt("ruta_id"));
                p.setEmbarque(rs.getInt("embarque_id"));
                p.setLlegada(rs.getInt("llegada_id"));
                p.setCosto(rs.getDouble("costo_ruta"));
                p.setDuracion(rs.getInt("duracion"));
                p.setDescripcion(rs.getString("descripcion"));
                list.add(p);
                
            }
        } catch (Exception e) {
        }
    return list;
    
    }

    @Override
    public U02_Persona list(int ruta_id) {
    String sql="select * from rutas where ruta_id="+ruta_id;    
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                p.setRuta(rs.getInt("ruta_id"));
                p.setEmbarque(rs.getInt("embarque_id"));
                p.setLlegada(rs.getInt("llegada_id"));
                p.setCosto(rs.getDouble("costo_ruta"));
                p.setDuracion(rs.getInt("duracion"));
                p.setDescripcion(rs.getString("descripcion"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(U02_Persona per) {
        try {
            con=cn.getConnection();
            ps=con.prepareStatement("insert into rutas(ruta_id,embarque_id,llegada_id,costo_ruta,duracion,descripcion) values(?,?,?,?,?,?)");
            ps.setInt(1, per.getRuta());
            ps.setInt(2, per.getEmbarque());
            ps.setInt(3, per.getLlegada());
            ps.setDouble(4, per.getCosto());
            ps.setInt(5, per.getDuracion());
            ps.setString(6, per.getDescripcion());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return true;
    }

    @Override
    public boolean edit(U02_Persona per) {
        String sql="update encomiendas set embarque_id='"+per.getEmbarque()+"',llegada_id='"+per.getLlegada()+"',costo_ruta='"+per.getCosto()+"',duracion='"+per.getDuracion()+"',descripcion='"+per.getDescripcion()+"'where ruta_id="+per.getRuta();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int ruta_id) {
        String sql="delete from rutas where ruta_id="+ruta_id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return true;
    }
    
}
