package com.github.hualuomoli.demo.mq_spring.type;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Demo implements Serializable {

	private static final long serialVersionUID = 5501965385636356423L;

	private String id;
	private String name;
	private Date createDate;

	public Demo() {
		id = UUID.randomUUID().toString().replace("-", "");
		name = "这是Obj的内容信息";
		createDate = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("\n");
		buffer.append("\t").append("id:").append(id).append("\n");
		buffer.append("\t").append("name:").append(name).append("\n");
		buffer.append("\t").append("createDate:").append(createDate).append("\n");
		return buffer.toString();
	}

}
