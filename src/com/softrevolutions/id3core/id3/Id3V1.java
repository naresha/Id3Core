package com.softrevolutions.id3core.id3;

public class Id3V1 {
	
	public static final String HEADER = "TAG";
	public static final int SIZE_OF_HEADER = 3;
	public static final int SIZE_OF_TITLE = 30;
	public static final int SIZE_OF_ARTIST = 30;
	public static final int SIZE_OF_ALBUM = 30;
	public static final int SIZE_OF_YEAR = 4;
	public static final int SIZE_OF_COMMENT = 30;
	public static final int SIZE_OF_GENRE = 1;
	
	private String title;
	private String artist;
	private String album;
	private int year;
	private String comment;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
