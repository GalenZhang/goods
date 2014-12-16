package com.sofans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sofans.entity.IBean;

/**
 * 
 */

@Entity
@Table(name="sofans_op_agent_type",catalog="ssop")
public class SofansSysAgentType implements IBean {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6856907876437109619L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String agentType;

	// Constructors

	/** default constructor */
	public SofansSysAgentType() {
	}

	/** full constructor */
	public SofansSysAgentType(String agentType) {
		this.agentType = agentType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgentType() {
		return this.agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

}