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
 * BookingInfo entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="booking_info", catalog = "goods")
public class BookingInfo implements IBean {

	// Fields

	private static final long serialVersionUID = -8634327516729064903L;
	/**
	 * 
	 */
	
	private Integer id;
	private Integer goodsBookingId;
	private Integer goodsId;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public BookingInfo() {
	}

	/** minimal constructor */
	public BookingInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public BookingInfo(Integer id, Integer goodsBookingId, Integer goodsId,
			Integer quantity) {
		this.id = id;
		this.goodsBookingId = goodsBookingId;
		this.goodsId = goodsId;
		this.quantity = quantity;
	}

	// Property accessors

	@GenericGenerator(name="generator" ,strategy="increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name="id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="goods_booking_id", unique = true, nullable = false)
	public Integer getGoodsBookingId() {
		return this.goodsBookingId;
	}

	public void setGoodsBookingId(Integer goodsBookingId) {
		this.goodsBookingId = goodsBookingId;
	}

	@Column(name="goods_id", unique=true, nullable=false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name="quantity", unique = true, nullable = false)
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}