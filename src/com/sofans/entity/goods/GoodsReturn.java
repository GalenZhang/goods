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
 * GoodsReturn entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="goods_return",catalog="goods")
public class GoodsReturn implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4526398848640160069L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="return_number")
	private String returnNumber;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="description")
	private String description;
	private Integer state;
	private Timestamp data;

	// Constructors

	/** default constructor */
	public GoodsReturn() {
	}

	/** minimal constructor */
	public GoodsReturn(Integer id, Timestamp data) {
		this.id = id;
		this.data = data;
	}

	/** full constructor */
	public GoodsReturn(Integer id, String returnNumber, Integer userId,
			String description, Integer state, Timestamp data) {
		this.id = id;
		this.returnNumber = returnNumber;
		this.userId = userId;
		this.description = description;
		this.state = state;
		this.data = data;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReturnNumber() {
		return this.returnNumber;
	}

	public void setReturnNumber(String returnNumber) {
		this.returnNumber = returnNumber;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

}