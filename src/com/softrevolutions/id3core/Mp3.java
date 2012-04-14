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

	public static Mp3 createFrom(File file) {
		Mp3 mp3 = new Mp3();
		mp3.mp3File = file;
		if (file.exists()) {
			byte[] id3Data = readId3V1Data(file);
			mp3.id3v1TagPresent = Id3V1.checkForId3V1Tag(id3Data);
			if(mp3.id3v1TagPresent){
				mp3.id3v1 = Id3V1.createFromBytes(id3Data);
			}
			
			return mp3;
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
	public static byte[] readId3V1Data(File file) {
		final byte[] buffer = new byte[128];
		try (RandomAccessFile mp3File = new RandomAccessFile(file, "r")) {
			mp3File.seek(mp3File.length() - 128);
			mp3File.read(buffer, 0, 128);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return buffer;
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public byte[] writeId3V1Data(File file) {
		final byte[] buffer = new byte[128];
		try (RandomAccessFile mp3File = new RandomAccessFile(file, "rw")) {
			mp3File.seek(mp3File.length() - 128);
			mp3File.write(this.id3v1.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
	
	public void save(){
		if(id3v1TagPresent){
			writeId3V1Data(this.mp3File);
		}
	}


	public File getMp3File() {
		return mp3File;
	}

	public Id3V1 getId3v1() {
		return id3v1;
	}


}
