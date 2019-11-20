package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UstVenderContacts;
import com.dao.IUstDao;

@RestController
public class UstController {

	@Autowired
	IUstDao uDao;

	
	//LOGIN 
	
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public UstVenderContacts loginUstVender(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		return uDao.Login(username, password);
	}
	
	
	//GET ALL VENDER DETAILS
	
	@RequestMapping(value= "/api/viewVenders", method = RequestMethod.GET)
	public List<UstVenderContacts> getAllVenders(){
		List venderList = uDao.VenderList();
		return venderList;
	}
	
	//GET ALL VENDER DETAILS BY ID
	
	@RequestMapping(value = "/api/getVenderByid/{venderId}", method = RequestMethod.GET , produces = "application/json")
	public UstVenderContacts getVenderById(@ModelAttribute("vender") UstVenderContacts vender,@PathVariable("venderId") int venderId) 
	{
	List eachVenderList=uDao.VenderListById(venderId);
	vender=(UstVenderContacts)eachVenderList.get(0);
	return  vender;
	}
	
	//INSERT INTO VENDER TABLE AND CONTACT DETAILS
	
	@RequestMapping(value = "/api/insertVender",method = {RequestMethod.POST ,RequestMethod.PUT})
	public void venderInsert(@RequestBody UstVenderContacts ust)
	{
		//INSERT
		if(ust.getVenderId() == 0){
				uDao.insertVender(ust);
		}
		//UPDATE
		else{
		        uDao.updateVender(ust);
		}
	}
	
	//DISABLE VENDER
	
	@RequestMapping(value = "/api/disableVender/{venderId}", method = RequestMethod.PUT)
	public void VenderDisable(@PathVariable("venderId") int venderId) 
	{
	uDao.disableVender(venderId);
	}
	
	//SEARCH BY LOCATION,NAME,NATURE OF SERVICE
	
	@RequestMapping(value="/vendersearch/{searchString}",headers="Accept=Application/json",method = RequestMethod.GET)
	public List viewVenderSearch(@PathVariable("searchString")String searchString) 
	{
		List venderList = uDao.venderSearch(searchString);
		return venderList;
	}
	
	
	
	
}
