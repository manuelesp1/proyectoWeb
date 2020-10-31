/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author V330
 */
public interface CRUD {
    public List listar();
    public Usuario list(int id);
    public boolean add(Usuario u);
    public boolean edit(Usuario per);
    public boolean delete(int id);
}
