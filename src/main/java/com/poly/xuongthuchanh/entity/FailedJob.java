package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * The persistent class for the failed_jobs database table.
 * 
 */
@Entity
@Table(name="failed_jobs")
@NamedQuery(name="FailedJob.findAll", query="SELECT f FROM FailedJob f")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class FailedJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	private String connection;

	@Lob
	private String exception;

	@Column(name="failed_at")
	private Timestamp failedAt;

	@Lob
	private String payload;

	@Lob
	private String queue;

	private String uuid;


}