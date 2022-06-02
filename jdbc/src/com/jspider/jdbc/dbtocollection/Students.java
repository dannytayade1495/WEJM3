package com.jspider.jdbc.dbtocollection;

public class Students {

	int studentId;
	String studentName;
	String emailId;
	long phoneNumber;
	String address;

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

}
