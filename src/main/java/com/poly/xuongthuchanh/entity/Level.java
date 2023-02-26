package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * The persistent class for the level database table.
 * 
 */
@Entity
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	private String name;

	@Column(name="updated_at")
	private String updatedAt;

}