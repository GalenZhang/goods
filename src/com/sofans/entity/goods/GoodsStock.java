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
 * GoodsStock entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="goods_stock")
public class GoodsStock implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 793984757946779491L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	@Column(name="total_quantity")
	private Integer totalQuantity;
	
	@Column(name="rest_quantity")
	private Integer restQuantity;

	// Constructors

	/** default constructor */
	public GoodsStock() {
	}

	/** minimal constructor */
	public GoodsStock(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public GoodsStock(Integer id, Integer goodsId, Integer totalQuantity,
			Integer restQuantity) {
		this.id = id;
		this.goodsId = goodsId;
		this.totalQuantity = totalQuantity;
		this.restQuantity = restQuantity;
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

	public Integer getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getRestQuantity() {
		return this.restQuantity;
	}

	public void setRestQuantity(Integer restQuantity) {
		this.restQuantity = restQuantity;
	}

}