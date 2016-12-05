package com.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;

public class Test {
public static void main(String[] args) {
	try {
		String resource="mybatis-config.xml";
		Reader reader=Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=sfb.build(reader);
		SqlSession session=ssf.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		User user=new User();
		user.setUsername("cx");
		user.setPassword("123");
		userDao.insert(user);
		session.commit();
		session.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
