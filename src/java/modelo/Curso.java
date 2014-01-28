/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author postal
 */
@Entity
@Table(name = "Cursos")
public class Curso {
    @Id
    private long id;
    private String nombre;
    private int duracion;
    private double precio;
    private boolean publico;
    
    public Curso() {}
    
    public Curso(String nombre, int duracion, double precio, boolean publico) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.publico = publico;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }
}
