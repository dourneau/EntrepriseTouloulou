package manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Employe;

public class EmployeManager {
	
protected SessionFactory sessionFactory;
	
	protected void setup() {
		// code qui me permet de load une session hibernate
		// On récupère la conf d'hibernate pour créer une registry
		//ATTENTION: ICI ON NE SE CONNECTE PAS
		//DONC ON NE LANCE PAS DE SESSION AVEC LA BDD
		
		final StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build();
		
		try {
			// On essaie de se sonnecter àa la BDD
			// On construit notre session
			sessionFactory = new MetadataSources(registry)
					.buildMetadata().buildSessionFactory();
			
			/*
			//Si tout a fonctionné
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.getTransaction();
			session.getTransaction().commit();
			session.close();
			*/
			
			
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			ex.getStackTrace();
		}
	}
	
	protected void exit ( ) {
		//supprimer une session hibernate
		sessionFactory.close();
	}
	
	protected void create() {
		//je crée un enregistrement
		
		Employe employe1 = new Employe();
		employe1.setLastName("West");
		employe1.setFirstName("James");
		employe1.setCourriel("james.west@touloulou.com");
		employe1.setAge(57);
		employe1.setPosition("espion");
		employe1.setPhone("0101010101");
		employe1.setAdress("1 Avenue des Champs Elysées 75000 PARIS");
		
		
		
		Employe employe2 = new Employe();
		employe2.setFirstName("Arthimus");
		employe2.setLastName("Gordon");
		employe2.setCourriel("arthimus.gordon@touloulou.com");
		employe2.setAge(54);
		employe2.setPosition("espion");
		employe2.setPhone("0202020202");
		employe2.setAdress("2 Rue de la Paix 75000 PARIS");

		
		/*
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		session1.save(employe1);
		session1.getTransaction().commit();
		session1.close();
		*/
		
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.save(employe2);
		session2.getTransaction().commit();
		session2.close();
		
		
	}
	
	protected Employe read(long id) {
		
		/*
		Session session = sessionFactory.openSession();
		id = 3;
		Book book = session.get(Book.class, id);
		
		System.out.println("Title "+book.getTitle());
		*/
		
		Session session = sessionFactory.openSession();
		Employe employe = session.get(Employe.class, id);
		
		return employe;
	}
	
	protected void update(long id,Employe newEmploye ) {
		
		/*
		Book book = this.read(id);
		if (newBook.getTitle() != null ) {
			book.setTitle(newBook.getTitle());
		}
		if (newBook.getAuthor() != null) {
			book.setAuthor(newBook.getAuthor());
		}
		if (newBook.getPrice() != book.getPrice()) {
			book.setPrice(newBook.getPrice());
		}
		*/
		
		Employe employe = this.read(id);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employe);
		session.getTransaction().commit();
		session.close();
		
	}
	
	protected void delete(Employe employe) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(employe);
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		EmployeManager manager = new EmployeManager();
		manager.setup();
		manager.create();
		//manager.read();
		
		
		
		
	}
}
