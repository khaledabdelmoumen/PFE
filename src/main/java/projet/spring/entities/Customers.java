package projet.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id_customer;
	private boolean isActive;
	private String firstname;
	private String lastname;
	private String email;
	private String num;
	private String adress;
	private String pwd;
	public long getId_customer() {
		return id_customer;
	}
	public void setId_customer(long id_customer) {
		this.id_customer = id_customer;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Customers(boolean isActive, String firstname, String lastname, String email, String num, String adress,
			String pwd) {
		super();
		this.isActive = isActive;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.num = num;
		this.adress = adress;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Customers [id_customer=" + id_customer + ", isActive=" + isActive + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", num=" + num + ", adress=" + adress + ", pwd=" + pwd
				+ "]";
	}
	
	public Customers() {
		
	}

	
}
