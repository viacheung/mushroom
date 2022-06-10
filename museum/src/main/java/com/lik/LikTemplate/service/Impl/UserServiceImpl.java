package com.lik.LikTemplate.service.Impl;


import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Enshrine;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.CollectionVo;
import com.lik.LikTemplate.mapper.UserMapper;
import com.lik.LikTemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	// 用户注册
	public int insertUser(User user) {
		System.out.println("service="+user);
		return userMapper.insertUser(user);
	}

	// 用户登录验证
	public boolean userLogin(User user) {

		String name = user.getUserName();
		User user1 = userMapper.userLogin(name);
		if (user1 != null && user1.getUserPwd().equals(user.getUserPwd())) {
			System.out.println("获取用户名密码成功");
			return true;	
		}
		System.out.println("获取用户名密码失败");
		return false;
	}
	
	//用户名判断
	public boolean judgeUser(User user) {

		User user1 = userMapper.userLogin(user.getUserName());
		if(user1 != null) {
			return true;		
		}		
		return false;		
	}

	//通过用户名查找用户
	public User queryUserById(String username) {
		// TODO 自动生成的方法存根
		return userMapper.userLogin(username);
	}

	//更新密码
	public int updatePwd(String userPwd,String userName) {
	
		return userMapper.updatePwd(userPwd,userName);
	}

	//更新用户信息
	public int updateUser(User user) {
		
		return userMapper.updateUser(user);
	}

	//最新公告
	public List<Notice> newNotice() {
		return userMapper.newNotice();
	}
	
	// 最新公告
	public List<CulturalRelic> newCu() {
		return userMapper.newCu();
	}

	// 查询所有文物
	public List<CulturalRelic> queryCulturalRelic() {
		return userMapper.queryCulturalRelic();
	}

	// 增加收藏
	@Override
	public int userEnshrine(Enshrine enshrine) {
		return userMapper.userEnshrine(enshrine);
		
	}

	// 删除收藏
	@Override
	public int deleteUserEnshrine(Enshrine enshrine) {
		return userMapper.deleteUserEnshrine(enshrine);
	}

	// 查询收藏
	@Override
	public List<CollectionVo> queryEnshrine(Enshrine enshrine) {
		return userMapper.queryEnshrine(enshrine);
	}

	@Override
	public Boolean queryEnshrine1(Enshrine enshrine) {
		if(userMapper.queryEnshrine1(enshrine)!=null) {
			return true;
		}
		return false;
	}

	//查询所有文物
	public List<CulturalRelic> queryCulturalRelicByName(String name){
		return userMapper.queryCulturalRelicByName(name);
	}

}
