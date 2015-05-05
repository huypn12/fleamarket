package org.spring.fleamarket.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@XmlRootElement(name = "member")
@Table(name = "member")
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@NotNull
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;

	@NotNull
	@Size(min = 10, max = 255)
	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private int status;

	@Size(min = 1, max = 25)
	// TODO change regexp satisfy it's following constraint
	@Pattern(regexp = "[^0-9]*", message = "Must contain only a-z, 0-9, -, _")
	@Column(name = "name")
	private String name;

	@Size(min = 10, max = 12)
	@Digits(fraction = 0, integer = 12)
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "signup_date")
	private Date signupDate;

	@Size(max = 16)
	@Column(name = "card_number")
	private String cardNumber;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "card_expires")
	private Date cardExpires;

	@Size(min = 0, max = 10)
	@Column(name = "total_rating")
	private double totalRating;

	@Column(name = "total_feedback")
	private long totalFeedback;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date registeredDate) {
		this.signupDate = registeredDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpires() {
		return cardExpires;
	}

	public void setCardExpires(Date cardExpires) {
		this.cardExpires = cardExpires;
	}

	public double getAverageRating() {
		return totalRating;
	}

	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}

	public long getTotalFeedback() {
		return totalFeedback;
	}

	public void setTotalFeedback(long totalFeedback) {
		this.totalFeedback = totalFeedback;
	}

	@Override
	public String toString() {
		return "Member [" + "id=" + id + ", email=" + email + ", password="
				+ password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", signupDate=" + signupDate + ", cardNumber=" + cardNumber
				+ ", cardExpires=" + cardExpires + ", totalRating="
				+ totalRating + ", totalFeedback=" + totalFeedback + "]";
	}
}
