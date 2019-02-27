package org.bigjava.dao;

import java.util.List;

import org.bigjava.entity.User;

public interface User_Dao {
		// µÇÂ¼
		public List<User> log_in(User user);

		// Ìí¼Ó
		public void add(User user);
		
		// ĞŞ¸Ä
		public void update(User user);
		
		// ²éÑ¯
		public List<User> select_all();
		
}
