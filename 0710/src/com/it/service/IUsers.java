package com.it.service;

import java.util.List;

import com.it.bean.Users;

/**
 * 
 * 
* <p>
 * Title:
 * 
 *����������
 *
 * </p>
 * <p>
 * Description:com.it.service.IUsers.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018��8��16�� ����5:55:54
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public interface IUsers {
	//��
	public boolean addUsers(Users users);
	//ɾ
	public boolean delUsers(Users users);
	//��
	public boolean updUsers(Users users);
	//��
	public List<Users> queryAllUsers(Users users);
	//��
	public Users findUsersById(Users users);
	
	

}
