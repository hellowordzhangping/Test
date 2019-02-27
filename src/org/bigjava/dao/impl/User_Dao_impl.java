package org.bigjava.dao.impl;

import java.util.List;

import org.bigjava.dao.User_Dao;
import org.bigjava.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class User_Dao_impl implements User_Dao{

private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 登录
	public List<User> log_in(User user) {
		// TODO Auto-generated method stub	
		String sql = "from User u where u.username = '"+user.getUsername()+"' and u.password = '"+user.getPassword()+"'";
			
		List<User> list = hibernateTemplate.find(sql);
		return list;
	}

	// 添加
	public void add(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	
	// 修改
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println("Dao修改");
		hibernateTemplate.update("from User set username = ? and password = ? where id = ?", new Object[]{user.getUsername(), user.getPassword(), user.getId()});
	}

	// 查询全部
	public List<User> select_all() {
		// TODO Auto-generated method stub
		System.out.println("Dao查询");
		List<User> list = hibernateTemplate.find("from User");
		return list;
	}
}
