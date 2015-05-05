package org.spring.fleamarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "item")
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name="memberID")
	private long memberId;
	
	@Column(name="categoryID")
	private long categoryId;
	
	@Column(name="tradetypeID")
	private long tradetypeId;
	
	@Column(name="image")
	private long image;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getTradetypeId() {
		return tradetypeId;
	}

	public void setTradetypeId(long tradetypeId) {
		this.tradetypeId = tradetypeId;
	}

	public long getImage() {
		return image;
	}

	public void setImage(long image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", memberId=" + memberId + ", categoryId="
				+ categoryId + ", tradetypeId=" + tradetypeId + ", image="
				+ image + ", description=" + description + ", price=" + price
				+ "]";
	}
	
	
}
