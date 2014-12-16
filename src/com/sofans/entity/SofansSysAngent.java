package com.sofans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * 
 */

@Entity
@Table(name="sofans_op_angent",catalog="ssop")
public class SofansSysAngent implements IBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8554989773500784823L;
	// Fields

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="agent_tppe_id")
	private Integer agentTppeId;
	private String name;
	private Short sex;
	private Short age;
	private String phone;
	private String tel;
	private String company;
	private String address;
	private Integer emp_id;
	


	// Constructors

	/** default constructor */
	public SofansSysAngent() {
	}

	/** minimal constructor */
	public SofansSysAngent(Integer agentTppeId, String name,
			String phone, String address, Integer emp_id) {
		this.agentTppeId = agentTppeId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.emp_id = emp_id;
	}

	/** full constructor */
	public SofansSysAngent(Integer agentTppeId, String name, Short sex,
			Short age, String phone, String tel, String company, String address, Integer emp_id) {
		this.agentTppeId = agentTppeId;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.tel = tel;
		this.company = company;
		this.address = address;
		this.emp_id = emp_id;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAgentTppeId() {
		return this.agentTppeId;
	}

	public void setAgentTppeId(Integer agentTppeId) {
		this.agentTppeId = agentTppeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	
	

}