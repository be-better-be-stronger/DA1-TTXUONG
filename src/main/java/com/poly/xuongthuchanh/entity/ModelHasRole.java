package com.poly.xuongthuchanh.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the model_has_roles database table.
 * 
 */
@Entity
@Table(name="model_has_roles")
@NamedQuery(name="ModelHasRole.findAll", query="SELECT m FROM ModelHasRole m")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelHasRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ModelHasRolePK id;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;


}