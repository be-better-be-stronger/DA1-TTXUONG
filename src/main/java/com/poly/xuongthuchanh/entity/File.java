package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * The persistent class for the file database table.
 * 
 */
@Entity
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="fileable_id")
	private int fileableId;

	@Column(name="fileable_type")
	private String fileableType;

	private String name;

	@Lob
	private String path;

	private int size;

	@Lob
	private String type;

	@Column(name="updated_at")
	private Timestamp updatedAt;

}