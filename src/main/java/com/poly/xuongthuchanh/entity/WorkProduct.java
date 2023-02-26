package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the work_product database table.
 * 
 */
@Entity
@Table(name="work_product")
@NamedQuery(name="WorkProduct.findAll", query="SELECT w FROM WorkProduct w")
@AllArgsConstructor
public class WorkProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="auto_join")
	private byte autoJoin;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private int createdBy;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="due_time")
	private Date dueTime;

	@Column(name="file_id")
	private int fileId;

	@Column(name="limit_join")
	private int limitJoin;

	private String name;

	private String note;

	@Column(name="poly_coin")
	private int polyCoin;

	@Column(name="project_id")
	private int projectId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	private int status;

	@Column(name="task_priority_id")
	private int taskPriorityId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="workProduct")
	private List<Project> projects;

	//bi-directional many-to-one association to UserHasWorkProduct
	@OneToMany(mappedBy="workProduct")
	private List<UserHasWorkProduct> userHasWorkProducts;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	private Comment comment;

	public WorkProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAutoJoin() {
		return this.autoJoin;
	}

	public void setAutoJoin(byte autoJoin) {
		this.autoJoin = autoJoin;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueTime() {
		return this.dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getLimitJoin() {
		return this.limitJoin;
	}

	public void setLimitJoin(int limitJoin) {
		this.limitJoin = limitJoin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getPolyCoin() {
		return this.polyCoin;
	}

	public void setPolyCoin(int polyCoin) {
		this.polyCoin = polyCoin;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTaskPriorityId() {
		return this.taskPriorityId;
	}

	public void setTaskPriorityId(int taskPriorityId) {
		this.taskPriorityId = taskPriorityId;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setWorkProduct(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setWorkProduct(null);

		return project;
	}

	public List<UserHasWorkProduct> getUserHasWorkProducts() {
		return this.userHasWorkProducts;
	}

	public void setUserHasWorkProducts(List<UserHasWorkProduct> userHasWorkProducts) {
		this.userHasWorkProducts = userHasWorkProducts;
	}

	public UserHasWorkProduct addUserHasWorkProduct(UserHasWorkProduct userHasWorkProduct) {
		getUserHasWorkProducts().add(userHasWorkProduct);
		userHasWorkProduct.setWorkProduct(this);

		return userHasWorkProduct;
	}

	public UserHasWorkProduct removeUserHasWorkProduct(UserHasWorkProduct userHasWorkProduct) {
		getUserHasWorkProducts().remove(userHasWorkProduct);
		userHasWorkProduct.setWorkProduct(null);

		return userHasWorkProduct;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}