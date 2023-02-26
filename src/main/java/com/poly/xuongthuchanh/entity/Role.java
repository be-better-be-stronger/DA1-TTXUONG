package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
@AllArgsConstructor
public class Role implements Serializable {
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

	//bi-directional many-to-one association to ModelHasRole
	@OneToMany(mappedBy="role")
	private List<ModelHasRole> modelHasRoles;

	//bi-directional many-to-many association to Permission
	@ManyToMany
	@JoinTable(
		name="role_has_permissions"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permission_id")
			}
		)
	private List<Permission> permissions;

	public Role() {
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

	public List<ModelHasRole> getModelHasRoles() {
		return this.modelHasRoles;
	}

	public void setModelHasRoles(List<ModelHasRole> modelHasRoles) {
		this.modelHasRoles = modelHasRoles;
	}

	public ModelHasRole addModelHasRole(ModelHasRole modelHasRole) {
		getModelHasRoles().add(modelHasRole);
		modelHasRole.setRole(this);

		return modelHasRole;
	}

	public ModelHasRole removeModelHasRole(ModelHasRole modelHasRole) {
		getModelHasRoles().remove(modelHasRole);
		modelHasRole.setRole(null);

		return modelHasRole;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}