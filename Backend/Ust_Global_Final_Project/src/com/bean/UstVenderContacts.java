package com.bean;

public class UstVenderContacts {
	
	private int userid;
	private String username;
	private String password;
	private int venderId;
	private String venderName;
	private String address;
	private String location;
	private String service;
	private String pincode;
	private String isActive;
	private int contactId;
	private String contName;
	private String department;
	private String email;
	private String phoneNo;
	
	
	
	//getters and setters
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getVenderId() {
		return venderId;
	}
	public void setVenderId(int venderId) {
		this.venderId = venderId;
	}
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	//default constructor using superclass
	public UstVenderContacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// constructor using fields
	public UstVenderContacts(int userid, String username, String password,
			int venderId, String venderName, String address, String location,
			String service, String pincode, String isActive, int contactId,
			String contName, String department, String email, String phoneNo) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.venderId = venderId;
		this.venderName = venderName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
		this.contactId = contactId;
		this.contName = contName;
		this.department = department;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	
	//overriding toString function
	@Override
	public String toString() {
		return "UstVenderContacts [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", venderId=" + venderId
				+ ", venderName=" + venderName + ", address=" + address
				+ ", location=" + location + ", service=" + service
				+ ", pincode=" + pincode + ", isActive=" + isActive
				+ ", contactId=" + contactId + ", contName=" + contName
				+ ", department=" + department + ", email=" + email
				+ ", phoneNo=" + phoneNo + "]";
	}

}
