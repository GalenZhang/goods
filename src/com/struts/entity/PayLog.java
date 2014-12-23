package com.struts.entity;
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
 * PayLog entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="pay_log")
public class PayLog implements IBean {

	// Fields

	private static final long serialVersionUID = -8832735178456191051L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="total_price")
	private Float totalPrice;
	private Timestamp data;

	// Constructors

	/** default constructor */
	public PayLog() {
	}

	/** minimal constructor */
	public PayLog(Integer id, Timestamp data) {
		this.id = id;
		this.data = data;
	}

	/** full constructor */
	public PayLog(Integer id, Integer userId, Integer orderId,
			Float totalPrice, Timestamp data) {
		this.id = id;
		this.userId = userId;
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.data = data;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

}