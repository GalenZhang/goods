package com.sofans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SufansSysAction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sofans_sys_action", catalog = "ssop")
public class SofansSysAction implements IBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 582799920091191557L;
	// Fields

	private Integer id;
	private String actionname;

	// Constructors

	/** default constructor */
	public SofansSysAction() {
	}

	/** full constructor */
	public SofansSysAction(String actionname) {
		this.actionname = actionname;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "actionname", nullable = false, length = 50)
	public String getActionname() {
		return this.actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

}