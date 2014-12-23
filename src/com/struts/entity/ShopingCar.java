package com.struts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
// default package

import com.sofans.entity.IBean;

/**
 * ShopingCar entity. @author MyEclipse Persistence Tools
 */


@Entity
@Table(name="shoping_car",catalog="goods")
public class ShopingCar implements IBean {

	// Fields

	private static final long serialVersionUID = -8268778187755730863L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;

	// Constructors

	/** default constructor */
	public ShopingCar() {
	}

	/** minimal constructor */
	public ShopingCar(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ShopingCar(Integer id, Integer userId) {
		this.id = id;
		this.userId = userId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}