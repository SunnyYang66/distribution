package org.mfoyou.agent.utils.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * jsoup封装 去除代理ip获取
 * 
 * 2015年5月21日 下午2:48:43
 *
 * @author lintao.xing
 */
public class SpiderJsoupUtil {
//	private static final Logger log = LoggerFactory
//			.getLogger(SpiderJsoupUtil.class);
	/**
	 * 手机端头信息
	 */
	public static final String Mobile = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";

	/**
	 * PC端头信息
	 */
	public static final List<String> AGENTS = Arrays.asList(new String[]{
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:38.0) Gecko/20100101 Firefox/38.0",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/600.6.3 (KHTML, like Gecko) Version/8.0.6 Safari/600.6.3",
			    "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.43 Safari/537.31",
		        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17",
		        "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:15.0) Gecko/20100101 Firefox/15.0.1",
		        "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9a3pre) Gecko/20070330",
		        "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.13; ) Gecko/20101203",
		        "Opera/9.80 (X11; Linux x86_64; U; fr) Presto/2.9.168 Version/11.50",
		        "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; de) Presto/2.9.168 Version/11.52",
		        "Mozilla/5.0 (Windows; U; Win 9x 4.90; SG; rv:1.9.2.4) Gecko/20101104 Netscape/9.1.0285",
		        "Mozilla/5.0 (Macintosh; U; PPC Mac OS X Mach-O; en-US; rv:1.8.1.7pre) Gecko/20070815 Firefox/2.0.0.6 Navigator/9.0b3",
		        "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.1.12) Gecko/20080219 Firefox/2.0.0.12 Navigator/9.0.0.6"
	});
	/*
	 * jsoup获取content 默认Post请求
	 * 
	 * @param url
	 *            反问的url
	 * @param data
	 *            参数
	 * @param cookies
	 * @return
	 * @throws IOException
	 *             2015年5月29日 上午10:39:14
	 * @author lintao.xing
	 */
	public static Response getContent(String url, Map<String, String> data,
			Map<String, String> cookies) throws Exception {
		return getContent(url, data, cookies, Method.GET, null, null, 0, 0);
	}

	/**
	 * 
	 * jsoup获取content 不使用代理IP 默认不重试
	 * 
	 * @param url
	 *            反问的url
	 * @param data
	 *            参数
	 * @param cookies
	 * @param method
	 *            方法 默认POST
	 * @return
	 * @throws IOException
	 *             2015年5月29日 上午10:38:01
	 * @author lintao.xing
	 */
	public static Response getContent(String url, Map<String, String> data,
			Map<String, String> cookies, Method m) throws Exception {
		return getContent(url, data, cookies, m, null, null, 0, 0);
	}

	/**
	 * jsoup获取content 不使用代理ip
	 * 
	 * @param url
	 *            反问的url
	 * @param data
	 *            参数
	 * @param cookies
	 * @param method
	 *            方法 默认POST
	 * @param retry
	 *            重试次数 0代表不重试
	 * @return
	 * @throws IOException
	 *             2015年5月29日 上午10:34:22
	 * @author lintao.xing
	 */
	public static Response getContent(String url, Map<String, String> data,
			Map<String, String> cookies, Method method, int retry)
			throws Exception {
		return getContent(url, data, cookies, method, null, null, 0, retry);
	}
	public static Response getContent(String url, Map<String, String> data,
			Map<String, String> cookies, Method method,Map<String, String> header)
			throws Exception {
		return getContent(url, data, cookies, method, header, null, 0, 0);
	}
	/**
	 * jsoup获取content 默认重试3次
	 * 
	 * @param url
	 *            反问的url
	 * @param data
	 *            参数
	 * @param cookies
	 * @param method
	 *            方法 默认POST
	 * @param header
	 *            消息头
	 * @param ip
	 *            代理Ip
	 * @param port
	 *            代理IP端口
	 * @return
	 * @throws IOException
	 *             代理ip异常或者url异常怎抛异常 2015年5月29日 上午10:31:52
	 * @author lintao.xing
	 */
	public static Response getContent(String url, Map<String, String> data,
			Map<String, String> cookies, Method method,
			Map<String, String> header, String ip, int port) throws Exception {
		return getContent(url, data, cookies, method, header, ip, port, 0);
	}

	/**
	 * jsoup获取content
	 * 
	 * @param url
	 *            反问的url
	 * @param data
	 *            参数
	 * @param cookies
	 * @param method
	 *            方法 默认POST
	 * @param header
	 *            消息头
	 * @param ip
	 *            代理Ip
	 * @param port
	 *            代理IP端口
	 * @param retry
	 *            重试次数 0代表不重试
	 * @return
	 * @throws IOException
	 *             代理ip异常或者url异常怎抛异常 2015年5月29日 上午10:31:52
	 * @author lintao.xing
	 */
	public static Response getContent(String url, Map<String, String> data,
			Map<String, String> cookies, Method method,
			Map<String, String> header, String ip, int port, int retry)
			throws Exception {
		try {
			HttpsHepper.trustAllHttpsCertificates();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpsURLConnection.setDefaultHostnameVerifier(HttpsHepper.hv);
		Connection conn = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
				.followRedirects(true).timeout(6000).userAgent(AGENTS.get(new Random().nextInt(AGENTS.size())))
				.maxBodySize(Integer.MAX_VALUE);
		if(null!= header && header.containsKey("User-Agent")){
			conn.userAgent(header.get("User-Agent"));
		}
		if (null != data) {
			conn.data(data);
		}
		if (null != method) {
			conn.method(method);
		} else {
			conn.method(Method.POST);
		}
		if (null != cookies) {
			conn.cookies(cookies);
		}
		if (null != header && !header.isEmpty()) {
			for (String key : header.keySet()) {
				conn.header(key, header.get(key));
			}
		}
		if (StringUtils.isNotBlank(ip) && port != 0) {
			conn.proxy( ip, port);
		}

		Response res = null;
		Exception ioE = null;
		if (retry > 0) {
			while (retry > 0) {
				try {
					res = conn.execute();
				} catch (Exception e) {
					res = null;
					ioE = e;
					System.out.println("jsoup链接失败 url:"+url+" ip:"+ip+" 重试");
				}
				retry--;
				if (null != res) {
					break;
				}
			}
		} else {
			return conn.execute();
		}
		if (res == null)
			throw ioE;
		else
			return res;
	}

//	public static Response getDocument(String url, Map<String, String> data,
//			Map<String, String> cookies, Map<String, String> header, String ip,
//			int port, int retry) throws IOException {
//		Connection conn = Jsoup.connect(url).ignoreContentType(true)
//				.followRedirects(true).timeout(10000).userAgent(AGENTS.get(new Random().nextInt(AGENTS.size())))
//				.maxBodySize(Integer.MAX_VALUE);
//		if (null != data) {
//			conn.data(data);
//		}
//
//		if (null != cookies) {
//			conn.cookies(cookies);
//		}
//		if (null != header && !header.isEmpty()) {
//			for (String key : header.keySet()) {
//				conn.header(key, header.get(key));
//			}
//		}
//		if (StringUtils.isNotBlank(ip) && port != 0) {
//			conn.proxy(Proxy.Type.HTTP, ip, port);
//		}
//		Response res = null;
//		IOException es = null;
//		do {
//			try {
//				retry--;
//				res = conn.execute();
//			} catch (IOException e) {
//				es = e;
//				res = null;
//				log.error("jsoup链接失败 url:{} ip:{} 重试",url, ip);
//			}
//
//		} while (res == null && retry > 0);
//		if (null == res) {
//			throw es;
//		}
//		return res;
//	}

	public static boolean isIpAvailable(String url, String ip, int port) {
		boolean result = false;
		Connection conn = null;
		try {
			conn = Jsoup.connect(url).ignoreContentType(true)
					.followRedirects(true).timeout(10000).userAgent(AGENTS.get(new Random().nextInt(AGENTS.size())))
					.maxBodySize(Integer.MAX_VALUE);
			if (StringUtils.isNotBlank(ip) && port != 0) {
				conn.proxy(ip, port);
			}
			conn.execute();
			result = true;
		} catch (Exception e1) {
			 e1.printStackTrace();
		}
		return result;
	}

//	public static void main(String[] args) throws Exception {
//		String url = "http://gsxt.gdgs.gov.cn/aiccips/";
//		Map<String, String> data = new HashMap<String, String>();
//		Response content = getContent(url, null, null, Method.POST, null);
//		
//		System.out.println(content.body());
//	}
}