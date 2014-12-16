package com.sofans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * SofansSysCustomer entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="sofans_sys_customer")
public class SofansSysCustomer implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2387142502752131921L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="sf_key")
	private String sfKey;
	private String password;
	private Integer state;

	// Constructors

	/** default constructor */
	public SofansSysCustomer() {
	}

	/** full constructor */
	public SofansSysCustomer(String sfKey, String password, Integer state) {
		this.sfKey = sfKey;
		this.password = password;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSfKey() {
		return this.sfKey;
	}

	public void setSfKey(String sfKey) {
		this.sfKey = sfKey;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}