
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUDasientos;
import Modelo.U01asientos;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class U01asientosDAO implements CRUDasientos{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List consultarDisponibilidad(int itinerario_id) {
        ArrayList<U01asientos> list = new ArrayList<>();
        String sql = "select itinerario_id, nom_asiento, t3.disponible from itinerarios"
                + " t1 inner join buses t2 on t1.bus_id = t2.bus_id inner join asientos "
                + "t3 on t2.bus_id = t3.bus_id where itinerario_id = ?";
        //where itinerario_id = ? and asiento_id = ?
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, itinerario_id);
            rs = ps.executeQuery();
            while(rs.next()){
                U01asientos asientos = new U01asientos();
                asientos.setDisponibilidad(rs.getInt("disponible"));
                asientos.setId_asiento(rs.getInt("nom_asiento"));
                list.add(asientos);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
