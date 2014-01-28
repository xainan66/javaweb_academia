/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Curso;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author postal
 */
public class CursoDao {

    private Session sesion;
    private Transaction transaccion;

    public long guardar(Curso p){
        long id = -1;
        try {
            sesion = HibernateUtil.getSFactory().openSession();
            transaccion = sesion.beginTransaction();
            id = (long) sesion.save(p);
            transaccion.commit();
        } catch (HibernateException he) {
            transaccion.rollback();
            he.printStackTrace();
        } finally {
            sesion.close();
        }
        return id;
    }
    
    public void actualizar(Curso p) throws HibernateException{
        try {
            sesion = HibernateUtil.getSFactory().openSession();
            transaccion = sesion.beginTransaction();
            sesion.update(p);
            transaccion.commit();
        } catch (HibernateException he) {
            transaccion.rollback();
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
    }
    
    public void eliminar(Curso p) throws HibernateException{
        try {
            sesion = HibernateUtil.getSFactory().openSession();
            transaccion = sesion.beginTransaction();
            sesion.delete(p);
            transaccion.commit();
        } catch (HibernateException he) {
            transaccion.rollback();
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
    }
    
    public Curso obtenerUno(long id) throws HibernateException{
         Curso p = null;
         try {
            sesion = HibernateUtil.getSFactory().openSession();            
            p=(Curso)sesion.get(Curso.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return p;
    }
    
    public List<Curso> obtenerTodos() throws HibernateException{
         List<Curso> lista;
         try {
            sesion = HibernateUtil.getSFactory().openSession();
            lista=sesion.createQuery("from Cursos").list();
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return lista;
    }
    
        public List<Curso> obtenerTodosPublicos() throws HibernateException{
         List<Curso> lista;
         try {
            sesion = HibernateUtil.getSFactory().openSession();
            lista=sesion.createQuery("from Curso where publico = true").list();
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return lista;
    }

    public boolean existe(Curso curso) {
        boolean retorno = false;
        Object resultado;
        try {
            sesion = HibernateUtil.getSFactory().openSession();
            List<Curso> lista = sesion.createQuery("from Curso where nombre ='"+curso.getNombre()+"'").list();
            Curso cursoBD = lista.get(0);
            if(cursoBD!=null) {
                long id = cursoBD.getId();
                resultado = sesion.get(Curso.class, id);
                if(resultado!=null) {
                    retorno = true;
                }
            }
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return retorno;
    }
}
