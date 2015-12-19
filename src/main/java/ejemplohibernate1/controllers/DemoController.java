package ejemplohibernate1.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ejemplohibernate1.model.Usuario;
import ejemplohibernate1.utils.HibernateUtil;

@ManagedBean
@ViewScoped 
public class DemoController {
	
	private String testString = "";
	private List<Usuario> usuarios ;
	
	public DemoController(){
		usuarios = new ArrayList<Usuario>();
	}
	
    @PostConstruct
    public void init() {

    }
    
    @SuppressWarnings("unchecked")
	public void probarHibernate(){
    	testString = "test";
    	
    	SessionFactory sf = HibernateUtil.getSessionFactory();
    	Session session = sf.getCurrentSession();
    	
    	Transaction tran = session.beginTransaction();
    	
   	
    	List<Usuario> usuarios = (List<Usuario>) session
	    	.createQuery("SELECT user FROM Usuario user")
	    	.list();
    	
    	
    	this.usuarios = usuarios;
    	
    	tran.commit();
    }

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
}
