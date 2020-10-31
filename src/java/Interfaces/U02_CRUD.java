package Interfaces;

import Modelo.U02_Persona;
import java.util.List;

public interface U02_CRUD {
   public List listar();
   public U02_Persona list(int rutas_id);
   public boolean add(U02_Persona per);
   public boolean edit(U02_Persona per);
   public boolean eliminar(int rutas_id);
}
