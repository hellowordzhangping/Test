package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.User;

public interface User_Dao {
		// ��¼
		public List<User> log_in(User user);

		// ���
		public void add(User user);
		
		// �޸�
		public void update(User user);
		
		// ��ѯ
		public List<User> select_all();
		
}
