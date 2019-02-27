package org.bigjava.biz.impl;

import java.util.List;

import org.bigjava.biz.User_Biz;
import org.bigjava.dao.User_Dao;
import org.bigjava.entity.User;

public class User_Biz_impl  implements User_Biz {

	private User_Dao user_dao;

	public void setUser_dao(User_Dao user_dao) {
		this.user_dao = user_dao;
	}

	// 登录
	@Override
	public List<User> log_in (User user) {
		System.out.println("User_Biz_impl.....");
		// TODO Auto-generated method stub
		List<User> list = user_dao.log_in(user);
		return list;
	}

	// 添加
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		System.out.println("添加");
		user_dao.add(user);
	}

	// 修改
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println("Biz修改");
		user_dao.update(user);
	}

	// 查询全部
	@Override
	public List<User> select_all() {
		// TODO Auto-generated method stub
		List<User> list = user_dao.select_all();
		return list;
	}

}
