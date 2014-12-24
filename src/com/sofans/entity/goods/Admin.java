package com.sofans.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sofans.entity.IBean;

// default package

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="admin" ,catalog="goods")
public class Admin implements IBean {

	// Fields
	private static final long serialVersionUID = 7556425948045605119L;
	/**
	 * 
	 */
	
	private Integer id;
	
	private String adminId;
	private String adminPassword;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Admin(Integer id, String adminId, String adminPassword) {
		this.id = id;
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	// Property accessors

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name="id",unique = true, nullable = false )
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="admin_id", unique = true, nullable = false)
	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Column(name="admin_password", unique = true, nullable = false)
	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}