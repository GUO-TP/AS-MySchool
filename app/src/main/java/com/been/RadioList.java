package com.been;

public class RadioList {

	public	String picUrl;
	
	public	String Ftitle;
	
	public	String radioid;

	public RadioList(String picUrl, String ftitle, String radioid) {
		super();
		this.picUrl = picUrl;
		Ftitle = ftitle;
		this.radioid = radioid;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getFtitle() {
		return Ftitle;
	}

	public void setFtitle(String ftitle) {
		Ftitle = ftitle;
	}

	public String getRadioid() {
		return radioid;
	}

	public void setRadioid(String radioid) {
		this.radioid = radioid;
	}
	
	
	
}
