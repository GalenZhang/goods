package com.sofans.entity.goods;

import java.sql.Timestamp;

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

/**
 * @author admin
 *
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
	
	@Column(name="pay_status")//OrderStatus
	private Integer payStatus;
	
	@Column(name="total_price")
	private Float totalPrice;
	
	@Column(name="transportation_fee")
	private Float transportationFee;
	
	@Column(name="pay_type")//PayType
	private String payType;
	
	@Column(name="deliver_address_id")
	private Integer deliverAddressId;
	
	@Column(name="send_time")
	private Timestamp sendTime;
	//order_time
	@Column(name="order_time")
	private Timestamp orderTime;

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
			Integer payStatus, Float totalPrice,
			Float transportationFee, String payType, Integer deliverAddressId, Timestamp sendTime, Timestamp orderTime) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.userId = userId;
		this.payStatus = payStatus;
		this.totalPrice = totalPrice;
		this.transportationFee = transportationFee;
		this.payType = payType;
		this.deliverAddressId = deliverAddressId;
		this.sendTime = sendTime;
		this.orderTime = orderTime;
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

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getTransportationFee() {
		return transportationFee;
	}

	public void setTransportationFee(Float transportationFee) {
		this.transportationFee = transportationFee;
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

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
}