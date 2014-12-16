package com.sofans.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * 
 * 员工类
 * 
 */

@Entity
@Table(name = "sofans_op_employee", catalog = "ssop")
public class SofansSysEmployee implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6879676263746942756L;

	@Id
	@GeneratedValue
	private Integer id;
	// 职位 ID
	@Column(name = "post_id")
	private Integer postId;
	// 部门ID
	@Column(name = "dept_id")
	private Integer deptId;
	@Column(name = "worker_num")
	private String workerNum;
	private String name;
	private Short sex;
	private Integer age;
	@Column(name = "id_card")
	private String idCard;
	private Date birthday;
	private String education;
	@Column(name = "hometow_address")
	private String hometowAddress;
	private String address;
	private String phone;
	private String email;
	@Column(name = "entry_worktime")
	private Date entryWorktime;

	// Constructors

	/** default constructor */
	public SofansSysEmployee() {
	}

	/** minimal constructor */
	public SofansSysEmployee(Integer postId, Integer deptId, String name,
			Short sex, String hometowAddress, String address, String phone,
			String email, Date entryWorktime) {
		this.postId = postId;
		this.deptId = deptId;
		this.name = name;
		this.sex = sex;
		this.hometowAddress = hometowAddress;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.entryWorktime = entryWorktime;
	}

	/** full constructor */
	public SofansSysEmployee(Integer postId, Integer deptId, String workerNum,
			String name, Short sex, Integer age, String idCard, Date birthday,
			String education, String hometowAddress, String address,
			String phone, String email, Date entryWorktime) {
		this.postId = postId;
		this.deptId = deptId;
		this.workerNum = workerNum;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.idCard = idCard;
		this.birthday = birthday;
		this.education = education;
		this.hometowAddress = hometowAddress;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.entryWorktime = entryWorktime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getWorkerNum() {
		return this.workerNum;
	}

	public void setWorkerNum(String workerNum) {
		this.workerNum = workerNum;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHometowAddress() {
		return this.hometowAddress;
	}

	public void setHometowAddress(String hometowAddress) {
		this.hometowAddress = hometowAddress;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEntryWorktime() {
		return this.entryWorktime;
	}

	public void setEntryWorktime(Date entryWorktime) {
		this.entryWorktime = entryWorktime;
	}

}