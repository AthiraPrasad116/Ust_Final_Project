package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bean.UstVenderContacts;

public class UstDao implements IUstDao {

	JdbcTemplate template;

	/* (non-Javadoc)
	 * @see com.dao.IUstDao#getTemplate()
	 */
	@Override
	public JdbcTemplate getTemplate() {
		return template;
	}

	/* (non-Javadoc)
	 * @see com.dao.IUstDao#setTemplate(org.springframework.jdbc.core.JdbcTemplate)
	 */
	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//LOGIN
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#Login(java.lang.String, java.lang.String)
	 */
	@Override
	public UstVenderContacts Login(String username, String password) {
		  
		String sql = "select userid, username , password from UstLogin where username = ? and password = ?";
		UstVenderContacts ad= template.queryForObject(sql,
				new Object[] { username, password },
				new BeanPropertyRowMapper<UstVenderContacts>(UstVenderContacts.class));
		return ad;
	}
	
	
	
	//GETTING ALL LIST OF VENDERS AND CORRESPONDING CONTACT DETAILS
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#VenderList()
	 */
	@Override
	public List<UstVenderContacts> VenderList() {
		return template.query(
				"select venderId,venderName,address,location,service,pincode,isActive,contactId,contName,department,email,phoneNo from VenderTable join ContactDetails using (venderId) where isActive='yes'",
				new RowMapper<UstVenderContacts>() {
					
					public UstVenderContacts mapRow(ResultSet rs, int row) throws SQLException {
						
						UstVenderContacts ust = new UstVenderContacts();
						ust.setVenderId(rs.getInt(1));
						ust.setVenderName(rs.getString(2));
						ust.setAddress(rs.getString(3));
						ust.setLocation(rs.getString(4));
						ust.setService(rs.getString(5));
						ust.setPincode(rs.getString(6));
						ust.setIsActive(rs.getString(7));
						ust.setContactId(rs.getInt(8));
						ust.setContName(rs.getString(9));
						ust.setDepartment(rs.getString(10));
						ust.setEmail(rs.getString(11));
						ust.setPhoneNo(rs.getString(12));
						
						return ust;

					}
				});
	}
	
	

//GETTING ALL LIST OF VENDERS AND CONTACT DETAILS BY ID 
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#VenderListById(int)
	 */
	@Override
	public List<UstVenderContacts> VenderListById(int venderId) {
		return template.query(
				"select venderId,venderName,address,location,service,pincode,isActive,contactId,contName,department,email,phoneNo from VenderTable join ContactDetails using (venderId) where venderId="+venderId+"",
				new RowMapper<UstVenderContacts>() {					
					public UstVenderContacts mapRow(ResultSet rs, int row) throws SQLException {
						
						UstVenderContacts ust = new UstVenderContacts();
						ust.setVenderId(rs.getInt(1));
						ust.setVenderName(rs.getString(2));
						ust.setAddress(rs.getString(3));
						ust.setLocation(rs.getString(4));
						ust.setService(rs.getString(5));
						ust.setPincode(rs.getString(6));
						ust.setIsActive(rs.getString(7));
						ust.setContactId(rs.getInt(8));
						ust.setContName(rs.getString(9));
						ust.setDepartment(rs.getString(10));
						ust.setEmail(rs.getString(11));
						ust.setPhoneNo(rs.getString(12));
						
						return ust;

					}
				});
	}
	
	//INSERTING INTO VENDER TABLE
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#insertVender(com.bean.UstVenderContacts)
	 */
	@Override
	public int insertVender(UstVenderContacts ust)
	{
	
		String sql = "insert into VenderTable(venderName,address,location,service,pincode,isActive) values('"
				+ust.getVenderName()
				+ "','"
				+ ust.getAddress()
				+ "','"
				+ ust.getLocation()
				+ "','"
				+ ust.getService()
				+ "','"
				+ ust.getPincode()
				+ "','yes')";

	if(template.update(sql)!=0)
	{

	return insertContact(ust);
	}
	else
	{
	return 0;
	}

	}

	//GETTING MAX(ID) FOR INSERTING DATA INTO CONTACT TABLE

	/* (non-Javadoc)
	 * @see com.dao.IUstDao#insertContact(com.bean.UstVenderContacts)
	 */
	@Override
	public int insertContact(UstVenderContacts ust)
	{
	String sql="select max(venderId) from VenderTable";
	int venderId=template.queryForObject(sql, Integer.class);

	String sql2="insert into ContactDetails(contactId,contName,venderId,department,email,phoneNo) values(?,?,?,?,?,?)";

	return template.update(sql2,new Object[]{ust.getContactId(),ust.getContName(),venderId,ust.getDepartment(),ust.getEmail(),ust.getPhoneNo()});
	}
	
	
	
	//UPDATE VENDER DETAILS AND CONTACT DETAILS
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#updateVender(com.bean.UstVenderContacts)
	 */
	@Override
	public Integer updateVender(UstVenderContacts ust) {
		
		//VENDER TABLE
		String sql = "update VenderTable set venderName =? ,address=? ,location=? ,service=? ,pincode=? ,isActive=? where venderId=?";

		template.update(sql,new Object[]{ust.getVenderName(),ust.getAddress(),ust.getLocation(),ust.getService(),ust.getPincode(),ust.getIsActive(),ust.getVenderId()});		

		
		 //CONTACTdETAILS TABLE
		String sql1 = "update  ContactDetails set contName=? ,department=? ,email=? ,phoneNo=? where venderId=?";

		return template.update(sql1,new Object[]{ust.getContName(),ust.getDepartment(),ust.getEmail(),ust.getPhoneNo(),ust.getVenderId()});

		}
	
	//DISABLE VENDER
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#disableVender(int)
	 */
	@Override
	public int disableVender(int venderId) {
		String sql = "update VenderTable set isActive = 'no' where venderId = ?";
		return template.update(sql,new Object[]{venderId});
	}
	
	
	//SEARCH BY LOCATION,NAME,NATURE OF SERVICE
	
	/* (non-Javadoc)
	 * @see com.dao.IUstDao#venderSearch(java.lang.String)
	 */
	@Override
	public List<UstVenderContacts> venderSearch(String searchString) {
		   return template
		   .query("select venderId,venderName,address,location,service,pincode,isActive,contactId,contName,department,email,phoneNo from VenderTable join ContactDetails using (venderId) where location= '"
		   + searchString + "' or venderName='" + searchString +"' or service='" + searchString + "'",
		   new RowMapper<UstVenderContacts>() {
				
				public UstVenderContacts mapRow(ResultSet rs, int row) throws SQLException {
					
					UstVenderContacts ust = new UstVenderContacts();
					ust.setVenderId(rs.getInt(1));
					ust.setVenderName(rs.getString(2));
					ust.setAddress(rs.getString(3));
					ust.setLocation(rs.getString(4));
					ust.setService(rs.getString(5));
					ust.setPincode(rs.getString(6));
					ust.setIsActive(rs.getString(7));
					ust.setContactId(rs.getInt(8));
					ust.setContName(rs.getString(9));
					ust.setDepartment(rs.getString(10));
					ust.setEmail(rs.getString(11));
					ust.setPhoneNo(rs.getString(12));
					
					return ust;

				}
		   });

		   }
}
