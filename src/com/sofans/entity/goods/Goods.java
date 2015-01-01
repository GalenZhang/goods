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
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="goods",catalog="goods")
public class Goods implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1907323780069919903L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	private Integer id;
	
	@Column(name="goods_class_id")
	private Integer goodsClassId;
	
	@Column(name="good_name")
	private String goodName;
	
	@Column(name="good_number")//auto generate
	private String goodNumber;
	
	@Column(name="introduce")
	private String introduce;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="weight")
	private Float weight;
	private String image;
	
	@Column(name="market_price")
	private Float marketPrice;
	
	@Column(name="member_price")
	private Float memberPrice;
	
	@Column(name="is_hot")
	private Integer isHot;
	
	@Column(name="is_discount")
	private Integer isDiscount;
	
	@Column(name="add_data")
	private Timestamp addData;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Integer id, Timestamp addData) {
		this.id = id;
		this.addData = addData;
	}

	/** full constructor */
	public Goods(Integer id, Integer goodsClassId, String goodName, String goodNumber,
			String introduce, String brand, Float weight, String image,
			Float marketPrice, Float memberPrice, Integer isHot,
			Integer isDiscount, Timestamp addData) {
		this.id = id;
		this.goodsClassId = goodsClassId;
		this.goodName = goodName;
		this.goodNumber = goodNumber;
		this.introduce = introduce;
		this.brand = brand;
		this.weight = weight;
		this.image = image;
		this.marketPrice = marketPrice;
		this.memberPrice = memberPrice;
		this.isHot = isHot;
		this.isDiscount = isDiscount;
		this.addData = addData;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsClassId() {
		return this.goodsClassId;
	}

	public void setGoodsClassId(Integer goodsClassId) {
		this.goodsClassId = goodsClassId;
	}

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Float getMemberPrice() {
		return this.memberPrice;
	}

	public void setMemberPrice(Float memberPrice) {
		this.memberPrice = memberPrice;
	}

	public Integer getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsDiscount() {
		return this.isDiscount;
	}

	public void setIsDiscount(Integer isDiscount) {
		this.isDiscount = isDiscount;
	}

	public Timestamp getAddData() {
		return this.addData;
	}

	public void setAddData(Timestamp addData) {
		this.addData = addData;
	}

}