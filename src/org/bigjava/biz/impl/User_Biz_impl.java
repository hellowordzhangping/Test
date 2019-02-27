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

	// ��¼
	@Override
	public List<User> log_in (User user) {
		System.out.println("User_Biz_impl.....");
		// TODO Auto-generated method stub
		List<User> list = user_dao.log_in(user);
		return list;
	}

	// ���
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		System.out.println("���");
		user_dao.add(user);
	}

	// �޸�
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println("Biz�޸�");
		user_dao.update(user);
	}

	// ��ѯȫ��
	@Override
	public List<User> select_all() {
		// TODO Auto-generated method stub
		List<User> list = user_dao.select_all();
		return list;
	}

}
