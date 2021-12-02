package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//on joint la base de données à l'entité
@Entity
@Table(name="employe")

public class Employe {
	
	private long id;
	private String lastName;
	private String firstName;
	private String courriel;
	private int age;
	private String position;
	private String phone;
	private String adress;
	
	public Employe() {
	}

	// Colum(name="id"): id est le nom de la colonne dans la base de données
	// GenenratedValue est le manière de générer la clé primare:
	// AUTO : hibernate gère les valeurs des id
	// IDENTITY: mysql gère par auto_increment 
	// TABLE: hibernate gère
	// SEQUENCE: mysql gère 
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}                                                                                                                                
	
	

}
