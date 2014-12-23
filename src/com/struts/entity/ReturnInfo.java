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
 * ReturnInfo entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="return_info",catalog="goods")
public class ReturnInfo implements IBean {

	// Fields

	private static final long serialVersionUID = 9157555356399614707L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="goods_return_id")
	private Integer goodsReturnId;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	private Integer quantity;

	// Constructors

	/** default constructor */
	public ReturnInfo() {
	}

	/** minimal constructor */
	public ReturnInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ReturnInfo(Integer id, Integer goodsReturnId, Integer goodsId,
			Integer quantity) {
		this.id = id;
		this.goodsReturnId = goodsReturnId;
		this.goodsId = goodsId;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsReturnId() {
		return this.goodsReturnId;
	}

	public void setGoodsReturnId(Integer goodsReturnId) {
		this.goodsReturnId = goodsReturnId;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}