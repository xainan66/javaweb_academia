/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author postal
 */
@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String usuario;
    private String passwd;
    private String correo;
    @ManyToMany
    @JoinTable(name = "Usuarios_Cursos", joinColumns = @JoinColumn(name = "idUsuario"),inverseJoinColumns = @JoinColumn(name = "idCurso"))
    private List<Curso> cursos;
    
    public Usuario() {
        this.cursos =new ArrayList<Curso>();
    }
    
    public Usuario(String nombre, String usuario, String passwd, String correo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.passwd = passwd;
        this.correo = correo;
        this.cursos =new ArrayList<Curso>();
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void addCurso(Curso c){
        this.cursos.add(c);
    }
}
