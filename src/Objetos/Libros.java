package Objetos;

import java.util.*;
/**
 *
 * @author a16alfonsofa
 */
public class Libros {
    
    private int cod;
    private String Titulo;
    private String Categoría;
    private float Precio;
    private Date fechaPublicacion;

    public Libros() {
    }

    public Libros(int cod, String Titulo, String Categoría, float Precio, Date fechaPublicacion) {
        this.cod = cod;
        this.Titulo = Titulo;
        this.Categoría = Categoría;
        this.Precio = Precio;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getCategoría() {
        return Categoría;
    }

    public void setCategoría(String Categoría) {
        this.Categoría = Categoría;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
    
    
}
