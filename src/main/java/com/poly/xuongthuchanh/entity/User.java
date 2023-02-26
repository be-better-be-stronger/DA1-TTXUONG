package com.poly.xuongthuchanh.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String avatar;

	@Column(name="course_name")
	private String courseName;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="CURRENT_CONNECTIONS")
	private BigInteger currentConnections;

	private String email;

	@Column(name="google_id")
	private String googleId;

	private String name;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="role_id")
	private int roleId;

	@Column(name="student_code")
	private String studentCode;

	@Column(name="teacher_code")
	private String teacherCode;

	@Column(name="TOTAL_CONNECTIONS")
	private BigInteger totalConnections;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_at")
	private Date updatedAt;

	private String user;

	//bi-directional many-to-one association to Major
	@OneToMany(mappedBy="user")
	private List<Major> majors;

	//bi-directional many-to-one association to UserHasProject
	@OneToMany(mappedBy="user")
	private List<UserHasProject> userHasProjects;

	//bi-directional many-to-one association to Major
	@ManyToOne
	private Major major;

	//bi-directional many-to-one association to UserHasWorkProduct
	@OneToMany(mappedBy="user")
	private List<UserHasWorkProduct> userHasWorkProducts;

	//bi-directional many-to-one association to Workshop
	@ManyToOne
	@JoinColumn(name="major_id")
	private Workshop workshop;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigInteger getCurrentConnections() {
		return this.currentConnections;
	}

	public void setCurrentConnections(BigInteger currentConnections) {
		this.currentConnections = currentConnections;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGoogleId() {
		return this.googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getTeacherCode() {
		return this.teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public BigInteger getTotalConnections() {
		return this.totalConnections;
	}

	public void setTotalConnections(BigInteger totalConnections) {
		this.totalConnections = totalConnections;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Major> getMajors() {
		return this.majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public Major addMajor(Major major) {
		getMajors().add(major);
		major.setUser(this);

		return major;
	}

	public Major removeMajor(Major major) {
		getMajors().remove(major);
		major.setUser(null);

		return major;
	}

	public List<UserHasProject> getUserHasProjects() {
		return this.userHasProjects;
	}

	public void setUserHasProjects(List<UserHasProject> userHasProjects) {
		this.userHasProjects = userHasProjects;
	}

	public UserHasProject addUserHasProject(UserHasProject userHasProject) {
		getUserHasProjects().add(userHasProject);
		userHasProject.setUser(this);

		return userHasProject;
	}

	public UserHasProject removeUserHasProject(UserHasProject userHasProject) {
		getUserHasProjects().remove(userHasProject);
		userHasProject.setUser(null);

		return userHasProject;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<UserHasWorkProduct> getUserHasWorkProducts() {
		return this.userHasWorkProducts;
	}

	public void setUserHasWorkProducts(List<UserHasWorkProduct> userHasWorkProducts) {
		this.userHasWorkProducts = userHasWorkProducts;
	}

	public UserHasWorkProduct addUserHasWorkProduct(UserHasWorkProduct userHasWorkProduct) {
		getUserHasWorkProducts().add(userHasWorkProduct);
		userHasWorkProduct.setUser(this);

		return userHasWorkProduct;
	}

	public UserHasWorkProduct removeUserHasWorkProduct(UserHasWorkProduct userHasWorkProduct) {
		getUserHasWorkProducts().remove(userHasWorkProduct);
		userHasWorkProduct.setUser(null);

		return userHasWorkProduct;
	}

	public Workshop getWorkshop() {
		return this.workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

}