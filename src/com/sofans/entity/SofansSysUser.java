package com.sofans.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SufansSysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sofans_sys_user", catalog = "ssop")
public class SofansSysUser implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 504200992331340545L;
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private Timestamp createtime;
	private Short enabled;
	private Integer emp_id;

	// Constructors

	/** default constructor */
	public SofansSysUser() {
	}

	/** minimal constructor */
	public SofansSysUser(String name, String password, String email,
			Timestamp createtime, Short enabled, Integer emp_id) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.createtime = createtime;
		this.enabled = enabled;
		this.emp_id = emp_id;
	}

	/** full constructor */
	public SofansSysUser(String name, String password, String email,
			String phone, Timestamp createtime, Short enabled, Integer emp_id) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createtime = createtime;
		this.enabled = enabled;
		this.emp_id = emp_id;
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

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	

}