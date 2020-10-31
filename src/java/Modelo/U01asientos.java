package Modelo;


public class U01asientos{
    private int id_asiento;
    private int disponibilidad;

    public U01asientos() {
    }

    public U01asientos(int id_asiento, int disponibilidad) {
        this.id_asiento = id_asiento;
        this.disponibilidad = disponibilidad;
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
