package projet.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id_admin;
	private boolean isActive;
	private String firstname;
	private String lastname;
	private String email;
	private String num;
	private String adress;
	private String imgSrc;
	private String pwd;
	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", isActive=" + isActive + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", num=" + num + ", adress=" + adress + ", imgSrc=" + imgSrc
				+ ", pwd=" + pwd + "]";
	}
	public long getId_admin() {
		return id_admin;
	}
	public void setId_admin(long id_admin) {
		this.id_admin = id_admin;
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
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Admin(long id_admin, boolean isActive, String firstname, String lastname, String email, String num,
			String adress, String imgSrc, String pwd) {
		super();
		this.id_admin = id_admin;
		this.isActive = isActive;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.num = num;
		this.adress = adress;
		this.imgSrc = imgSrc;
		this.pwd = pwd;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
}
