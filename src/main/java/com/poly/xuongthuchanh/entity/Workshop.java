package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the workshop database table.
 * 
 */
@Entity
@NamedQuery(name="Workshop.findAll", query="SELECT w FROM Workshop w")
@AllArgsConstructor
public class Workshop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String name;

	@Column(name="specialization_id")
	private String specializationId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="workshop_manager_id")
	private int workshopManagerId;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="workshop")
	private List<User> users;

	public Workshop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecializationId() {
		return this.specializationId;
	}

	public void setSpecializationId(String specializationId) {
		this.specializationId = specializationId;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getWorkshopManagerId() {
		return this.workshopManagerId;
	}

	public void setWorkshopManagerId(int workshopManagerId) {
		this.workshopManagerId = workshopManagerId;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setWorkshop(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setWorkshop(null);

		return user;
	}

}