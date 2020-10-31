
package Modelo;

public class U01rutas {
    private String fecha;
    private  int itinerarios_id;
    private int duracion;
    private double precio;

    public U01rutas() {
    }

    public U01rutas(String fecha, int itinerarios_id, int duracion, double precio) {
        this.fecha = fecha;
        this.itinerarios_id = itinerarios_id;
        this.duracion = duracion;
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getItinerarios_id() {
        return itinerarios_id;
    }

    public void setItinerarios_id(int itinerarios_id) {
        this.itinerarios_id = itinerarios_id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
