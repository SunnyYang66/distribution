package com.mfoyou.agent.web.utils.yinianyun;

import org.mfoyou.agent.common.OP.BaseYinianUtil;

public class YinianyunUtils extends BaseYinianUtil{
	
	public static String btnprint(String machine_code,String response_type,String token){
		return methods.btnPrint(machine_code, response_type, token);
	}
	/**
	 * 取消一个订单
	 * @param machine_code
	 * @param token
	 * @return
	 */
	public static String cancelone(String machine_code,String token,String order_id){
		return methods.cancelOne(machine_code, order_id, token);
	}
	/**
	 * 取消所有订单
	 * @param machine_code
	 * @param token
	 * @return
	 */
	public static String cancelAll(String machine_code,String token){
		return methods.cancelAll(machine_code, token);
	}
	/**
	 * 设置声音
	 * @param machine_code
	 * @param response_type
	 * @param voice
	 * @param token
	 * @return
	 */
	public static String setsound(String machine_code,String response_type,String voice,String token){
		return methods.setSound(machine_code, response_type, voice, token);
	}
	/**
	 * 删除终端
	 * @param machine_code
	 * @param token
	 * @return
	 */
	public static String deleteprinter(String machine_code,String token){
		return methods.deletePrinter(machine_code, token);
	}
	/**
	 * 添加打印机
	 * @param machine_code
	 * @param msign
	 * @param token
	 * @return
	 */
	public static String addprinter(String machine_code,String msign,String token){
		return methods.addPrinter(machine_code, msign, token);
	}
	/**
	 * 打印机信息
	 * @param machine_code
	 * @param token
	 * @return
	 */
	public static String  getPrinterInfo(String machine_code,String token){
		return methods.getPrintInfo(machine_code, token);
	}
	/**
	 * 开关
	 * @param machine_code
	 * @param token
	 * @param response_type
	 * @return
	 */
	public static String shutdownrestart(String machine_code,String token,String response_type){
		return methods.shutDownRestart(machine_code, response_type, token);
	}
	
}
