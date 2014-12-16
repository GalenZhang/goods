package com.sofans.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * SofansOpTablet entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="sofans_op_tablet")
public class SofansSysTablet implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6439127470642716766L;
	@Id
	@GeneratedValue
	private Integer id;
	private String imei;
	@Column(name="code_id")
	private Integer codeId;
	@Column(name="order_id")
	private Integer orderId;
	@Column(name="tablet_type")
	private String tabletType;
	private Timestamp activationtime;
	@Column(name="last_activationtime")
	private Timestamp lastActivationtime;

	// Constructors

	/** default constructor */
	public SofansSysTablet() {
	}

	/** full constructor */
	public SofansSysTablet(String imei, Integer codeId, Integer orderId,
			String tabletType, Timestamp activationtime,
			Timestamp lastActivationtime) {
		this.imei = imei;
		this.codeId = codeId;
		this.orderId = orderId;
		this.tabletType = tabletType;
		this.activationtime = activationtime;
		this.lastActivationtime = lastActivationtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Integer getCodeId() {
		return this.codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTabletType() {
		return this.tabletType;
	}

	public void setTabletType(String tabletType) {
		this.tabletType = tabletType;
	}

	public Timestamp getActivationtime() {
		return this.activationtime;
	}

	public void setActivationtime(Timestamp activationtime) {
		this.activationtime = activationtime;
	}

	public Timestamp getLastActivationtime() {
		return this.lastActivationtime;
	}

	public void setLastActivationtime(Timestamp lastActivationtime) {
		this.lastActivationtime = lastActivationtime;
	}

}