package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * The persistent class for the bookmark database table.
 * 
 */
@Entity
@NamedQuery(name="Bookmark.findAll", query="SELECT b FROM Bookmark b")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="task_id")
	private int taskId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="user_has_task_id")
	private int userHasTaskId;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;


	
}