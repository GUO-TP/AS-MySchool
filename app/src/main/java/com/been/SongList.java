package com.been;

public class SongList {

	public	String songListDesc;
	
	public	String picUrl;
	
	public	String id;
	
	public	String accessnum;
	
	public	String songListAuthor;

	public SongList(String songListDesc, String picUrl, String id,
			String accessnum, String songListAuthor) {
		super();
		this.songListDesc = songListDesc;
		this.picUrl = picUrl;
		this.id = id;
		this.accessnum = accessnum;
		this.songListAuthor = songListAuthor;
	}

	public String getSongListDesc() {
		return songListDesc;
	}

	public void setSongListDesc(String songListDesc) {
		this.songListDesc = songListDesc;
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

	public String getAccessnum() {
		return accessnum;
	}

	public void setAccessnum(String accessnum) {
		this.accessnum = accessnum;
	}

	public String getSongListAuthor() {
		return songListAuthor;
	}

	public void setSongListAuthor(String songListAuthor) {
		this.songListAuthor = songListAuthor;
	}
	
	
	
}
