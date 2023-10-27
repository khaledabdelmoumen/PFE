package projet.spring.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity 
public class Feedback implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_feedback;
	private String description;
	private Timestamp createdDate;
	private int note;
	private String img;
	
	private String name;
	private String email;
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@OneToOne
	    @JoinColumn(name = "id_product")
	    private Product product;
	
	public long getId_feedback() {
		return id_feedback;
	}
	public void setId_feedback(long id_feedback) {
		this.id_feedback = id_feedback;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Feedback [id_feedback=" + id_feedback + ", description=" + description + ", createdDate=" + createdDate
				+ "]";
	}
	public Feedback(String description, Timestamp createdDate) {
		super();
		this.description = description;
		this.createdDate = createdDate;
	}
	
	public Feedback() {
		
	}
	

}
