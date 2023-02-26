package com.poly.xuongthuchanh.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the migrations database table.
 * 
 */
@Entity
@Table(name="migrations")
@NamedQuery(name="Migration.findAll", query="SELECT m FROM Migration m")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Migration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int batch;

	private String migration;

}