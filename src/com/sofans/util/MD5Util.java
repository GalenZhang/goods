package com.sofans.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Static functions to simplifiy common {@link java.security.MessageDigest}
 * tasks. This class is thread safe.
 * 
 * @author 99bill
 * 
 */
public class MD5Util {

	private MD5Util() {
	}

	/**
	 * Returns a MessageDigest for the given <code>algorithm</code>.
	 * 
	 * @param algorithm
	 *            The MessageDigest algorithm name.
	 * @return An MD5 digest instance.
	 * @throws RuntimeException
	 *             when a {@link java.security.NoSuchAlgorithmException} is
	 *             caught
	 */

	static MessageDigest getDigest() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 16 element
	 * <code>byte[]</code>.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest
	 */
	public static byte[] md5(byte[] data) {
		return getDigest().digest(data);
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 16 element
	 * <code>byte[]</code>.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest
	 */
	public static byte[] md5(String data) {
		return md5(data.getBytes());
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex
	 * string.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest as a hex string
	 */
	public static String md5Hex(byte[] data) {
		return HexUtil.toHexString(md5(data));
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex
	 * string.
	 * 
	 * @param data
	 *            Data to digest
	 * @return MD5 digest as a hex string
	 */
	public static String md5Hex(String data) {
		return HexUtil.toHexString(md5(data));
	}
	
	/*3random number + md5(username + sofans + password) + 3random number*/
	public static String salt(String username, String password) {
		Random random = new Random();
		int salt = random.nextInt(999999);
		
		String valueOf = String.valueOf(salt);
		if (valueOf.length() < 6)
		{
			StringBuilder sb = new StringBuilder(valueOf);
			int a = 6 - valueOf.length();
			for (int i = 0; i < a; i++)
			{
				sb.append(i);
			}
			valueOf = sb.toString();
		}
		String md5Hex = md5Hex(username+"sofans"+password);
		md5Hex = valueOf + md5Hex;

		return md5Hex;
	}
	
	public static boolean verify(String orginaPassword, String username, String password){
		String salt = orginaPassword.substring(0, 6);
		String md5Hex = md5Hex(username+"sofans"+password);
		if ((salt + md5Hex).equals(orginaPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(MD5Util.salt("goods", "goods.123"));
		System.out.println(MD5Util.salt("admin", "goods.123"));
		
	}
	
}
