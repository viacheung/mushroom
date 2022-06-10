package com.lik.LikTemplate.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lik.LikTemplate.entity.*;
import com.lik.LikTemplate.entity.vo.userSexVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
//
//	//管理员登录判断
//	@Select("编写SQL")
//	public List getDingDanList();

	//管理员登录判断
	@Select("select\n" +
			"\t\t* from admin where name = #{name}")
	public Admin adminLogin(@Param("name")String name);

	//==============用户操作相关===========

	//查询全部用户信息
	@Select("select * from user limit #{start},#{size}")
	public List<User> queryAllUser(@Param("start")Integer page, @Param("size")Integer limit, @Param("userName")String userName);

	//查询用户总数
	@Select("select count(userName) from\n" +
			"\t\tuser")
	public int countUser();

	//删除用户
	@Delete("delete from user where\n" +
			"\t\tuserName=#{user_name}")
	public int deleteUser(@Param("user_name")String userName);

	//删除用户
	@Select("select * from user where\n" +
			"\t\tuserName=#{user_name}")
	public User getUserByName(@Param("user_name")String userName);

	//性别分组
	public List<userSexVo> querySex();

	//==============公告操作相关===========

	//查询全部公告信息
	@Select("select * from notice\n" +
			"\t\t\tlimit #{start},#{size}\n")
	public List<Notice> queryNotice(@Param("start")Integer page, @Param("size")Integer limit);

	//删除公告
	@Delete("delete from notice where\n" +
			"\t\tid=#{id}")
	public int deleteNotice(@Param("id")String id);

	//查询公告总数
	@Select("select count(*) from notice")
	public int countNotice();

	//新增公告
	@Insert("\tinsert into notice\n" +
			"\t\t(id,title,publisher,content,releaseTime) values\n" +
			"\t\t(#{id},#{title},#{publisher},#{content},#{releaseTime})")
	public int addNotice(Notice notice);

	//更新公告
	public int updateNotice(Notice notice);

	//==============文物操作相关===========

	// 查询全部文物信息
	@Select("select * from cultural_relic limit #{start},#{size}")
	public List<CulturalRelic> queryAllCulturalRelic(@Param("start") Integer page, @Param("size") Integer limit, @Param("culturalRelicName") String culturalRelicName);

	// 查询全部文物信息
	@Select("select * from cultural_relic where culturalRelicType = #{type}")
	public List<CulturalRelic> getCulturalRelicByType(@Param("type") String type);

	// 查询全部文物信息
	@Select("select * from cultural_relic where culturalRelicId = #{id}")
	public CulturalRelic getCulturalRelicById(@Param("id") String id);


	// 查询文物总数
	@Select("select\n" +
			"\t\tcount(culturalRelicId) from cultural_relic")
	public int countCulturalRelic();

	// 删除文物
	@Delete("delete from\n" +
			"\t\tcultural_relic where culturalRelicId=#{cultural_relic_id}")
	public int deleteCulturalRelic(@Param("cultural_relic_id") String CulturalRelicId);

	// 新增文物
	@Insert("\tinsert into\n" +
			"\t\tcultural_relic\n" +
			"\t\t(culturalRelicId,culturalRelicName,culturalRelicType,culturalRelicDescription,culturalRelicTime,img)\n" +
			"\t\tvalues\n" +
			"\t\t(#{culturalRelicId},#{culturalRelicName},#{culturalRelicType},#{culturalRelicDescription},#{culturalRelicTime},#{img})")
	public int addCulturalRelic(CulturalRelic culturalRelic);

	// 更新文物信息
	@Update("update\n" +
			"\t\tcultural_relic set\n" +
			"\t\tculturalRelicName=#{culturalRelicName},culturalRelicType=#{culturalRelicType},culturalRelicDescription=#{culturalRelicDescription}\n" +
			"\t\twhere culturalRelicId=#{culturalRelicId}")
	public int updateCulturalRelic(CulturalRelic culturalRelic);

}
