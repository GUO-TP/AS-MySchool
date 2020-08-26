package com.been;

public class Advertisement {
	
	public	String picUrl;

	public Advertisement(String picUrl) {
		super();
		this.picUrl = picUrl;
	}

	public Advertisement() {
		super();
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "Advertisement [picUrl=" + picUrl + "]";
	}
	
}
