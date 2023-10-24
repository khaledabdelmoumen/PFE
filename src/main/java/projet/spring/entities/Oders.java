package projet.spring.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Oders implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id_oder;
	
	private String name;
	private String Companyname;
	private String Country;
	private String state ;
	private String zidcode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyname() {
		return Companyname;
	}
	public void setCompanyname(String companyname) {
		Companyname = companyname;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZidcode() {
		return zidcode;
	}
	public void setZidcode(String zidcode) {
		this.zidcode = zidcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomeadress() {
		return homeadress;
	}
	public void setHomeadress(String homeadress) {
		this.homeadress = homeadress;
	}

	private String phone;
	private String email;
	private String homeadress;
private Timestamp creationDate;
private String deliveryAdress;
private String status;
private float total;
public long getId_oder() {
	return id_oder;
}
public void setId_oder(long id_oder) {
	this.id_oder = id_oder;
}


public Timestamp getCreationDate() {
	return creationDate;
}
public void setCreationDate(Timestamp creationDate) {
	this.creationDate = creationDate;
}
public String getDeliveryAdress() {
	return deliveryAdress;
}
public void setDeliveryAdress(String deliveryAdress) {
	this.deliveryAdress = deliveryAdress;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
@Override
public String toString() {
	return "Oders [id_oder=" + id_oder + ", creationDate=" + creationDate + ", deliveryAdress=" + deliveryAdress
			+ ", status=" + status + ", total=" + total + "]";
}
public Oders(Timestamp creationDate, String deliveryAdress, String status, float total) {
	super();
	this.creationDate = creationDate;
	this.deliveryAdress = deliveryAdress;
	this.status = status;
	this.total = total;
}

public Oders() {
    // Constructeur par défaut
}
}
