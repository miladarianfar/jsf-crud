package com.user.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.user.dao.UserDao;
import com.user.entity.User;

@SessionScoped
@ManagedBean
public class UserController {

	List<User> users;
	
	public List<User> getUsers() {
		return users;
	}


	public void showUsers() {
		
		UserDao dao = new UserDao();
		
		users = dao.getUsers();
		
	}
	
	public String addUser(User user) {
		
		UserDao dao = new UserDao();
		
		dao.addUser(user);
		
		return "user_list";
	}
	
	public String getUser(int id) {
		
		UserDao dao = new UserDao();
		
		User user = dao.getUser(id);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String , Object> requestMap = externalContext.getRequestMap();
		requestMap.put("user", user);
		
		return "update_form";
	}
	
	public String updateUser(User user) {
		
		UserDao dao = new UserDao();
		
		dao.updateUser(user);
		
		return "user_list";
	}
	
	public String deleteUser(int id) {
		
		UserDao dao = new UserDao();
		
		dao.deleteUser(id);
		
		return "user_list";
	}
	
}



















