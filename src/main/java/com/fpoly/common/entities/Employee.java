package com.fpoly.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="STAFF")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name="NAMESTAFF")
	private String nameStaff;
	
	@Column(name="GENDER")
	private boolean gender;
	
	@Column(name="BIRTHDAY")
	private String birthday;
	
	@Column(name="PHOTO")
	private String photo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="SALARY")
	private float salary;
	
	@Column(name="NOTES")
	private String note;
	
	@Column(name="DEPARTID")
	private Long idDepart;
	
	@ManyToOne
	@JoinColumn(name="DEPARTID",insertable=false, updatable=false)
	private Department department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public Long getIdDepart() {
		return idDepart;
	}

	public void setIdDepart(Long idDepart) {
		this.idDepart = idDepart;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
