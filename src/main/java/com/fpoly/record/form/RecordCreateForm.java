package com.fpoly.record.form;

public class RecordCreateForm {
	private Long id;
	private Long idStaff;
	private boolean type;
	private String date;
	private String reason;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(Long idStaff) {
		this.idStaff = idStaff;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
