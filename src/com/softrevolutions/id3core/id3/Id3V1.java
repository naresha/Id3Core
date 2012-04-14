package com.softrevolutions.id3core.id3;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.softrevolutions.id3core.util.Util;

public class Id3V1 {

	public static final String HEADER = "TAG";
	public static final int SIZE_OF_HEADER = 3;
	public static final int SIZE_OF_TITLE = 30;
	public static final int SIZE_OF_ARTIST = 30;
	public static final int SIZE_OF_ALBUM = 30;
	public static final int SIZE_OF_YEAR = 4;
	public static final int SIZE_OF_COMMENT = 30;
	public static final int SIZE_OF_GENRE = 1;
	public static final String ID3_CHARSET = "ISO-8859-1";

	private String title;
	private String artist;
	private String album;
	private int year;
	private String comment;
	//TODO: Check if this can be removed
	private byte[] rawBytes;

	public static Id3V1 createFromBytes(byte[] data) {
		int offset = SIZE_OF_HEADER;
		String title = null;
		try {
			title = new String(data, offset, SIZE_OF_TITLE, ID3_CHARSET).trim();
			offset += SIZE_OF_TITLE;

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Id3V1 id3v1 = new Id3V1();
		id3v1.setTitle(title);
		id3v1.rawBytes = data;
		return id3v1;
	}
	
	public byte[] getBytes(){
		int offset = SIZE_OF_HEADER;
		String title = Util.getFixedLengthString(this.title, SIZE_OF_TITLE);
		byte[] titleBytes = Util.convertToByteArray(title);
		Util.repaceBytes(rawBytes, offset, titleBytes);
		return rawBytes;
	}

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

	/**
	 * Checks if data which claims to be ID3 V1 tag has the correct header
	 * 
	 * @param buffer
	 *            128 bytes of ID3 V1 tag
	 * @return true if header is valid, false otherwise.
	 */
	public static boolean checkForId3V1Tag(byte[] buffer) {
		String id3Header = new String(buffer, 0, 3);
		return id3Header.equals(HEADER);
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(500);
		buffer
		.append("Title: " + this.title + "; ")
		.append("Artist: " + this.artist + "; ")
		.append("");
		return buffer.toString();
	}

}
