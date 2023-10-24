package projet.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartLine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long idEntry;
	private int ProdQuantity;
	private float EntryPrice ;
	@Override
	public String toString() {
		return "CartLine [idEntry=" + idEntry + ", ProdQuantity=" + ProdQuantity + ", EntryPrice=" + EntryPrice + "]";
	}
	public long getIdEntry() {
		return idEntry;
	}
	public void setIdEntry(long idEntry) {
		this.idEntry = idEntry;
	}
	public int getProdQuantity() {
		return ProdQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		ProdQuantity = prodQuantity;
	}
	public float getEntryPrice() {
		return EntryPrice;
	}
	public void setEntryPrice(float entryPrice) {
		EntryPrice = entryPrice;
	}
	public CartLine(long idEntry, int prodQuantity, float entryPrice) {
		super();
		this.idEntry = idEntry;
		ProdQuantity = prodQuantity;
		EntryPrice = entryPrice;
	}
	public CartLine() {
		
		// TODO Auto-generated constructor stub
	}
	
}
