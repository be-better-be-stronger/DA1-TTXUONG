package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the mail_notification database table.
 * 
 */
@Entity
@Table(name="mail_notification")
@NamedQuery(name="MailNotification.findAll", query="SELECT m FROM MailNotification m")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Lob
	private String data;

	private int executed;

	@Column(name="receiver_id")
	private int receiverId;

	@Column(name="sender_id")
	private int senderId;

	@Column(name="type_id")
	private int typeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

}