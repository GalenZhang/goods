package com.sofans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * 
 * 部门表
 * 
 */


@Entity
@Table(name="sofans_op_department",catalog="ssop")
public class SofansSysDepartment implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8152807888542874120L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String departmentName;

	// Constructors

	/** default constructor */
	public SofansSysDepartment() {
	}

	/** full constructor */
	public SofansSysDepartment(String departmentName) {
		this.departmentName = departmentName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}