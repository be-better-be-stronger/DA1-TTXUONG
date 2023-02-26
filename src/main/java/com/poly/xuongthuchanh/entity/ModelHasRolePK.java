package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The primary key class for the model_has_roles database table.
 * 
 */
@Embeddable
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelHasRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="role_id", insertable=false, updatable=false)
	private long roleId;

	@Column(name="model_id")
	private long modelId;

	@Column(name="model_type")
	private String modelType;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ModelHasRolePK)) {
			return false;
		}
		ModelHasRolePK castOther = (ModelHasRolePK)other;
		return 
			(this.roleId == castOther.roleId)
			&& (this.modelId == castOther.modelId)
			&& this.modelType.equals(castOther.modelType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.roleId ^ (this.roleId >>> 32)));
		hash = hash * prime + ((int) (this.modelId ^ (this.modelId >>> 32)));
		hash = hash * prime + this.modelType.hashCode();
		
		return hash;
	}
}