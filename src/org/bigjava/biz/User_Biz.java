package org.bigjava.biz;

import java.util.List;

import org.bigjava.entity.User;

public interface User_Biz {

	// ��¼
	public List<User> log_in(User user);
	
	// ���
	public void add(User user);
	
	// �޸�
	public void update(User user);
	
	// ��ѯȫ��
	public List<User> select_all();
}
