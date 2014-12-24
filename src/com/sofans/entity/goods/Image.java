package com.sofans.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
// default package

import com.sofans.entity.IBean;

/**
 * Image entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="image",catalog="goods")
public class Image implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3251488776157214495L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;
	private String url;

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** minimal constructor */
	public Image(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Image(Integer id, Integer goodsId, String url) {
		this.id = id;
		this.goodsId = goodsId;
		this.url = url;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}