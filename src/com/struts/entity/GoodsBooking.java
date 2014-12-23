package com.struts.entity;
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
 * GoodsBooking entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="goods_booking", catalog="goods")
public class GoodsBooking implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5210807790494114821L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	private Timestamp data;
	private Integer state;

	// Constructors

	/** default constructor */
	public GoodsBooking() {
	}

	/** minimal constructor */
	public GoodsBooking(Integer id, Timestamp data) {
		this.id = id;
		this.data = data;
	}

	/** full constructor */
	public GoodsBooking(Integer id, Integer userId, Timestamp data,
			Integer state) {
		this.id = id;
		this.userId = userId;
		this.data = data;
		this.state = state;
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

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}