package com.lik.LikTemplate.entity.vo;

public class userSexVo {
    private Integer value;
    private String name;

    public userSexVo() {
    }

    public userSexVo(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "userSexVo [value=" + value + ", name=" + name + "]";
	}
    
}
