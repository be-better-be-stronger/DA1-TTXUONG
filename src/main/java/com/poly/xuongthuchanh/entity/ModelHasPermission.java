package com.poly.xuongthuchanh.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the model_has_permissions database table.
 * 
 */
@Entity
@Table(name="model_has_permissions")
@NamedQuery(name="ModelHasPermission.findAll", query="SELECT m FROM ModelHasPermission m")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelHasPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ModelHasPermissionPK id;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	private Permission permission;

}