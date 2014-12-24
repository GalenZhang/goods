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
 * CollectBox entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="collect_box", catalog="goods")
public class CollectBox implements IBean {

	// Fields
	private static final long serialVersionUID = 151795685807932708L;
	/**
	 * 
	 */
	
	private Integer id;
	private Integer goodsId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public CollectBox() {
	}

	/** minimal constructor */
	public CollectBox(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CollectBox(Integer id, Integer goodsId, Integer userId) {
		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
	}

	// Property accessors

	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="goods_id")
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name="user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}