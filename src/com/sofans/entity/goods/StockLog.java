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
 * StockLog entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="stock_log",catalog="goods")
public class StockLog implements IBean {

	// Fields

	private static final long serialVersionUID = 2407177412901367694L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;
	
	private Integer quantity;
	private Integer state;
	private Timestamp data;

	// Constructors

	/** default constructor */
	public StockLog() {
	}

	/** minimal constructor */
	public StockLog(Integer id, Timestamp data) {
		this.id = id;
		this.data = data;
	}

	/** full constructor */
	public StockLog(Integer id, Integer goodsId, Integer quantity,
			Integer state, Timestamp data) {
		this.id = id;
		this.goodsId = goodsId;
		this.quantity = quantity;
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