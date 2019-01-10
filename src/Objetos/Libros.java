package Objetos;

import java.util.*;
/**
 *
 * @author a16alfonsofa
 */
public class Libros {
    
    private int cod;
    private String Titulo;
    private String Categoria;
    private float Precio;
    private Date fechaPublicacion;

    public Libros() {
    }

    public Libros(int cod, String Titulo, String Categoria, float Precio, Date fechaPublicacion) {
        this.cod = cod;
        this.Titulo = Titulo;
        this.Categoria = Categoria;
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

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
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
