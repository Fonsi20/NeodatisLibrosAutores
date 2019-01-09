package Objetos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16alfonsofa
 */
public class Autores {
    
private String dni;    
private String nombre;
private String direccion;
private int edad;
private String nacionalidad;
private Set<Libros> libro;

    public Autores() {
    }

    public Autores(String dni, String nombre, String direccion, int edad, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.libro = new HashSet<>(0);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Set<Libros> getLibro() {
        return libro;
    }

    public void setLibro(Set<Libros> libro) {
        this.libro = libro;
    }
    
}
