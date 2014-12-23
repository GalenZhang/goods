package com.struts.entity;
// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sofans.entity.IBean;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="comment",catalog="goods")
public class Comment implements IBean {

	// Fields

	private static final long serialVersionUID = -6767998130575999661L;
	private Integer id;
	private Integer goodsId;
	private Integer userId;
	private String comment;
	private Integer commentRank;
	private Timestamp commentData;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer id, Timestamp commentData) {
		this.id = id;
		this.commentData = commentData;
	}

	/** full constructor */
	public Comment(Integer id, Integer goodsId, Integer userId, String comment,
			Integer commentRank, Timestamp commentData) {
		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.comment = comment;
		this.commentRank = commentRank;
		this.commentData = commentData;
	}

	// Property accessors

	@GenericGenerator(name="generator", strategy="increment")
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="goods_id")
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name="user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name="comment_rank")
	public Integer getCommentRank() {
		return this.commentRank;
	}

	public void setCommentRank(Integer commentRank) {
		this.commentRank = commentRank;
	}

	@Column(name="comment_data")
	public Timestamp getCommentData() {
		return this.commentData;
	}

	public void setCommentData(Timestamp commentData) {
		this.commentData = commentData;
	}

}