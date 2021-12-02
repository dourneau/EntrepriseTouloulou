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
			// Si tout a fonctionné
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
	
	protected Employe create( ) {
		//je crée un enregistrement
		
		/*
		Book book = new Book();
		book.setTitle("October");
		book.setAuthor("Soren Sveistrup");
		book.setPrice(34.50f);
		
		Book book2 = new Book();
		book2.setTitle("Fundation");
		book2.setAuthor("Isaac Azimov");
		book2.setPrice(9.99f);
		*/
		Employe employe = new Employe();
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employe);
		session.getTransaction().commit();
		session.close();
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
		
		/**
		BookManager manager = new BookManager();
		manager.setup();
		//manager.create();
		//manager.read();
		
		/*
		Book book = new Book();
		book.setPrice(54f);
		long id = 3;
		manager.update(id,book);
		*/
		
		/*
		Book book = new Book();
		long id = 3;
		manager.delete(book);		
		manager.exit();
		*/
		
		
	}
}
