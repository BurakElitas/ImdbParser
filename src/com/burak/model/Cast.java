package com.burak.model;

public abstract class Cast {
	private String id;
	private String name;
	private String link;
	private Cast_Type type;

	public Cast(String id, String name, String link) {

		this.id = id;
		this.name = name;
		this.link = link;

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Cast_Type getType() {
		return type;
	}

	public void setType(Cast_Type type) {
		this.type = type;
	}
	
	

}
