package com.struts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sofans.entity.IBean;

// default package

/**
 * DeliverAddress entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="deliver_address" ,catalog="goods")
public class DeliverAddress implements IBean{

	// Fields

	private static final long serialVersionUID = 8406056077608046620L;
	private Integer id;
	private Integer userId;
	private String address;
	private String receiverName;
	private String receiverPhone;

	// Constructors

	/** default constructor */
	public DeliverAddress() {
	}

	/** minimal constructor */
	public DeliverAddress(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public DeliverAddress(Integer id, Integer userId, String address,
			String receiverName, String receiverPhone) {
		this.id = id;
		this.userId = userId;
		this.address = address;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
	}

	// Property accessors

	@GenericGenerator(name="generator", strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="receiver_name")
	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Column(name="receiver_phone")
	public String getReceiverPhone() {
		return this.receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

}