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
	
	

	// ���
	public String insert() {
		System.out.println("��ӵ�ֵ" + user);
		user_biz.add(user);
		System.out.println("ע��ɹ�");
		return "success";
	}
	
	// ��¼
	public String find() {
		System.out.println("��¼.....");
		try {
			if ((user.getUsername())==null || (user.getPassword())==null ) {		// �жϲ���username��password����Ϊ��
				System.out.println("�û��������벻��Ϊ�գ�");
				result = "�û��������벻��Ϊ��";
			} else {
				List<User> list = user_biz.log_in(user);				// ���е�¼�Ĳ���
				if (list.size() == 0) {									// �ж��Ƿ��¼�ɹ�
					result = "�û������������";
				} else {				
					result = list.get(0).getUsername();
					if (list.get(0).getAdmin_id() == 1) {
						return  "admin";
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();									// ���쳣�׳�
			return "error";											// ҳ����ת���Զ���ı���ҳ��
		}
		return "success";
	}
	
	// �޸�
	public String all() {
//		System.out.println("��ѯȫ��....");
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

	// ��ѯȫ��
			public String findAll() {
				System.out.println("��ѯȫ��..in action");
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
