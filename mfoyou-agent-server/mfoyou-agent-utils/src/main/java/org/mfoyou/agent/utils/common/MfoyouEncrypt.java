package org.mfoyou.agent.utils.common;


public class MfoyouEncrypt {
	private static int sum = 150000000;
	private static final int size = 6;
	private static String start = "0123abce4567vwx89fgjklmnopqrstuz";
	public static String enCode(Integer index){
		if(index==null){
			return null;
		}
		String key = "mfoyou";
		char[] newChar = new char[size];
		byte[] bytes = key.getBytes();
		int a = sum-index.intValue();
		for(int i = 0;i < size; i++){
			newChar[i] =start.charAt((( a >> (i*5)) ^ bytes[i]) & 0x1f); 
		}
		return new String(newChar);
	}
	public static Integer  decode(String code) {
		if(code == null || code.length()!=6){
			return null;
		}
		String key = "mfoyou";
		byte[] bytes = key.getBytes();
		int k = 0;
		for(int i=0;i<size;i++){
			k |= ((start.indexOf(code.charAt(i)) ^ bytes[i]) & 0x1f) << (i*5);
		}
		return sum-k;
	}
	public static void main(String[] args) {
		System.out.println(enCode(8991));
	}
}
