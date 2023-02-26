package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;


/**
 * The persistent class for the work_product_priority database table.
 * 
 */
@Entity
@Table(name="work_product_priority")
@NamedQuery(name="WorkProductPriority.findAll", query="SELECT w FROM WorkProductPriority w")
@AllArgsConstructor
public class WorkProductPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	public WorkProductPriority() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}