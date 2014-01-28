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
        UsuarioDao udao = new UsuarioDao();
        CursoDao cdao = new CursoDao();
//        
        Curso curso1 = new Curso("bases de datos", 300, 200.0, true);
        Curso curso2 = new Curso("programacion", 300, 200.0, false);
        Curso curso3 = new Curso("mecanografia", 300, 200.0, true);
        Curso curso4 = new Curso("frances", 300, 200.0, false);
        Curso curso5 = new Curso("quimica", 300, 200.0, true);
        Usuario usuario1 = new Usuario("pepe", "pepe56", "1234", "pepe@gmail.com");
        usuario1.addCurso(curso1);
        usuario1.addCurso(curso2);
        usuario1.addCurso(curso3);
        usuario1.addCurso(curso4);
        usuario1.addCurso(curso5);
//        
        cdao.guardar(curso1);
        cdao.guardar(curso2);
        cdao.guardar(curso3);
        cdao.guardar(curso4);
        cdao.guardar(curso5);
        
        udao.guardar(usuario1);
        
        
        
//        Curso curso;
//            Session hbSession = HibernateUtil.getSFactory().openSession();
//            hbSession.beginTransaction();
//            Query query = hbSession.createQuery("from Curso where publico = true");
//            List<Curso> listaCursos = query.list();
//            for(int i=0;i<listaCursos.size();i++) {
//                curso = listaCursos.get(i);
//                System.out.println(curso.toString());
//            }
    }
    
}
