package projet.spring.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_product;
	private String name;
	private float price;
	private int qt_stock;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private int rating;
	private Date purchaseDate;
	private Date endDate;
	private String description;
	private String installation;
	private String technical_overview;
	private String shipping_return;
    @OneToOne(mappedBy = "product")
    private Feedback feedback;
	
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", name=" + name + ", price=" + price + ", qt_stock=" + qt_stock
				+ ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4
				+ ", rating=" + rating + ", purchaseDate=" + purchaseDate + ", endDate=" + endDate + ", description="
				+ description + ", installation=" + installation + ", technical_overview=" + technical_overview
				+ ", shipping_return=" + shipping_return + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQt_stock() {
		return qt_stock;
	}
	public void setQt_stock(int qt_stock) {
		this.qt_stock = qt_stock;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getImage4() {
		return image4;
	}
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstallation() {
		return installation;
	}
	public void setInstallation(String installation) {
		this.installation = installation;
	}
	public String getTechnical_overview() {
		return technical_overview;
	}
	public void setTechnical_overview(String technical_overview) {
		this.technical_overview = technical_overview;
	}
	public String getShipping_return() {
		return shipping_return;
	}
	public void setShipping_return(String shipping_return) {
		this.shipping_return = shipping_return;
	}
	public long getId_product() {
		return id_product;
	}
	public void setId_product(long id_product) {
		this.id_product = id_product;
	}
	public Product(String name, float price, int qt_stock, String image1, String image2, String image3, String image4,
			int rating, Date purchaseDate, Date endDate, String description, String installation,
			String technical_overview, String shipping_return) {
		super();
		this.name = name;
		this.price = price;
		this.qt_stock = qt_stock;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.rating = rating;
		this.purchaseDate = purchaseDate;
		this.endDate = endDate;
		this.description = description;
		this.installation = installation;
		this.technical_overview = technical_overview;
		this.shipping_return = shipping_return;
	}
	public Product() {}
}

