package com.been;

public class Slider {

	public	String linkUrl;
	
	public	String picUrl;
	
	public	String id;

	public Slider(String linkUrl, String picUrl, String id) {
		super();
		this.linkUrl = linkUrl;
		this.picUrl = picUrl;
		this.id = id;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
