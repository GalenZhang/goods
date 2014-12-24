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
 * Order entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="order",catalog="goods")
public class Order implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6487707288637292519L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="order_number")
	private String orderNumber;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="order_info_id")
	private Integer orderInfoId;
	
	@Column(name="is_play")
	private Integer isPay;
	
	@Column(name="total_price")
	private Float totalPrice;
	
	@Column(name="ship_free")
	private Float shipFree;
	
	@Column(name="pay_type")
	private String payType;
	
	@Column(name="deliver_address_id")
	private Integer deliverAddressId;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Order(Integer id, String orderNumber, Integer userId,
			Integer orderInfoId, Integer isPay, Float totalPrice,
			Float shipFree, String payType, Integer deliverAddressId) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.userId = userId;
		this.orderInfoId = orderInfoId;
		this.isPay = isPay;
		this.totalPrice = totalPrice;
		this.shipFree = shipFree;
		this.payType = payType;
		this.deliverAddressId = deliverAddressId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderInfoId() {
		return this.orderInfoId;
	}

	public void setOrderInfoId(Integer orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Integer getIsPay() {
		return this.isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getShipFree() {
		return this.shipFree;
	}

	public void setShipFree(Float shipFree) {
		this.shipFree = shipFree;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getDeliverAddressId() {
		return this.deliverAddressId;
	}

	public void setDeliverAddressId(Integer deliverAddressId) {
		this.deliverAddressId = deliverAddressId;
	}

}