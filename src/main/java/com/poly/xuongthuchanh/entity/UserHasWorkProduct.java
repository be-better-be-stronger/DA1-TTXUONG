package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;


/**
 * The persistent class for the user_has_work_product database table.
 * 
 */
@Entity
@Table(name="user_has_work_product")
@NamedQuery(name="UserHasWorkProduct.findAll", query="SELECT u FROM UserHasWorkProduct u")
@AllArgsConstructor
public class UserHasWorkProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String note;

	private float point;

	@Column(name="submited_at")
	private Timestamp submitedAt;

	@Column(name="task_status_id")
	private int taskStatusId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to WorkProduct
	@ManyToOne
	private WorkProduct workProduct;

	public UserHasWorkProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getPoint() {
		return this.point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public Timestamp getSubmitedAt() {
		return this.submitedAt;
	}

	public void setSubmitedAt(Timestamp submitedAt) {
		this.submitedAt = submitedAt;
	}

	public int getTaskStatusId() {
		return this.taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WorkProduct getWorkProduct() {
		return this.workProduct;
	}

	public void setWorkProduct(WorkProduct workProduct) {
		this.workProduct = workProduct;
	}

}