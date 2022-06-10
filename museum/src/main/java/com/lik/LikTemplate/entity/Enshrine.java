package com.lik.LikTemplate.entity;

public class Enshrine {
	private int id;
	private String name;
	private String imgId;
	private String cultural_relic_description;
	private String cultural_relic_name;
	
	
	public Enshrine() {
	}
	public Enshrine(int id, String name, String imgId, String cultural_relic_description, String cultural_relic_name) {
		this.id = id;
		this.name = name;
		this.imgId = imgId;
		this.cultural_relic_description = cultural_relic_description;
		this.cultural_relic_name = cultural_relic_name;
	}
	public String getCultural_relic_description() {
		return cultural_relic_description;
	}
	public void setCultural_relic_description(String cultural_relic_description) {
		this.cultural_relic_description = cultural_relic_description;
	}
	public String getCultural_relic_name() {
		return cultural_relic_name;
	}
	public void setCultural_relic_name(String cultural_relic_name) {
		this.cultural_relic_name = cultural_relic_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	@Override
	public String toString() {
		return "Enshrine [id=" + id + ", name=" + name + ", imgId=" + imgId + "]";
	}
	

}
