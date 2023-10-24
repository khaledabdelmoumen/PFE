package projet.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PromotionCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_coupon;
	@Override
	public String toString() {
		return "PromotionCard [id_coupon=" + id_coupon + ", description=" + description + ", discountValue="
				+ discountValue + ", code=" + code + ", creationDate=" + creationDate + ", endDate=" + endDate
				+ ", isActive=" + isActive + "]";
	}
	
	
	public PromotionCard(long id_coupon, String description, float discountValue, String code, String creationDate,
			String endDate, boolean isActive) {
		super();
		this.id_coupon = id_coupon;
		this.description = description;
		this.discountValue = discountValue;
		this.code = code;
		this.creationDate = creationDate;
		this.endDate = endDate;
		this.isActive = isActive;
	}
	
	
	public long getId_coupon() {
		return id_coupon;
	}
	public void setId_coupon(long id_coupon) {
		this.id_coupon = id_coupon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(float discountValue) {
		this.discountValue = discountValue;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	private String description;
    private float discountValue;
    private String code;
    private String creationDate; // Changed to String
    private String endDate; // Changed to String
    private boolean isActive;
	 
public PromotionCard() {
}
}
