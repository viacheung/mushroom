package com.lik.LikTemplate.entity;

public class CulturalRelic {
	private String culturalRelicId;           //文物编号
	private String culturalRelicName;          //文物名称
	private String culturalRelicType;          //文物类型
	private String culturalRelicDescription;   //文物描述
	private String img; //图片路径
	private String culturalRelicTime;          //发布时间
	private Integer culturalRelicNumber;       //被收藏量
	
	public String getCulturalRelicName() {
		return culturalRelicName;
	}
	public void setCulturalRelicName(String culturalRelicName) {
		this.culturalRelicName = culturalRelicName;
	}
	public String getCulturalRelicType() {
		return culturalRelicType;
	}
	public void setCulturalRelicType(String culturalRelicType) {
		this.culturalRelicType = culturalRelicType;
	}
	public String getCulturalRelicDescription() {
		return culturalRelicDescription;
	}
	public void setCulturalRelicDescription(String culturalRelicDescription) {
		this.culturalRelicDescription = culturalRelicDescription;
	}
	public String getCulturalRelicTime() {
		return culturalRelicTime;
	}
	public void setCulturalRelicTime(String culturalRelicTime) {
		this.culturalRelicTime = culturalRelicTime;
	}
	public Integer getCulturalRelicNumber() {
		return culturalRelicNumber;
	}
	public void setCulturalRelicNumber(Integer culturalRelicNumber) {
		this.culturalRelicNumber = culturalRelicNumber;
	}
	public CulturalRelic() {
		super();
	}
	public String getCulturalRelicId() {
		return culturalRelicId;
	}
	public void setCulturalRelicId(String culturalRelicId) {
		this.culturalRelicId = culturalRelicId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "CulturalRelic [culturalRelicId=" + culturalRelicId + ", culturalRelicName=" + culturalRelicName
				+ ", culturalRelicType=" + culturalRelicType + ", culturalRelicDescription=" + culturalRelicDescription
				+ ", img=" + img + ", culturalRelicTime=" + culturalRelicTime + ", culturalRelicNumber="
				+ culturalRelicNumber + "]";
	}
	public CulturalRelic(String culturalRelicId, String culturalRelicName, String culturalRelicType,
			String culturalRelicDescription, String img, String culturalRelicTime, Integer culturalRelicNumber) {
		super();
		this.culturalRelicId = culturalRelicId;
		this.culturalRelicName = culturalRelicName;
		this.culturalRelicType = culturalRelicType;
		this.culturalRelicDescription = culturalRelicDescription;
		this.img = img;
		this.culturalRelicTime = culturalRelicTime;
		this.culturalRelicNumber = culturalRelicNumber;
	}
	
}
