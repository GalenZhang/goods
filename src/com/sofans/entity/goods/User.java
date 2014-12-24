package com.sofans.entity.goods;
// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sofans.entity.IBean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="user",catalog="goods")
public class User implements IBean {

	// Fields

	private static final long serialVersionUID = -8896760207819944490L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="username")
	private String username;
	private String password;
	
	@Column(name="true_name")
	private String trueName;
	
	@Column(name="id_card")
	private String idCard;
	private String phone;
	private String email;
	private String city;
	private String address;
	
	@Column(name="post_code")
	private String postCode;
	private Integer integral;
	
	private Integer state;
	
	@Column(name="is_admin")
	private Integer is_admin;
	
	@Column(name="load_data")
	private Timestamp loadData;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id, Timestamp loadData) {
		this.id = id;
		this.loadData = loadData;
	}

	/** full constructor */
	public User(Integer id, String username, String password, String trueName,
			String idCard, String phone, String email, String city,
			String address, String postCode, Integer integral,Integer state,Integer is_admin,
			Timestamp loadData) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.trueName = trueName;
		this.idCard = idCard;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.address = address;
		this.postCode = postCode;
		this.integral = integral;
		this.state = state;
		this.is_admin = is_admin;
		this.loadData = loadData;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Timestamp getLoadData() {
		return this.loadData;
	}

	public void setLoadData(Timestamp loadData) {
		this.loadData = loadData;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(Integer is_admin) {
		this.is_admin = is_admin;
	}

}