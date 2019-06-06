package com.mfoyou.agent.web.utils.network;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;


/**
 * 此类用于获取网络请求源的一些基本信息
 * @author yp-tc-m-2681
 *
 */
public class WebUtils {

	/**
	 * 此方法用于获取发送请求的iP地址
	 * @param request请求对象
	 * @return 返回ip地址的字符形式
	 */
	public static String getIpAddr(HttpServletRequest request) {
		 String ipAddress = request.getHeader("X_FORWARD_FOR");
		 if(ipAddress == null)
			 ipAddress = request.getHeader("x-forwarded-for");
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
         {
             ipAddress = request.getHeader("Proxy-Client-IP");
         }
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
         {
             ipAddress = request.getHeader("WL-Proxy-Client-IP");
         }
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress))
         {
             ipAddress = request.getRemoteAddr();
             if(ipAddress.equals("127.0.0.1")){
                 //根据网卡取本机配置的IP
                 InetAddress inet=null;
                 try {
                     inet = InetAddress.getLocalHost();
                 } catch (UnknownHostException e) {
                    // e.printStackTrace();
                 }
                 ipAddress= inet.getHostAddress();
             }
         }
         //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
         if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
             if(ipAddress.indexOf(",")>0){
                 ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
             }
         }	 
		 return ipAddress; 

	}
	
	public static String getUserAgentMsg(HttpServletRequest request) {
		String uAString = request.getHeader("user-agent");
		if (uAString == null) {
			return "";
		}
		return uAString;
	}
	
	public static long getRequestAttribute(HttpServletRequest request,String name){
		String valueString  = request.getAttribute(name).toString();
		if(valueString== null)return 0;
		return Long.parseLong(valueString);
		
	}

    public static String getSiteDomain(HttpServletRequest request){
    	if(request.getServerPort()==80){
    		 return request.getServerName();
    	}
        return request.getServerName() + ":" + request.getServerPort();
    }
    
    public static String getFileext(MultivaluedMap<String, String> header) {  
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");  
        for (String filename : contentDisposition) {  
            if ((filename.trim().startsWith("filename"))) {  
                String[] name = filename.split("=");  
                String finalFileName = name[1].trim().replaceAll("\"", "");
                int index = finalFileName.lastIndexOf(".");
                if( index > 0){
                	return finalFileName.substring(index+1);
                }
                return finalFileName;  
            }  
        }  
        return "unknown";  
    } 
    public static String getFileName(MultivaluedMap<String, String> header) {  
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");  
        for (String filename : contentDisposition) {  
            if ((filename.trim().startsWith("filename"))) {  
                String[] name = filename.split("=");
                String finalFileName = name[1].trim().replaceAll("\"", "");
                try {
					return new String(finalFileName.getBytes("GBK"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} 
            }  
        }  
        return "unknown";  
    } 
    public static String getFileext(String header) { 
        if(header == null)return "unknown";
        int index = header.lastIndexOf(".");
        if( index > 0){
            return header.substring(index+1);
        }
        return "unknown";  
    } 
    
    public static String getFilename(MultivaluedMap<String, String> header) throws UnsupportedEncodingException {  
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");  
        for (String filename : contentDisposition) { 
        	//filename = new String(filename.getBytes(),"ISO8859-1");
            if ((filename.trim().startsWith("filename"))) {  
                String[] name = filename.split("=");  
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;  
            }  
        }  
        return "unknown";  
    } 
}
