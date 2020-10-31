
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUDrutas;
import Modelo.U01rutas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class U01rutasDao implements CRUDrutas{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List consultar_ruta(){
        ArrayList<U01rutas> list = new ArrayList<>();
        String sql = "select itinerario_id, fecha_salida, duracion, costo_ruta from itinerarios t1 inner join rutas t2 on t1.ruta_id = t2.ruta_id";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                U01rutas rutas = new U01rutas();
                rutas.setItinerarios_id(rs.getInt("itinerario_id"));
                rutas.setDuracion(rs.getInt("duracion"));
                rutas.setFecha(rs.getString("fecha_salida"));
                rutas.setPrecio(rs.getDouble("costo_ruta"));
                list.add(rutas);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
