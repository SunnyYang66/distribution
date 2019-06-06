package org.mfoyou.agent.utils.common;

import java.security.MessageDigest;


public class MD5Utils {
	
	public static String encrypt(String msg,String key){
		return md5(md5(msg)+key);
	}
	
	public static String md5(String msg) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			//指定MD5加密的编码
			byte md5[] = md.digest(msg.getBytes("utf-8"));
			String strRet = "";
			for(int i = 0; i < md5.length; i++){
				strRet = strRet + String.format("%02x", md5[i]);
			}
			return strRet;
		} catch (Exception e) {
			return "";
		}

	}
	

	public void test() throws Exception{
		String sign = MD5Utils.md5("tcxy" + "短信验证码" + "18200381943"
				+ "tcxy" + "39412");
		System.out.println(sign);
	}
}
