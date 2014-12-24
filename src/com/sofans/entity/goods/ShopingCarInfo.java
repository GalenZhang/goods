package com.sofans.entity.goods;
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
 * ShopingCarInfo entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="shoping_car_info")
public class ShopingCarInfo implements IBean{

	// Fields

	private static final long serialVersionUID = -1147922705090377212L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="shoping_car_id")
	private Integer shopingCarId;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	private Integer quantity;
	private Timestamp data;

	// Constructors

	/** default constructor */
	public ShopingCarInfo() {
	}

	/** minimal constructor */
	public ShopingCarInfo(Integer id, Timestamp data) {
		this.id = id;
		this.data = data;
	}

	/** full constructor */
	public ShopingCarInfo(Integer id, Integer shopingCarId, Integer goodsId,
			Integer quantity, Timestamp data) {
		this.id = id;
		this.shopingCarId = shopingCarId;
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.data = data;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopingCarId() {
		return this.shopingCarId;
	}

	public void setShopingCarId(Integer shopingCarId) {
		this.shopingCarId = shopingCarId;
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

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

}