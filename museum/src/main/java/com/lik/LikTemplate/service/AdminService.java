package com.lik.LikTemplate.service;


import com.lik.LikTemplate.entity.Admin;
import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.UserVo;
import com.lik.LikTemplate.entity.vo.userSexVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

	/**
	//管理员登录验证
	 //订单信息service
	List getDingDanList(Admin admin);
	 **/

	//管理员登录验证
	boolean adminLogin(Admin admin);

	//==============用户操作相关===========

	//查询全部用户
	public UserVo<User> queryAllUser(Integer page, Integer limit, String userName);

	//查询用户
	public User getUserByName(String userName);

	//删除用户
	public int deleteUser(String userName);

	//性别分组查询
	public List<userSexVo> querySex();

	//==============公告操作相关===========

	//查询全部公告
	public UserVo<Notice> queryNotice(Integer page, Integer limit);

	//删除公告
	public int deleteNotice(String id);

	//新增公告
	public int addNotice(Notice notice);

	//更新公告
	public int updateNotice(Notice notice);

	// ==============文物操作相关===========
	// 查询全部文物信息
	public UserVo<CulturalRelic> queryAllCulturalRelic(Integer page,Integer limit,String culturalRelicName);

	// 删除文物
	public int deleteCulturalRelic(@Param("cultural_relic_id") String CulturalRelicId);

	public CulturalRelic getCulturalRelicById(String id);

	// 新增文物
	public int addCulturalRelic(CulturalRelic culturalRelic);

	// 更新文物信息
	public int updateCulturalRelic(CulturalRelic culturalRelic);

    List getCulturalRelicByType(String type);
}
