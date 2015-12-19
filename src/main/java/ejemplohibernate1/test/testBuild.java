package ejemplohibernate1.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ejemplohibernate1.utils.HibernateUtil;

public class testBuild {

	public static void main(String[] args) {
		
		try{
			
			SessionFactory sf =  HibernateUtil.getSessionFactory();
			
			Session session = sf.getCurrentSession();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
				
		
	}

}
