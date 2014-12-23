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
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="order_info",catalog="goods")
public class OrderInfo implements IBean {

	// Fields

	private static final long serialVersionUID = -3255642475346345998L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="quantity")
	private Integer quantity;

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public OrderInfo(Integer id, Integer goodsId, Integer orderId,
			Integer quantity) {
		this.id = id;
		this.goodsId = goodsId;
		this.orderId = orderId;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}