package com.sofans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * 职位表
 */


@Entity
@Table(name="sofans_op_position",catalog="ssop")
public class SofansSysPosition implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083023252404405441L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String position;

	// Constructors

	/** default constructor */
	public SofansSysPosition() {
	}

	/** full constructor */
	public SofansSysPosition(String position) {
		this.position = position;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}