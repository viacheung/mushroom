package com.lik.LikTemplate.service.Impl;


import com.lik.LikTemplate.entity.Admin;
import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.UserVo;
import com.lik.LikTemplate.entity.vo.userSexVo;
import com.lik.LikTemplate.mapper.AdminMapper;
import com.lik.LikTemplate.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	//获取订单列表   看不懂
	public UserVo<User> getDingDanList(Integer page, Integer limit, String userName) {
		//调用Mapper
		UserVo<User> userVo = new UserVo<User>();
		userVo.setCode(0);
		userVo.setMsg("");
		userVo.setCount(adminMapper.countUser());
		List<User> userList = adminMapper.queryAllUser((page-1)*limit,limit,userName);
		if(userList != null) {
			userVo.setData(userList);
		}
		return userVo;
	}



	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	// 管理员登录验证
	public boolean adminLogin(Admin admin) {

		String name = admin.getName();
		Admin admin1 = adminMapper.adminLogin(name);
//		if (admin1 != null && admin1.getPwd().equals(admin.getPwd())) {
//			System.out.println("获取用户名密码成功");
//			return true;
//		}
//
//		System.out.println("获取用户名密码失败");
//		return false;
		return (admin1 != null && admin1.getPwd().equals(admin.getPwd()));
	}

	//==============用户操作相关===========

	//查询全部用户
	public UserVo<User> queryAllUser(Integer page, Integer limit, String userName) {
		UserVo<User> userVo = new UserVo<User>();
		userVo.setCode(0);
		userVo.setMsg("");
		userVo.setCount(adminMapper.countUser());
		List<User> userList = adminMapper.queryAllUser((page-1)*limit,limit,userName);
		if(userList != null) {
			userVo.setData(userList);
		}
		return userVo;
	}

	@Override
	public User getUserByName(String userName) {
		return adminMapper.getUserByName(userName);
	}

	// 删除用户
	public int deleteUser(String userName) {
		return adminMapper.deleteUser(userName);
	}

	//性别分组
	public List<userSexVo> querySex() {
		return adminMapper.querySex();
	}


	//==============公告操作相关===========

	//查询全部公告
	public UserVo<Notice> queryNotice(Integer page, Integer limit) {

		UserVo<Notice> userVo = new UserVo<Notice>();
		userVo.setCode(0);
		userVo.setMsg("");
		userVo.setCount(adminMapper.countNotice());
		List<Notice> userList = adminMapper.queryNotice((page-1)*limit,limit);
		if(userList != null) {
			userVo.setData(userList);
		}
		return userVo;
	}

	//新增公告
	public int addNotice(Notice notice) {
		return adminMapper.addNotice(notice);
	}

	//删除公告
	public int deleteNotice(String id) {
		return adminMapper.deleteNotice(id);
	}

	//更新公告
	public int updateNotice(Notice notice) {
		return adminMapper.updateNotice(notice);
	}


	// ==============文物操作相关===========
	// 查询全部文物信息
	public UserVo<CulturalRelic> queryAllCulturalRelic(Integer page, Integer limit, String culturalRelicName) {
		UserVo<CulturalRelic> userVo = new UserVo<CulturalRelic>();
		userVo.setCode(0);
		userVo.setMsg("");
		userVo.setCount(adminMapper.countCulturalRelic());
		List<CulturalRelic> culturalRelicsList = adminMapper.queryAllCulturalRelic((page-1)*limit,limit,culturalRelicName);
		if(culturalRelicsList != null) {
			userVo.setData(culturalRelicsList);
		}
		return userVo;
	}

	//删除文物
	public int deleteCulturalRelic(String CulturalRelicId) {
		return adminMapper.deleteCulturalRelic(CulturalRelicId);
	}

	@Override
	public CulturalRelic getCulturalRelicById(String id) {
		return adminMapper.getCulturalRelicById(id);
	}

	//添加文物
	public int addCulturalRelic(CulturalRelic culturalRelic) {
		return adminMapper.addCulturalRelic(culturalRelic);
	}

	//更新文物信息
	public int updateCulturalRelic(CulturalRelic culturalRelic) {
		return adminMapper.updateCulturalRelic(culturalRelic);
	}

	@Override
	public List getCulturalRelicByType(String type) {
		return adminMapper.getCulturalRelicByType(type);
	}
}
