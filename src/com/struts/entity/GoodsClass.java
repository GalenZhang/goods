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
 * GoodsClass entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="goods_class",catalog="goods")
public class GoodsClass implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5964346121772321874L;
	
	@GenericGenerator(name="generator",strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	private Integer id;
	
	@Column(name="class_name")
	private String className;

	// Constructors

	/** default constructor */
	public GoodsClass() {
	}

	/** minimal constructor */
	public GoodsClass(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public GoodsClass(Integer id, String className) {
		this.id = id;
		this.className = className;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}