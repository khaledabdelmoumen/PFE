package projet.spring.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id_blog;
	private String description ;
	private String imgSrc;
	private String title;
	private String author;
	private String link;
	private Date createdAt;
	private int likes;
	
	public long getId_blog() {
		return id_blog;
	}
	public void setId_blog(long id_blog) {
		this.id_blog = id_blog;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Blog(String description, String imgSrc, String title, String author, Date createdAt, String link, int likes) {
		super();
		this.description = description;
		this.imgSrc = imgSrc;
		this.title = title;
		this.author = author;
		this.link = link;
		this.createdAt = createdAt;
		this.likes = likes;
		
	}
	
	
	@Override
	public String toString() {
		return "Blog [id_blog=" + id_blog + ", description=" + description + ", imgSrc=" + imgSrc + ", title=" + title
				+ ", author=" + author + ", link=" + link + ", createdAt=" + createdAt + "]";
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public Blog() {
	    // Constructeur par défaut
	}
	
	
}
