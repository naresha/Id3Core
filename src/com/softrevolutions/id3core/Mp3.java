package com.softrevolutions.id3core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.softrevolutions.id3core.id3.Id3V1;

public class Mp3 {

	private File mp3File;
	private Id3V1 id3v1;

	private boolean id3v1TagPresent;

	public Mp3 createFrom(File file) {
		if (file.exists()) {
			return null;
		}
		throw new IllegalArgumentException("File " + file.getPath()
				+ "doesn't exists");
	}

	/**
	 * Reads 128 bytes of Id3V1 tag data.
	 * 
	 * @param file
	 *            File to be read. This file should exist.
	 * @return 128 bytes of ID3V1
	 */
	public byte[] readId3V1Data(File file) {
		final byte[] buffer = new byte[128];
		try (RandomAccessFile mp3File = new RandomAccessFile(file, "r")) {
			mp3File.seek(mp3File.length() - 128);
			mp3File.read(buffer, 0, 128);
			id3v1TagPresent = checkForId3V1Tag(buffer);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return null;
	}

	private boolean checkForId3V1Tag(byte[] buffer) {
		String id3Header = new String(buffer, 0, 3);
		return id3Header.equals(Id3V1.HEADER);
	}

	public File getMp3File() {
		return mp3File;
	}

	public Id3V1 getId3v1() {
		return id3v1;
	}

	public boolean isId3v1TagPresent() {
		return id3v1TagPresent;
	}

}
