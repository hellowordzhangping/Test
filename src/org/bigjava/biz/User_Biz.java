package org.bigjava.biz;

import java.util.List;

import org.bigjava.entity.User;

public interface User_Biz {

	// 登录
	public List<User> log_in(User user);
	
	// 添加
	public void add(User user);
	
	// 修改
	public void update(User user);
	
	// 查询全部
	public List<User> select_all();
}
