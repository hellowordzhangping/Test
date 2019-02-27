package org.bigjava.action;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.bigjava.biz.User_Biz;
import org.bigjava.entity.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class User_Action extends ActionSupport implements ModelDriven<User>{

	private User user = new User();									
	
	private User_Biz user_biz;
	private List<User> user_list;	
	private String result;
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<User> getList() {
		return user_list;
	}

	public void setList(List<User> user_list) {
		this.user_list = user_list;
	}

	public void setUser_biz(User_Biz user_biz) {
		this.user_biz = user_biz;
	}
	
	

	// 添加
	public String insert() {
		System.out.println("添加的值" + user);
		user_biz.add(user);
		System.out.println("注册成功");
		return "success";
	}
	
	// 登录
	public String find() {
		System.out.println("登录.....");
		try {
			if ((user.getUsername())==null || (user.getPassword())==null ) {		// 判断不能username，password不能为空
				System.out.println("用户名或密码不能为空！");
				result = "用户名或密码不能为空";
			} else {
				List<User> list = user_biz.log_in(user);				// 进行登录的操作
				if (list.size() == 0) {									// 判断是否登录成功
					result = "用户名或密码错误";
				} else {				
					result = list.get(0).getUsername();
					if (list.get(0).getAdmin_id() == 1) {
						return  "admin";
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();									// 将异常抛出
			return "error";											// 页面跳转到自定义的报错页面
		}
		return "success";
	}
	
	// 修改
	public String all() {
//		System.out.println("查询全部....");
//		try {
//			List<User> list = user_biz.select_all();
//			user_list = list;
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
		return "success";
	}

	// 查询全部
			public String findAll() {
				System.out.println("查询全部..in action");
				try {
					List<User> list = user_biz.select_all();
//					AllEntity = list;
					
				} catch(Exception e) {
					e.printStackTrace();
					return "error";
				}
				return "success";
			}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
