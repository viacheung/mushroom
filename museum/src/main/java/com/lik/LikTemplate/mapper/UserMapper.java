package com.lik.LikTemplate.mapper;


import com.lik.LikTemplate.entity.CulturalRelic;
import com.lik.LikTemplate.entity.Enshrine;
import com.lik.LikTemplate.entity.Notice;
import com.lik.LikTemplate.entity.User;
import com.lik.LikTemplate.entity.vo.CollectionVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
	// 用户注册
	@Insert("insert into user\n" +
			"\t\t(userName,userPwd,userSex,userPhone,userEmail) values\n" +
			"\t\t(#{userName},#{userPwd},#{userSex},#{userPhone},#{userEmail})")
	public int insertUser(User user);

	// 用户登录判断
	@Select("select * from user where userName = #{user_name}")
	public User userLogin(@Param("user_name")String name);

	//更新密码
	@Update("update user set user_pwd =\n" +
			"\t\t#{user_pwd} where user_name = #{user_name}")
	public int updatePwd(@Param("user_pwd")String userPwd, @Param("user_name")String userName);

	//更新用户信息
	@Update("\tupdate user set userSex =\n" +
			"\t\t#{userSex},userPwd = #{userPwd},userEmail = #{userEmail},userPhone= #{userPhone} where\n" +
			"\t\tuserName = #{userName}")
	public int updateUser(User user);

	//最新公告
	@Select("SELECT * FROM `notice` ORDER BY\n" +
			"\t\t`releaseTime` DESC LIMIT 0,4;")
	public List<Notice> newNotice();

	//最新文物
	@Select("SELECT * FROM `cultural_relic`\n" +
			"\t\tORDER BY `culturalRelicTime` DESC LIMIT 0,4;")
	public List<CulturalRelic> newCu();

	//查询所有文物
	@Select("SELECT * FROM\n" +
			"\t\t`cultural_relic`")
	public List<CulturalRelic> queryCulturalRelic();

	//查询所有文物
	@Select("SELECT * FROM `cultural_relic` where culturalRelicName like '%${culturalRelicName}%' ")
	public List<CulturalRelic> queryCulturalRelicByName(@Param("culturalRelicName")String culturalRelicName);

	//添加用户收藏
	@Insert("INSERT INTO `enshrine`\n" +
			"\t\t(`name`,`imgId`) VALUES(#{name},#{imgId})")
	int userEnshrine(Enshrine enshrine);

	//删除用户收藏
	@Delete("delete from\n" +
			"\t\t`enshrine` where `name`=#{name} AND `imgId`=#{imgId}")
	int deleteUserEnshrine(Enshrine enshrine);

	//查询用户收藏
	@Select("SELECT c.* FROM `enshrine` e,`cultural_relic` c WHERE " +
			"e.`name`=#{name} AND c.`culturalRelicId`=e.`imgId`")
	List<CollectionVo> queryEnshrine(Enshrine enshrine);

	//通过用户名和文物编号查询
	@Select("\tSELECT * FROM `enshrine`\n" +
			"\t\tWHERE `name`=#{name} AND `imgId`=#{imgId}")
	Enshrine queryEnshrine1(Enshrine enshrine);


}
