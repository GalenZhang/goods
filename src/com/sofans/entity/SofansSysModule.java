package com.sofans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SufansSysModule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sofans_sys_module", catalog = "ssop")
public class SofansSysModule implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6950633087135253548L;
	private Integer id;
	private String modulename;
	private String url;

	// Constructors

	/** default constructor */
	public SofansSysModule() {
	}

	/** full constructor */
	public SofansSysModule(String modulename, String url) {
		this.modulename = modulename;
		this.url = url;
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

	@Column(name = "modulename", nullable = false, length = 0)
	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	@Column(name = "url", nullable = false, length = 0)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}