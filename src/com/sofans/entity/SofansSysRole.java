package com.sofans.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SufansSysRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sofans_sys_role", catalog = "ssop")
public class SofansSysRole implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4762532618269269005L;
	private Integer id;
	private String rolename;
	private Timestamp createtime;
	private Short enabled;

	// Constructors

	/** default constructor */
	public SofansSysRole() {
	}

	/** full constructor */
	public SofansSysRole(String rolename, Timestamp createtime, Short enabled) {
		this.rolename = rolename;
		this.createtime = createtime;
		this.enabled = enabled;
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

	@Column(name = "rolename", nullable = false, length = 100)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	@Column(name = "enabled", nullable = false)
	public Short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

}