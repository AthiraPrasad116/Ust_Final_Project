package com.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.UstVenderContacts;

public interface IUstDao {

	public abstract JdbcTemplate getTemplate();

	public abstract void setTemplate(JdbcTemplate template);

	public abstract UstVenderContacts Login(String username, String password);

	public abstract List<UstVenderContacts> VenderList();

	public abstract List<UstVenderContacts> VenderListById(int venderId);

	public abstract int insertVender(UstVenderContacts ust);

	public abstract int insertContact(UstVenderContacts ust);

	public abstract Integer updateVender(UstVenderContacts ust);

	public abstract int disableVender(int venderId);

	public abstract List<UstVenderContacts> venderSearch(String searchString);

}