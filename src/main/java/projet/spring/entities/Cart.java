package projet.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idCart;
	private long NbArticles;
	private float TotalPrice;
	@Override
	public String toString() {
		return "Cart [idCart=" + idCart + ", NbArticles=" + NbArticles + ", TotalPrice=" + TotalPrice + "]";
	}
	public long getIdCart() {
		return idCart;
	}
	public void setIdCart(long idCart) {
		this.idCart = idCart;
	}
	public long getNbArticles() {
		return NbArticles;
	}
	public void setNbArticles(long nbArticles) {
		NbArticles = nbArticles;
	}
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}
	public Cart(long idCart, long nbArticles, float totalPrice) {
		super();
		this.idCart = idCart;
		NbArticles = nbArticles;
		TotalPrice = totalPrice;
	}
	public Cart() {
		
		// TODO Auto-generated constructor stub
	}
}
