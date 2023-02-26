package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name="permissions")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
@AllArgsConstructor
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="display_name")
	private String displayName;

	@Column(name="guard_name")
	private String guardName;

	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to ModelHasPermission
	@OneToMany(mappedBy="permission")
	private List<ModelHasPermission> modelHasPermissions;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="permissions")
	private List<Role> roles;

	public Permission() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getGuardName() {
		return this.guardName;
	}

	public void setGuardName(String guardName) {
		this.guardName = guardName;
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

	public List<ModelHasPermission> getModelHasPermissions() {
		return this.modelHasPermissions;
	}

	public void setModelHasPermissions(List<ModelHasPermission> modelHasPermissions) {
		this.modelHasPermissions = modelHasPermissions;
	}

	public ModelHasPermission addModelHasPermission(ModelHasPermission modelHasPermission) {
		getModelHasPermissions().add(modelHasPermission);
		modelHasPermission.setPermission(this);

		return modelHasPermission;
	}

	public ModelHasPermission removeModelHasPermission(ModelHasPermission modelHasPermission) {
		getModelHasPermissions().remove(modelHasPermission);
		modelHasPermission.setPermission(null);

		return modelHasPermission;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}