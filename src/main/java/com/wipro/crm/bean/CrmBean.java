package com.wipro.crm.bean;

import java.sql.Date;

public class CrmBean {

	public String recordId;
	public String customerName;
	public String email;
	public String phone;
	public  Date joinDate;
	public String status;
	public String remarks;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "CrmBean [recordId=" + recordId + ", customerName=" + customerName + ", email=" + email + ", phone="
				+ phone + ", joinDate=" + joinDate + ", status=" + status + ", remarks=" + remarks + "]";
	}

}
