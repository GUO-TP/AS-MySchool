package com.been;

public class News {
private int id;
private String photo;
private String  title;
private String page;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
@Override
public String toString() {
	return "News [ photo=" + photo + ", title=" + title + ", page=" + page + "]";
}

}
