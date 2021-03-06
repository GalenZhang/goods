package com.sofans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SufansSysUserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sofans_sys_user_role", catalog = "ssop")
public class SofansSysUserRole implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8357984378037886387L;
	private Integer id;
	private Integer userid;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public SofansSysUserRole() {
	}

	/** full constructor */
	public SofansSysUserRole(Integer userid, Integer roleid) {
		this.userid = userid;
		this.roleid = roleid;
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

	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "roleid", nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}