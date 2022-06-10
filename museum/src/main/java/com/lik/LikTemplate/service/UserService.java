package com.lik.LikTemplate.service;





import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Enshrine;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.CollectionVo;

import java.util.List;

public interface UserService {
		
	// 用户注册
	int insertUser(User user);

	// 用户登录验证
	boolean userLogin(User user);
	
	//用户名判断
	public boolean judgeUser(User user);

	//通过id查用户
	public User queryUserById(String username);

	//更新用户密码
	public int updatePwd(String userPwd,String userName);

	//更新用户信息
	public int updateUser(User user);
	
	//最新公告
	public List<Notice> newNotice();
	
	//最新文物
	public List<CulturalRelic> newCu();
	
	//查询所有文物
	public List<CulturalRelic> queryCulturalRelic();

	//查询所有文物
	public List<CulturalRelic> queryCulturalRelicByName(String name);
	
	//添加用户收藏
	int userEnshrine(Enshrine enshrine);
	
	//删除用户收藏
	int deleteUserEnshrine(Enshrine enshrine);
		
	//查询用户收藏
	List<CollectionVo> queryEnshrine(Enshrine enshrine);
	
	//通过用户名和文物编号查询
	Boolean queryEnshrine1(Enshrine enshrine);

}
