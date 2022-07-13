package com.mbh.blog.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mbh.blog.model.UserDTO;

@Repository
@Service
public class UserService {
	private final String NAMESPACE = "mapper.UserMapper";

	@Autowired
	private SqlSession sqlSession;

	public void register(UserDTO u) {
		sqlSession.insert(NAMESPACE + ".register", u);
	}
	public boolean usernameIsEquals(String username) {
		if(sqlSession.selectOne(NAMESPACE + ".equals", username) == null) {
			
			return true;
		}
		
		return false;
	}
}
