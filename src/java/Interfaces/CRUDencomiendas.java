/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Encomienda;

/**
 *
 * @author V330
 */
public interface CRUDencomiendas {
    public List listar();
    public Encomienda list(int id);
    public boolean add(Encomienda u);
    public boolean edit(Encomienda en);
    public boolean delete(int id);
}
