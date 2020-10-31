package Interfaces;

import Modelo.Admi;
import java.util.List;

public interface U05_CRUD_Admi {
   public List listar();
   public Admi list(int cuenta_id);
   public boolean add(Admi per);
   public boolean add2(Admi per);
   public boolean edit(Admi per);
   public boolean edit2(Admi per);
   public boolean eliminar(int cuenta_id);
}
