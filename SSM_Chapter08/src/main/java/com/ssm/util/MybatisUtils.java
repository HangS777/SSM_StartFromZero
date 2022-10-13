package com.ssm.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	
	private static volatile SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			String resouce = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resouce);
			if (sqlSessionFactory == null) {
				synchronized(SqlSessionFactory.class) {
					if (sqlSessionFactory == null) {
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

}
