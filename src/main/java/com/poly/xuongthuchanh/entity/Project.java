package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
@AllArgsConstructor
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="created_by")
	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_at")
	private Date deletedAt;

	@Temporal(TemporalType.DATE)
	@Column(name="end_time")
	private Date endTime;

	private String files;

	@Column(name="level_id")
	private int levelId;

	private String name;

	private String note;

	@Column(name="owner_name")
	private String ownerName;

	@Column(name="poly_coin")
	private int polyCoin;

	private String semester;

	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	private Date startTime;

	private int status;

	@Column(name="time_work")
	private int timeWork;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-one association to Bookmark
	@OneToMany(mappedBy="project")
	private List<Bookmark> bookmarks;

	//bi-directional many-to-one association to Major
	@ManyToOne
	private Major major;

	//bi-directional many-to-one association to UserHasProject
	@OneToMany(mappedBy="project")
	private List<UserHasProject> userHasProjects;

	//bi-directional many-to-one association to WorkProduct
	@ManyToOne
	@JoinColumn(name="work_product_id")
	private WorkProduct workProduct;

	public Project() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFiles() {
		return this.files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int getLevelId() {
		return this.levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
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

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getPolyCoin() {
		return this.polyCoin;
	}

	public void setPolyCoin(int polyCoin) {
		this.polyCoin = polyCoin;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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

	public int getTimeWork() {
		return this.timeWork;
	}

	public void setTimeWork(int timeWork) {
		this.timeWork = timeWork;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Bookmark> getBookmarks() {
		return this.bookmarks;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public Bookmark addBookmark(Bookmark bookmark) {
		getBookmarks().add(bookmark);
		bookmark.setProject(this);

		return bookmark;
	}

	public Bookmark removeBookmark(Bookmark bookmark) {
		getBookmarks().remove(bookmark);
		bookmark.setProject(null);

		return bookmark;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<UserHasProject> getUserHasProjects() {
		return this.userHasProjects;
	}

	public void setUserHasProjects(List<UserHasProject> userHasProjects) {
		this.userHasProjects = userHasProjects;
	}

	public UserHasProject addUserHasProject(UserHasProject userHasProject) {
		getUserHasProjects().add(userHasProject);
		userHasProject.setProject(this);

		return userHasProject;
	}

	public UserHasProject removeUserHasProject(UserHasProject userHasProject) {
		getUserHasProjects().remove(userHasProject);
		userHasProject.setProject(null);

		return userHasProject;
	}

	public WorkProduct getWorkProduct() {
		return this.workProduct;
	}

	public void setWorkProduct(WorkProduct workProduct) {
		this.workProduct = workProduct;
	}

}