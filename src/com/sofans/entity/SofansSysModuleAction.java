package com.sofans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SufansSysModuleAction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sofans_sys_module_action", catalog = "ssop")
public class SofansSysModuleAction implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520099155766711198L;
	private Integer id;
	private Integer moduleid;
	private Integer actionid;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public SofansSysModuleAction() {
	}

	/** full constructor */
	public SofansSysModuleAction(Integer moduleid, Integer actionid,
			Integer roleid) {
		this.moduleid = moduleid;
		this.actionid = actionid;
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

	@Column(name = "moduleid", nullable = false)
	public Integer getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	@Column(name = "actionid", nullable = false)
	public Integer getActionid() {
		return this.actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

	@Column(name = "roleid", nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}