package org.mfoyou.agent.utils.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.mfoyou.agent.utils.wx.XMLParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;



public class StringUtils {
	static Logger logger = LoggerFactory.getLogger(StringUtils.class);
	public static String getRandomStringByLength(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getSign(Object o, String key) throws IllegalAccessException {
		ArrayList<String> list = new ArrayList<String>();
		Class<? extends Object> cls = o.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			if (f.get(o) != null && f.get(o) != "") {
				String name = f.getName();
				// 处理package关键字
				name = packageKeyword(name);
				list.add(name + "=" + f.get(o) + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		logger.info("Sign Before MD5: " + result);
		result = MD5Utils.md5(result).toUpperCase();
		logger.info("Sign Result: " + result);
		return result;
	}
	public static void main(String[] args) throws IllegalAccessException, ParserConfigurationException, IOException, SAXException {
		String data = "<xml><appid><![CDATA[wx770b291798844888]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1439754402]]></mch_id><nonce_str><![CDATA[svvimsjxwejltg0gbpb4us01usy6z55b]]></nonce_str><openid><![CDATA[oCIUM5NDm392bVVsftGq7Pp2hN0U]]></openid><out_trade_no><![CDATA[null1524107306863]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[638902FB3C539C0CD314520ABE863B1A]]></sign><time_end><![CDATA[20180419110839]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4200000086201804191635895303]]></transaction_id></xml>";
		boolean checkIsSignValidFromResponseString = checkIsSignValidFromResponseString(data,"HUAwu24mf26oyou26TEchnol934ogy12");
		System.out.println(checkIsSignValidFromResponseString);
	}
	private static String packageKeyword(String name) {
		if ("_package".equals(name)) {
			name = "package";
		}
		return name;
	}

	public static boolean checkIsSignValidFromResponseString(String responseString, String key)
			throws ParserConfigurationException, IOException, SAXException, IllegalAccessException {
		Map<String, String> map = XMLParse.getMapFromXML(responseString);
		logger.debug(map.toString());
		String signFromAPIResponse = map.get("sign").toString();
		if (signFromAPIResponse == null || signFromAPIResponse.isEmpty()) {
			logger.warn("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
			return false;
		}
		map.put("sign", "");
		String signForAPIResponse = getSign(map, key);
		if (!signForAPIResponse.equals(signFromAPIResponse)) {
			// 签名验不过，表示这个API返回的数据有可能已经被篡改了
			logger.warn("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
			return false;
		}
		return true;
	}

	public static String getSign(Map<String, String> map, String key) {
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue() != "") {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		logger.debug("Sign Before MD5: " + result);
		result = MD5Utils.md5(result).toUpperCase();
		logger.debug("Sign Result: " + result);
		return result;
	}

	public static String getSecrteString(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM:dd");
		String dataString = simpleDateFormat.format(new Date());
		String result = MD5Utils.md5(dataString);
		return result;
	}
	 public static String filterEmoji(String source) {
	        if (source != null) {
	            Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
	            Matcher emojiMatcher = emoji.matcher(source);
	            if (emojiMatcher.find()) {
	                source = emojiMatcher.replaceAll("*");
	                return source;
	            }
	            return source;
	        }
	        return source;
	    }
}
