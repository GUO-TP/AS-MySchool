package com.been;

public class Goods {
   int imageId;
   String name;
	public int getImageId() {
	return imageId;
}
public void setImageId(int imageId) {
	this.imageId = imageId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
	public Goods(int imageId, String name) {
	super();
	this.imageId = imageId;
	this.name = name;
}

	
}
