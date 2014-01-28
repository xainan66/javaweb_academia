/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaweb_academia;

import dao.CursoDao;
import dao.HibernateUtil;
import dao.UsuarioDao;
import java.util.List;
import modelo.Curso;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author postal
 */
public class javaweb_academia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        UsuarioDao udao = new UsuarioDao();
//        CursoDao cdao = new CursoDao();
//        
//        Curso curso1 = new Curso("asi", 900, 500.5, true);
//        Usuario usuario1 = new Usuario("pepe", "pepe56", "1234", "pepe@gmail.com", curso1);
//        
//        cdao.guardar(curso1);
//        udao.guardar(usuario1);
        
        Curso curso;
            Session hbSession = HibernateUtil.getSFactory().openSession();
            hbSession.beginTransaction();
            Query query = hbSession.createQuery("from Curso where publico = true");
            List<Curso> listaCursos = query.list();
            for(int i=0;i<listaCursos.size();i++) {
                curso = listaCursos.get(i);
                System.out.println(curso.toString());
            }
    }
    
}
