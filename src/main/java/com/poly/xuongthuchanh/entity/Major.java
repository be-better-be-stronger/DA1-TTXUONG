package com.poly.xuongthuchanh.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the major database table.
 * 
 */
@Entity
@NamedQuery(name="Major.findAll", query="SELECT m FROM Major m")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Major implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="name")
	private User user;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="major")
	private List<Project> projects;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="major")
	private List<User> users;
}