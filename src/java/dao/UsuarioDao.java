/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author postal
 */
public class UsuarioDao {

    private Session sesion;
    private Transaction transaccion;

    public long guardar(Usuario p){
        long id = -1;
        try {
            sesion = HibernateUtil.getSFactory().openSession();
            transaccion = sesion.beginTransaction();
            id = (Long) sesion.save(p);
            transaccion.commit();
        } catch (HibernateException he) {
            transaccion.rollback();
            he.printStackTrace();
        } finally {
            sesion.close();
        }
        return id;
    }
    
    public void actualizar(Usuario p) throws HibernateException{
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
    
    public void eliminar(Usuario p) throws HibernateException{
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
    
    public Usuario obtenerUno(long id) throws HibernateException{
         Usuario p = null;
         try {
            sesion = HibernateUtil.getSFactory().openSession();            
            p=(Usuario)sesion.get(Usuario.class, id);
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return p;
    }
    
    public Usuario obtenerUno(String usuario) throws HibernateException{
         Usuario u = null;
         try {
            sesion = HibernateUtil.getSFactory().openSession();
            Query query =sesion.createQuery("from Usuario u left join fetch u.cursos where u.usuario = '"+usuario+"'");
            query.setMaxResults(1);
            u = (Usuario) query.uniqueResult();
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return u;
    }
    
    public boolean validarUsuario(String usuario, String passwd) throws HibernateException{
         Usuario u = null;
         boolean resultado = false;
         try {
            sesion = HibernateUtil.getSFactory().openSession();
            Query query =sesion.createQuery("from Usuario where usuario = '"+usuario+"' and passwd = '"+passwd+"'");
            query.setMaxResults(1);
            u = (Usuario) query.uniqueResult();
            if((u!=null) && (u.getUsuario().equals(usuario) && u.getPasswd().equals(passwd))){
                resultado = true;
            }
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return resultado;
    }
    
    public List<Usuario> obtenerTodos() throws HibernateException{
         List<Usuario> lista;
         try {
            sesion = HibernateUtil.getSFactory().openSession();
            lista=sesion.createQuery("from Usuario").list();
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return lista;
    }

    public boolean existe(Usuario usuario) {
        boolean retorno = false;
        try {
            sesion = HibernateUtil.getSFactory().openSession();
            Query query = sesion.createQuery("from Usuario where usuario ='"+usuario.getUsuario()+"'");
            List<Usuario> lista = query.list();
            if(!lista.isEmpty()) {
                retorno = true;
            }
        } catch (HibernateException he) {
            throw new HibernateException("Error en el DAO");
        } finally {
            sesion.close();
        }
        return retorno;
    }
}
