package com.sofans.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.sofans.spring.conver.TimestampJsonDeserializer;

/**
 * SofansOpOrder entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "sofans_op_order")
public class SofansSysOrder implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6001109676772306432L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "angent_id")
	private Integer angentId;
	
	private Integer quantity;
	private Timestamp createtime;
	private String description;
	private Integer state;


	// Constructors

	/** default constructor */
	public SofansSysOrder() {
	}

	/** full constructor */
	public SofansSysOrder(String orderNumber, Integer empId, Integer angentId,
			Integer quantity, Timestamp createtime, String description,
			Integer state) {
		this.orderNumber = orderNumber;
		this.empId = empId;
		this.angentId = angentId;
		this.quantity = quantity;
		this.createtime = createtime;
		this.description = description;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getAngentId() {
		return this.angentId;
	}

	public void setAngentId(Integer angentId) {
		this.angentId = angentId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	@JsonDeserialize(using = TimestampJsonDeserializer.class)  
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
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

}