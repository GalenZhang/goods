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
 * GoodsDetailInfo entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="goods_detail_info" ,catalog="goods")
public class GoodsDetailInfo implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5215244049518778452L;
	
	@GenericGenerator(name="generator", strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	@Column(name="detail")
	private String detail;

	// Constructors

	/** default constructor */
	public GoodsDetailInfo() {
	}

	/** minimal constructor */
	public GoodsDetailInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public GoodsDetailInfo(Integer id, Integer goodsId, String detail) {
		this.id = id;
		this.goodsId = goodsId;
		this.detail = detail;
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

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}