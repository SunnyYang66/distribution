package com.mfoyou.agent.web.utils.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;


public class AES {

	private static final Logger LOGGER = Logger.getLogger(AES.class);
	private static String sKey="C724DA350F57BD5DB2CEF197047605AD";

	public static byte[] encrypt(String content, byte[] enCodeFormat) {
		try {
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] content,byte[] enCodeFormat) {
		try {

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	public static String decode(String code){
		LOGGER.info(String.format("即将AES解码code=%s", code));
		String result = decode(code, sKey);
		LOGGER.info(String.format("AES解码code=%s,解码后为result=%s", code, result));
		return result;
	}
	public static String decode(String code,byte[] key){
		byte[] decryptFrom = parseHexStr2Byte(code);  
	    byte[] decryptResult = decrypt(decryptFrom,key);  
	    return new String(decryptResult);
	}
	public static String decode(String code,String key){
		byte[] decryptFrom = parseHexStr2Byte(code);  
	    byte[] decryptResult = decrypt(decryptFrom,parseHexStr2Byte(key));  
	    try {
			return new String(decryptResult,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    return "";
	}
	public static String encode(String content){
		return encode(content,sKey);
	}
	public static String encode(String content,byte[] key){
		byte[] encryptResult = encrypt(content, key);  
	    String encryptResultStr = parseByte2HexStr(encryptResult);
	    return encryptResultStr;
	}
	public static String encode(String content,String keyString){
		byte[] encryptResult = encrypt(content, parseHexStr2Byte(keyString));  
		String encryptResultStr = parseByte2HexStr(encryptResult);
		return encryptResultStr;
	}

	public static String makeKey(String password) throws NoSuchAlgorithmException{
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		String encryptResultStr = parseByte2HexStr(enCodeFormat);  
		return encryptResultStr;		
	}
	public static void main(String[] args) throws Exception{
	    String content = "userid=1111&name=测试人员&phone=13333333333&time="+System.currentTimeMillis();  
	    String password = "dfdwasweessxfd34dd";  
	    //加密   
	    String keyString = makeKey(password);
	    System.out.println("秘钥为：" + keyString);  
	    System.out.println("加密前：" + content);  
	    byte[] encryptResult = encrypt(content, parseHexStr2Byte(keyString));  
	    String encryptResultStr = parseByte2HexStr(encryptResult);  
	    System.out.println("加密后：" + encryptResultStr);  
	    //解密   
	    byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);  
	    byte[] decryptResult = decrypt(decryptFrom,parseHexStr2Byte(keyString));  
	    System.out.println("解密后：" + new String(decryptResult));  
	    
	}

}
