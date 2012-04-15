package com.softrevolutions.id3core.util;

/**
 * 
 * @author Naresha
 * 
 */
public final class Util {

    /**
     * Returns string of specified length, containing NUL in each index.
     * 
     * @param length
     *            number of spaces required
     * @return spaces
     */
    public static String getNullPaddedString(int length) {
	// increased initial capacity 30
	StringBuilder buffer = new StringBuilder(30);
	for (int i = 0; i < length; i++) {
	    buffer.append((char) 0);
	}
	return buffer.toString();
    }

    /**
     * Returns fixed length string by padding with spaces.
     * 
     * @param value
     *            string to be padded
     * @param length
     *            length of string after padding
     * @return padded string
     */
    public static String getFixedLengthString(String value, int length) {
	int paddingLength = length - value.length();
	String result = null;
	if (paddingLength < 1) {
	    result = value.substring(0, length);
	} else {
	    result = value + getNullPaddedString(paddingLength);
	}
	return result;
    }

    /**
     * Converts string to byte array, where each character is represented by a
     * byte (as against the default 2 bytes)
     * 
     * @param value
     *            string to be converted to bytes
     * @return bytes of ASCII string
     */
    public static byte[] convertToByteArray(String value) {
	char[] characters = value.toCharArray();
	byte[] bytes = new byte[value.length()];
	for (int i = 0; i < characters.length; i++) {
	    bytes[i] = (byte) characters[i];
	}
	return bytes;
    }

    /**
     * Replaces a part of byte array with specified bytes.
     * 
     * @param source
     *            byte array in which replacement to be done.
     * @param offset
     *            position at which replacement should start
     * @param replaceValue
     *            text to be inserted
     * @return updated byte array
     */
    public static byte[] replaceBytes(final byte[] source, final int offset,
	    final byte[] replaceValue) {
	for (int i = 0; i < replaceValue.length; i++) {
	    source[offset + i] = replaceValue[i];
	}
	return source;
    }
}
